package duff.ru.hypercube.View;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import duff.ru.hypercube.Game.Levels;
import duff.ru.hypercube.Player;
import duff.ru.hypercube.R;
import duff.ru.hypercube.Utils.Utils;

/**
 * Created by maks on 15.03.18.
 */

public class FragmentNewGame extends Fragment {

    private EditText name;
    private ImageView startGame;

    private FragmentManager fragmentManager;
    private FragmentActivity activity;

    private static MediaPlayer mediaPlayer;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.activity = getActivity();
        this.fragmentManager = activity.getSupportFragmentManager();
        mediaPlayer = MediaPlayer.create(activity, R.raw.button_menu);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_new_game, container, false);

        name = view.findViewById(R.id.fragment_new_game_name_edit_text);
        startGame = view.findViewById(R.id.fragment_new_game_start_button);

        startGame.setVisibility(View.GONE);


        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                Player.name = name.getText().toString().trim();
                Player.progress = 0;
                Player.saveSettings();
                Levels.loadAllLevels();
                getActivity().getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                Utils.replaceFragmentWithAnimationFade(fragmentManager, new FragmentGame(), null, false);
            }
        });

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().isEmpty()) {
                    startGame.setVisibility(View.GONE);
                } else {
                    startGame.setVisibility(View.VISIBLE);
                }
            }
        });

        return view;
    }
}
