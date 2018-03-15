package duff.ru.hypercube.Game;

import java.util.ArrayList;

/**
 * Created by maks on 15.03.18.
 */

public class Level {

    int id;
    ArrayList<ElementsOfLevel> elementsOfGames;

    public Level(int id, ArrayList<ElementsOfLevel> elementsOfGames) {
        this.id = id;
        this.elementsOfGames = elementsOfGames;
    }

    public ArrayList<ElementsOfLevel> getElementsOfGames() {
        return elementsOfGames;
    }

    public int getId() {
        return id;
    }
}
