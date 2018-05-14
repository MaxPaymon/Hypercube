package duff.ru.hypercube.GameComponents;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import duff.ru.hypercube.View.FragmentGame;

/**
 * Created by maks on 15.04.18.
 */

public class ButtonNext extends android.support.v7.widget.AppCompatButton {
    public ButtonNext(final FragmentActivity context) {
        super(context);

        this.setText("Далее");
        this.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentGame.playButtonAnswerSound();
                FragmentGame.nextElementOfLevel(context);
            }
        });

    }
}
