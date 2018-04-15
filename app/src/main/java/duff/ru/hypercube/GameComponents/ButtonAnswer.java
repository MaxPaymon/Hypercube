package duff.ru.hypercube.GameComponents;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import duff.ru.hypercube.Game.Answer;
import duff.ru.hypercube.Utils.Utils;
import duff.ru.hypercube.View.FragmentGame;

/**
 * Created by maks on 16.03.18.
 */

@SuppressLint("AppCompatCustomView")
public class ButtonAnswer extends Button {

    int id;
    Answer answer;

    public ButtonAnswer(final Context context, final Answer answer, int id) {
        super(context);
        this.answer = answer;
        this.id = id;

        this.setText(answer.getText());
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentGame.checkAnswer(answer);
                FragmentGame.playButtonAnswerSound();
            }
        });

    }

    public Answer getAnswer() {
        return answer;
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        super.setOnClickListener(l);


    }

    @Override
    public int getId() {
        return id;
    }
}
