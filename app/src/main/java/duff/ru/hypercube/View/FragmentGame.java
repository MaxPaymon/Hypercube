package duff.ru.hypercube.View;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import duff.ru.hypercube.Game.Answer;
import duff.ru.hypercube.Game.Dialog;
import duff.ru.hypercube.Game.ElementsOfLevel;
import duff.ru.hypercube.Game.Level;
import duff.ru.hypercube.Game.Levels;
import duff.ru.hypercube.Game.Quest;
import duff.ru.hypercube.GameComponents.ButtonAnswer;
import duff.ru.hypercube.GameComponents.ButtonNext;
import duff.ru.hypercube.Player;
import duff.ru.hypercube.R;
import duff.ru.hypercube.Utils.Utils;

import static android.content.ContentValues.TAG;
import static duff.ru.hypercube.Config.*;


/**
 * Created by maks on 15.03.18.
 */

public class FragmentGame extends Fragment {

    private static FragmentActivity activity;

    private static MediaPlayer mediaPlayer;
    
    private static TextView pixels;
    private static TextView diaphragms;
    private static TextView hexes;
    private static TextView fortune;

    private static TextView levelGame;

    private static Button goToMenu;

    private static TextView dialogText;

    private static ImageView picture;

    private static LinearLayout buttonsLayout;

    private static ArrayList<ElementsOfLevel> elementsOfLevelArrayList = new ArrayList<>();

    public static int levelProgressId = 0;

    private static View view;

    private static ButtonNext nextButton;
    
    public static String trueAnswer;

    public static Quest questNow;

    private static Object elementOfLevel;

    private static  LinearLayout.LayoutParams paramsDialog;
    private static  LinearLayout.LayoutParams paramsQuest;

    static int oldPicture;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.activity = getActivity();
        questNow = new Quest();

        mediaPlayer = MediaPlayer.create(activity, R.raw.button_answer);

