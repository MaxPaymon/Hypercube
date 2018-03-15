package duff.ru.hypercube.Game;

import android.os.Bundle;

import java.util.ArrayList;

import duff.ru.hypercube.Player;
import duff.ru.hypercube.R;

/**
 * Created by maks on 16.03.18.
 */

public class Levels {



    public static Level levelOne;
    public static Level levelTwo;

    public static ArrayList<Level> levelsArrayList = new ArrayList<>();


    public static Level createLevelOne() {
        final Dialog dialog1 = new Dialog("Привет " + Player.name + "!", R.mipmap.ic_hypercube);
        final Dialog dialog2 = new Dialog("Меня зовут Гиперкуб!", R.drawable.ic_start);
        final ArrayList<ElementsOfLevel> elementsOfGames = new ArrayList<>();

        elementsOfGames.add(dialog1);
        elementsOfGames.add(dialog2);
        levelOne = new Level(1, elementsOfGames);
        return levelOne;
    }

    public static Level createLevelTwo() {
        final Dialog dialog1 = new Dialog("Ура, ты перешел на второй уровень!", R.mipmap.ic_hypercube);
        final Dialog dialog2 = new Dialog("Я буду продвигать тебя по этой игре!", R.drawable.ic_start);
        final ArrayList<ElementsOfLevel> elementsOfGames = new ArrayList<>();

        elementsOfGames.add(dialog1);
        elementsOfGames.add(dialog2);
        levelTwo = new Level(2, elementsOfGames);
        return levelTwo;
    }

    public static void loadAllLevels() {
        levelsArrayList.add(createLevelOne());
        levelsArrayList.add(createLevelTwo());
    }




}
