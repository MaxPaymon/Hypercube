package duff.ru.hypercube.Game;

/**
 * Created by maks on 15.03.18.
 */

public class Answer {

    String text;
    int id;

    public Answer(int id, String text) {
        this.text = text;
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }
}
