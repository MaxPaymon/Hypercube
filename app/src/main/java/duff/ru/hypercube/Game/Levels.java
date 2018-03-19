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
        final Dialog dialog1 = new Dialog("Привет " + Player.name + "!", null, R.mipmap.ic_hypercube);
        final Dialog dialog2 = new Dialog("Меня зовут Гиперкуб!, Я буду сопровождать тебя по этой игре!", null, R.drawable.ic_start);
        final Dialog dialog3 = new Dialog("Давай обговорим некоторые правила!", "Давай!", R.drawable.ic_start);
        final Dialog dialog4 = new Dialog("В моей вселенной есть всего 4 ресурса:", null, R.drawable.ic_start);
        final Dialog dialog5 = new Dialog("Пиксели -", null, R.drawable.ic_start);
        final Dialog dialog6 = new Dialog("Диафрагма -", null, R.drawable.ic_start);
        final Dialog dialog7 = new Dialog("Хексы -", null, R.drawable.ic_start);
        final Dialog dialog8 = new Dialog("Фортуна -", "Ага, круто", R.drawable.ic_start);
        final Dialog dialog9 = new Dialog("Так же по мимо простых диалогов, тебе придется сталкиваться с заданиями", null,  R.drawable.ic_start);
        final Dialog dialog10 = new Dialog("Что бы их выполнить, придется внимательно следить за тем, кто и что говороит", null,  R.drawable.ic_start);
        final Dialog dialog11 = new Dialog("За каждое выполненое задание, ты будешь получать награду, в виде ресурсов, о которых я говорил ранее", "Хорошо", R.drawable.ic_start);
        final Dialog dialog12 = new Dialog("Ну что? Попробуешь выполнить свое первое задание?", "Вперед!", R.drawable.ic_start);

        final ArrayList<ElementsOfLevel> elementsOfGames = new ArrayList<>();

        elementsOfGames.add(dialog1);
        elementsOfGames.add(dialog2);
        elementsOfGames.add(dialog3);
        elementsOfGames.add(dialog4);
        elementsOfGames.add(dialog5);
        elementsOfGames.add(dialog6);
        elementsOfGames.add(dialog7);
        elementsOfGames.add(dialog8);
        elementsOfGames.add(dialog9);
        elementsOfGames.add(dialog10);
        elementsOfGames.add(dialog11);
        elementsOfGames.add(dialog12);
        levelOne = new Level(1, elementsOfGames);
        return levelOne;
    }

    public static Level createLevelTwo() {
        final Dialog dialog1 = new Dialog("Ура, ты перешел на второй уровень!", "Отлично", R.mipmap.ic_hypercube);
        final ArrayList<ElementsOfLevel> elementsOfGames = new ArrayList<>();

        elementsOfGames.add(dialog1);
        levelTwo = new Level(2, elementsOfGames);
        return levelTwo;
    }

    public static void loadAllLevels() {
        levelsArrayList.add(createLevelOne());
        levelsArrayList.add(createLevelTwo());
    }




}
