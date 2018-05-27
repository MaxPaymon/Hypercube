package duff.ru.hypercube.Game;

import android.support.annotation.Nullable;

import java.util.ArrayList;

/**
 * Created by maks on 16.03.18.
 */

public class Dialog extends ElementsOfLevel {

    public String text;
    public String buttonText;
    public String picture;

    public Dialog(String text, @Nullable String buttonText, String picture) {
        this.text = text;
        this.picture = picture;
        this.buttonText = buttonText;
    }



    public String getText() {
        return text;
    }

    public String getButtonText() {
        return buttonText;
    }

    public String getPicture() {
        return picture;
    }
}
