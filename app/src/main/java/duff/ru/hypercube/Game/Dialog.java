package duff.ru.hypercube.Game;

import java.util.ArrayList;

/**
 * Created by maks on 16.03.18.
 */

public class Dialog extends ElementsOfLevel {

    String text;
    int picture;
    ArrayList<String> texts;

    public Dialog(String text, int picture) {
        this.text = text;
        this.picture = picture;
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

    public int getPicture() {
        return picture;
    }
}
