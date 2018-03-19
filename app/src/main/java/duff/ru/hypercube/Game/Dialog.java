package duff.ru.hypercube.Game;

import android.support.annotation.Nullable;

import java.util.ArrayList;

/**
 * Created by maks on 16.03.18.
 */

public class Dialog extends ElementsOfLevel {

    String text;
    String buttonText;
    int picture;
    ArrayList<String> texts;

    public Dialog(String text, @Nullable String buttonText, int picture) {
        this.text = text;
        this.picture = picture;
        this.buttonText = buttonText;
    }

    public Dialog(ArrayList<String> texts, int picture) {
        this.texts = texts;
        this.picture = picture;
    }

    public String getTextById(int id) {
        return texts.get(id);
    }

    public String getText() {
        return text;
    }

    public String getButtonText() {
        return buttonText;
    }

    public int getPicture() {
        return picture;
    }
}
