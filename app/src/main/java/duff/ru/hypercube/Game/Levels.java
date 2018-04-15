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
        final Dialog dialog1 = new Dialog("Привет " + Player.name + "!", null, R.drawable.sprite_cube);
        final Dialog dialog2 = new Dialog("Меня зовут Гиперкуб!, Я буду сопровождать тебя по этой игре!", null, R.drawable.sprite_cube);
        final Dialog dialog3 = new Dialog("Давай обговорим некоторые правила! Их совсем не много.", "Давай", R.drawable.sprite_cube);
        final Dialog dialog4 = new Dialog("В моей вселенной есть всего 4 ресурса:", null, R.drawable.sprite_cube);
        final Dialog dialog5 = new Dialog("Пиксели -", null, R.drawable.sprite_pixel);
        final Dialog dialog6 = new Dialog("Диафрагма -", null, R.drawable.sprite_diaphragm);
        final Dialog dialog7 = new Dialog("Хексы -", null, R.drawable.sprite_hex);
        final Dialog dialog8 = new Dialog("Фортуна -", "Ага, круто", R.drawable.sprite_fortune);
        final Dialog dialog9 = new Dialog("Так же помимо простых диалогов, тебе придется сталкиваться с заданиями", null,  R.drawable.sprite_cube);
        final Dialog dialog10 = new Dialog("Что бы их выполнить, придется внимательно следить за тем, кто и что говороит", null,  R.drawable.sprite_cube);
        final Dialog dialog11 = new Dialog("За каждое выполненое задание, ты будешь получать награду, в виде ресурсов, о которых я говорил ранее", "Хорошо", R.drawable.sprite_cube);
        final Dialog dialog12 = new Dialog("Ну что? Попробуешь выполнить свое первое задание?", "Вперед!", R.drawable.sprite_cube);
        final Dialog dialog13 = new Dialog("Zdfgdfg", null, R.drawable.sprite_cube);

        final ArrayList<Answer> answer1l1q = new ArrayList<>();

        answer1l1q.add(new Answer(0, "1"));
        answer1l1q.add(new Answer(0, "4"));
        answer1l1q.add(new Answer(0, "14"));
        answer1l1q.add(new Answer(0, "3"));

        final Quest quest1 = new Quest("Сколько видов ресурсов существует?", "4", "Увы, но ты ответил не правильно. Не расстраивайся, главное будь внимателен в следующий раз!", "Отлично! Ты схватываешь на лету. Продолжай в том же духе!", answer1l1q, new Reward(1, 1,1,1), R.drawable.sprite_cube, R.drawable.sprite_cube, R.drawable.sprite_cube);

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
        elementsOfGames.add(quest1);
        elementsOfGames.add(dialog13);
        levelOne = new Level(1, elementsOfGames);
        return levelOne;
    }

    public static Level createLevelTwo() {
        final Dialog dialog1 = new Dialog("Поздравляю, ты перешел на второй уровень!", "Отлично", R.mipmap.ic_hypercube);
        final Dialog dialog2 = new Dialog("Смотри! Теперь у тебя есть некоторое количество всех ресурсов!", "Ага", R.mipmap.ic_hypercube);
        final Dialog dialog3 = new Dialog("Они помогут тебе пройти дальше.", null, R.mipmap.ic_hypercube);
        final Dialog dialog4 = new Dialog("Будь внимателен! От этих ресурсов записит все!.", null, R.mipmap.ic_hypercube);
        final Dialog dialog5 = new Dialog("Хорошо. Тогда продолжим. Я рсскажу тебе историю моей вселенной.", "Давай", R.mipmap.ic_hypercube);
        final Dialog dialog6 = new Dialog("В далеком 200180 столетии, всюду царил хаос и разруха.", null, R.mipmap.ic_hypercube);
        final Dialog dialog7 = new Dialog("Но спустя 5 столейтий, появился он, герой и наш спаситель - Сompass.", null, R.mipmap.ic_hypercube);
        final Dialog dialog8 = new Dialog("Они помогут тебе пройти дальше.", null, R.mipmap.ic_hypercube);
        final Dialog dialog9 = new Dialog("Они помогут тебе пройти дальше.", null, R.mipmap.ic_hypercube);
        final Dialog dialog10 = new Dialog("Они помогут тебе пройти дальше.", null, R.mipmap.ic_hypercube);
        final ArrayList<ElementsOfLevel> elementsOfGames = new ArrayList<>();

        elementsOfGames.add(dialog1);
        levelTwo = new Level(2, elementsOfGames);
        return levelTwo;
    }

    public static void loadAllLevels() {
        levelsArrayList.clear();
        levelsArrayList.add(createLevelOne());
        levelsArrayList.add(createLevelTwo());
    }




}
