package duff.ru.hypercube.GameComponents;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Button;

/**
 * Created by maks on 16.03.18.
 */

@SuppressLint("AppCompatCustomView")
public class ButtonAnswer extends Button {

    int id;

    public ButtonAnswer(Context context, int id) {
        super(context);

        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }
}
