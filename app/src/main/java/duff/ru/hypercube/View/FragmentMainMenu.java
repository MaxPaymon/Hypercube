package duff.ru.hypercube.View;

import android.content.DialogInterface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import duff.ru.hypercube.Player;
import duff.ru.hypercube.R;
import duff.ru.hypercube.Utils.Utils;
import static duff.ru.hypercube.Config.*;


/**
 * Created by maks on 15.03.18.
 */

public class FragmentMainMenu extends Fragment {

    private Button startGame;
    private Button continueGame;
    private Button exit;

    private FragmentManager fragmentManager;
    private FragmentActivity activity;

    private Bundle bundle;

    private MediaPlayer mediaPlayer;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bundle = getArguments();

        this.activity = getActivity();
        this.fragmentManager = activity.getSupportFragmentManager();

        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.button_menu);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main_menu, container, false);

        startGame = view.findViewById(R.id.fragment_main_menu_start_game_button);
        continueGame = view.findViewById(R.id.fragment_main_menu_continue_button);
        exit = view.findViewById(R.id.fragment_main_menu_exit_button);

        if (Player.progress > -1) {
            continueGame.setVisibility(View.VISIBLE);
        } else {
            continueGame.setVisibility(View.GONE);
        }

        continueGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                if (bundle != null) {
                    if (bundle.containsKey(OPEN_MENU_FROM_GAME)) {
                        getActivity().onBackPressed();
                    }
                } else {
                    activity.getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    Utils.replaceFragmentWithAnimationFade(fragmentManager, new FragmentGame(), null, true);
                }
            }
        });

        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();

                if (Player.progress > -1) {
                    new AlertDialog.Builder(getActivity())
                            .setTitle("Новая игра")
                            .setMessage(String.format("Вы дошли до %s уровня. Вы уверены, что хотите начать новую игру?", Player.progress + 1))
                            .setNegativeButton("Нет", null)
                            .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Player.setDefaultSettings();
                                    Player.saveAllSettings();
                                    Utils.replaceFragmentWithAnimationFade(fragmentManager, new FragmentNewGame(), null, true);
                                }
                            }).show();
                } else {
                    Utils.replaceFragmentWithAnimationFade(fragmentManager, new FragmentNewGame(), null, true);
                }
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                getActivity().finish();
            }
        });

        return view;
    }
}
