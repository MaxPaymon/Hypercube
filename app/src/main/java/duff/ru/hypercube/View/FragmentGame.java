package duff.ru.hypercube.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
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
import duff.ru.hypercube.Player;
import duff.ru.hypercube.R;

/**
 * Created by maks on 15.03.18.
 */

public class FragmentGame extends Fragment {

    private TextView pixels;
    private TextView diaphragms;
    private TextView hexes;
    private TextView fortune;

    private TextView dialogText;

    private ImageView picture;

    private ButtonAnswer buttonAnswerOne;
    private ConstraintLayout buttonsLayout;

    private ArrayList<ElementsOfLevel> elementsOfLevelArrayList = new ArrayList<>();

    public int levelProgressId = 0;

    private View view;

    private Button nextButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println(Player.progress);
        setLevel(getLevelById(Player.progress));

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_game, container, false);

        pixels = view.findViewById(R.id.fragment_game_pixels_text_view);
        diaphragms = view.findViewById(R.id.fragment_game_diaphragms_text_view);
        hexes = view.findViewById(R.id.fragment_game_hexes_text_view);
        fortune = view.findViewById(R.id.fragment_game_fortune_text_view);

        buttonsLayout = view.findViewById(R.id.fragment_game_buttons_layout);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        buttonsLayout.getLayoutParams().height = displayMetrics.heightPixels / 6;

        dialogText = view.findViewById(R.id.fragment_game_quest_text_view);

        picture = view.findViewById(R.id.fragment_game_picture_image_view);

        buttonAnswerOne = new ButtonAnswer(getActivity(), new Answer(1, "Ок").getId());


        nextButton = new Button(getActivity());
        nextButton.setText("Далее");
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextElementOfLevel();
            }
        });

        setStats();
        setInfoToView(levelProgressId);

        return view;
    }

    public void setInfoToView(int questProgressId){
        buttonsLayout.removeAllViews();

        Object elementOfLevel = elementsOfLevelArrayList.get(questProgressId);

        if (elementOfLevel instanceof Dialog) {
            dialogText.setText(((Dialog) elementOfLevel).getText());
            picture.setImageResource(((Dialog) elementOfLevel).getPicture());
            buttonsLayout.addView(nextButton, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        } else if (elementOfLevel instanceof Quest) {
//            elementOfLevel.
        }

    }

    public void nextLevel(){
        if (Player.progress != Levels.levelsArrayList.size()) {
            setLevel(getLevelById(Player.progress));
        } else {
            Toast.makeText(getActivity(), "Поздравляем! Вы прошли игру!", Toast.LENGTH_SHORT).show();
        }
    }

    public void nextElementOfLevel(){
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

    public void setLevel(Level level) {

        elementsOfLevelArrayList = level.getElementsOfGames();
        if (view != null) {
            setInfoToView(levelProgressId);
        }

    }

    public void setStats() {
        pixels.setText(String.valueOf(Player.pixels));
        diaphragms.setText(String.valueOf(Player.diaphragms));
        hexes.setText(String.valueOf(Player.hexes));
        fortune.setText(String.valueOf(Player.fortune));
    }

    public Level getLevelById(int levelId) {
        return Levels.levelsArrayList.get(levelId);
    }
}