        restartProgressLevel();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_game, container, false);

        pixels = view.findViewById(R.id.fragment_game_pixels_text_view);
        diaphragms = view.findViewById(R.id.fragment_game_diaphragms_text_view);
        hexes = view.findViewById(R.id.fragment_game_hexes_text_view);
        fortune = view.findViewById(R.id.fragment_game_fortune_text_view);

        levelGame = view.findViewById(R.id.fragment_game_level_text_view);
        levelGame.setText(String.format("Уровень %s", Player.progress+1));

        buttonsLayout = view.findViewById(R.id.fragment_game_buttons_layout);

        paramsDialog = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        paramsDialog.gravity = Gravity.CENTER;

        paramsQuest = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        paramsQuest.setMargins(8, 0, 8, 0);
        paramsQuest.weight = (float) 0.25;
        paramsQuest.gravity = Gravity.CENTER;

        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        buttonsLayout.getLayoutParams().height = displayMetrics.heightPixels / 6;

        dialogText = view.findViewById(R.id.fragment_game_quest_text_view);

        picture = view.findViewById(R.id.fragment_game_picture_image_view);

        goToMenu = view.findViewById(R.id.fragment_game_menu_button);

        nextButton = new ButtonNext(activity);

        goToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt(OPEN_MENU_FROM_GAME, 1);

                FragmentMainMenu fragmentMainMenu = new FragmentMainMenu();
                fragmentMainMenu.setArguments(bundle);

                Utils.replaceFragmentWithAnimationFade(activity.getSupportFragmentManager(), fragmentMainMenu, null, true);
            }
        });

        updateStats();
        setLevel(getLevelById(Player.progress));

        return view;
    }

    public static void setInfoToView(int questProgressId){
        buttonsLayout.removeAllViews();

        elementOfLevel = elementsOfLevelArrayList.get(questProgressId);

        if (elementOfLevel instanceof Dialog) {
            dialogText.setText(((Dialog) elementOfLevel).getText());

            if (((Dialog) elementOfLevel).getPicture() != oldPicture) {
                picture.setImageResource(0);
                picture.setImageResource(((Dialog) elementOfLevel).getPicture());
                oldPicture = ((Dialog) elementOfLevel).getPicture();
                System.out.println("set new Picture");
            } else {
                System.out.println("Picture is old");
            }
            
            if (((Dialog) elementOfLevel).getButtonText() != null) {
                nextButton.setText(((Dialog) elementOfLevel).getButtonText().trim());
            }

            buttonsLayout.addView(nextButton, paramsDialog);

        } else if (elementOfLevel instanceof Quest) {
            questNow = (Quest) elementOfLevel;
            dialogText.setText(((Quest) elementOfLevel).getQuestion());
            picture.setImageResource(((Quest) elementOfLevel).getPicture());
            trueAnswer = ((Quest) elementOfLevel).getTrueAnswer();

            for (int i = 0;i < ((Quest) elementOfLevel).getAnswer().size(); i++)
                buttonsLayout.addView(new ButtonAnswer(activity, ((Quest) elementOfLevel).getAnswer().get(i), i), paramsQuest);
        }

    }

    public static void checkAnswer(Answer answer) {
        if (answer.getText().equals(trueAnswer)) {
            setInfoAfterAnswer(questNow,true);
            getRewardOfQuest(questNow);
        } else if (!answer.getText().equals(trueAnswer)){
            setInfoAfterAnswer(questNow,false);
        }
    }

    public static void setInfoAfterAnswer(Quest quest, boolean answer) {

        buttonsLayout.removeAllViews();
        picture.setImageResource(0);

        System.out.println(quest.getWinsDialog() + " " + quest.getWinsPicture());

        if (answer) {
            dialogText.setText(quest.getWinsDialog());
            picture.setImageResource(quest.getWinsPicture());
        } else {
            dialogText.setText(quest.getLoserDialog());
            picture.setImageResource(quest.getLoserPicture());
        }

        nextButton.setText("Далее");
        buttonsLayout.addView(nextButton, paramsDialog);
    }

    public static void getRewardOfQuest(Quest quest) {

        Player.pixels += quest.getReward().getPixels();
        Player.diaphragms += quest.getReward().getPixels();
        Player.hexes += quest.getReward().getPixels();
        Player.fortune += quest.getReward().getPixels();

        Player.saveStat();
        updateStats();
    }


    public static void nextLevel(){
        if (Player.progress != Levels.levelsArrayList.size()) {
            setLevel(getLevelById(Player.progress));
        } else {
            Player.progress--;
            Toast.makeText(activity, "Поздравляем! Вы прошли игру!", Toast.LENGTH_SHORT).show();
        }
    }

    public static void nextElementOfLevel(){
        if (levelProgressId != elementsOfLevelArrayList.size()-1) {
            levelProgressId++;
            setInfoToView(levelProgressId);
        } else {
            levelProgressId = 0;
            Player.progress++;
            Player.saveSettings();
            nextLevel();
        }
    }

    public static void setLevel(Level level) {

        elementsOfLevelArrayList = level.getElementsOfGames();
        if (view != null) {
            setInfoToView(levelProgressId);
            levelGame.setText(String.format("Уровень %s", Player.progress+1));
        }

    }

    public static void updateStats() {
        pixels.setText(String.valueOf(Player.pixels));
        diaphragms.setText(String.valueOf(Player.diaphragms));
        hexes.setText(String.valueOf(Player.hexes));
        fortune.setText(String.valueOf(Player.fortune));
    }

    public static Level getLevelById(int levelId) {
        return Levels.levelsArrayList.get(levelId);
    }

    public static void playButtonAnswerSound(){
        mediaPlayer.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        restartProgressLevel();

    }

    public static void restartProgressLevel() {
        levelProgressId = 0;
        oldPicture = 0;
        Log.d(TAG, "restartProgressLevel");

    }
}
