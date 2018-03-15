package duff.ru.hypercube.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import duff.ru.hypercube.Player;
import duff.ru.hypercube.R;
import duff.ru.hypercube.Utils.Utils;

/**
 * Created by maks on 15.03.18.
 */

public class FragmentMainMenu extends Fragment {

    private Button startGame;
    private Button exit;

    private FragmentManager fragmentManager;
    private FragmentActivity activity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.activity = getActivity();
        this.fragmentManager = activity.getSupportFragmentManager();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main_menu, container, false);

        startGame = view.findViewById(R.id.fragment_main_menu_start_game_button);
        exit = view.findViewById(R.id.fragment_main_menu_exit_button);

        if (Player.progress > -1) {
            startGame.setText("Продолжить игру");
        }

        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Player.progress > -1) {
                    Utils.replaceFragmentWithAnimationFade(fragmentManager, new FragmentGame(), null, true);
                } else {
                    Utils.replaceFragmentWithAnimationFade(fragmentManager, new FragmentNewGame(), null, true);
                }
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });

        return view;
    }
}
