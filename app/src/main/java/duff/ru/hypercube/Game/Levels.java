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
    public static Level levelThree;
    public static Level levelFour;
    public static Level levelFive;
    public static Level levelSix;
    public static Level levelSeven;
    public static Level levelEight;
    public static Level levelNine;
    public static Level levelTen;

    public static ArrayList<Level> levelsArrayList = new ArrayList<>();


    public static Level createLevelOne() {
        final Dialog dialog1 = new Dialog("Привет " + Player.name + "!", null, R.drawable.sprite_cube);
        final Dialog dialog2 = new Dialog("Меня зовут Гиперкуб!, Я буду сопровождать тебя по этой игре!", null, R.drawable.sprite_cube);
        final Dialog dialog3 = new Dialog("Давай обговорим некоторые правила! Их совсем не много.", "Давай", R.drawable.sprite_cube);
        final Dialog dialog4 = new Dialog("В моей вселенной есть всего 4 ресурса:", null, R.drawable.sprite_cube);
        final Dialog dialog5 = new Dialog("Пиксели - валюта вселенной", null, R.drawable.sprite_pixel);
        final Dialog dialog6 = new Dialog("Диафрагма - помогут выживать", null, R.drawable.sprite_diaphragm);
        final Dialog dialog7 = new Dialog("Хексы - боеприпасы", null, R.drawable.sprite_hex);
        final Dialog dialog8 = new Dialog("Фортуна - поможет тебе избежать неприятностей", "Ага, круто", R.drawable.sprite_fortune);
        final Dialog dialog9 = new Dialog("Так же помимо простых диалогов, тебе придется сталкиваться с заданиями", null, R.drawable.sprite_cube);
        final Dialog dialog10 = new Dialog("Что бы их выполнить, придется внимательно следить за тем, кто и что говороит", null, R.drawable.sprite_cube);
        final Dialog dialog11 = new Dialog("За каждое выполненое задание, ты будешь получать награду, в виде ресурсов, о которых я говорил ранее", "Хорошо", R.drawable.sprite_cube);
        final Dialog dialog12 = new Dialog("Ну что? Попробуешь выполнить свое первое задание?", "Вперед!", R.drawable.sprite_cube);

        final ArrayList<Answer> answer1l1q = new ArrayList<>();

        answer1l1q.add(new Answer(0, "1"));
        answer1l1q.add(new Answer(0, "4"));
        answer1l1q.add(new Answer(0, "14"));
        answer1l1q.add(new Answer(0, "3"));

        final Quest quest1 = new Quest("Сколько видов ресурсов существует?", "4", "Увы, но ты ответил не правильно. Не расстраивайся, главное будь внимателен в следующий раз!", "Отлично! Ты схватываешь на лету. Продолжай в том же духе!", answer1l1q, new Reward(1, 1, 1, 1), R.drawable.sprite_cube, R.drawable.sprite_cube, R.drawable.sprite_cube);

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
        levelOne = new Level(1, elementsOfGames);
        return levelOne;
    }

    public static Level createLevelTwo() {
        final Dialog dialog1 = new Dialog("Поздравляю, ты перешел на второй уровень!", "Отлично", R.drawable.sprite_cube);
        final Dialog dialog2 = new Dialog("Смотри! Теперь у тебя есть некоторое количество всех ресурсов!", "Ага", R.drawable.sprite_cube);
        final Dialog dialog3 = new Dialog("Они помогут тебе пройти дальше.", null, R.drawable.sprite_cube);
        final Dialog dialog4 = new Dialog("Будь внимателен! От этих ресурсов зависит все!.", null, R.drawable.sprite_cube);
        final Dialog dialog5 = new Dialog("Хорошо. Тогда продолжим. Я рсскажу тебе историю моей вселенной.", "Давай", R.drawable.sprite_cube);
        final Dialog dialog6 = new Dialog("В далеком 200180 столетии, всюду царил хаос и разруха.", null, R.drawable.haos);
        final Dialog dialog7 = new Dialog("Но спустя 5 столейтий, появился он, герой и наш спаситель - Сompass.", null, R.drawable.compass);
        final Dialog dialog8 = new Dialog("Ему удалось уничтожить прежнего правителя.", null, R.drawable.zahvat);
        final Dialog dialog9 = new Dialog("Но. Не все так просто!.", null, R.drawable.sprite_cube);
        final Dialog dialog10 = new Dialog("Compass - перестал контролировать некоторую часть себя.", null, R.drawable.razum);
        final Dialog dialog11 = new Dialog("Есть вероятность того, что мы вернемся в то темное время.", null, R.drawable.haos);
        final Dialog dialog12 = new Dialog("Твоя задача, " + Player.name + " выяснить что происходит с нашим Героем и спасти вселенную!", null, R.drawable.sprite_cube);
        final Dialog dialog13 = new Dialog("Прежде чем, ты отправишься на поиски истины вот тебе еще один вопрос!", null, R.drawable.sprite_cube);

        final ArrayList<Answer> answer2l1q = new ArrayList<>();

        answer2l1q.add(new Answer(0, "Комп"));
        answer2l1q.add(new Answer(0, "Гиперкуб"));
        answer2l1q.add(new Answer(0, "Циркуль"));
        answer2l1q.add(new Answer(0, "Комната"));

        final Quest quest1 = new Quest("Как зовут нашего героя-спасителя в переводе на русский язык?", "Циркуль", "Память и внимательность твоя не самая сильная сторона.", "Молодец! Держи один Пиксель и одну Фортуну, они обязательно тебе пригодятся!", answer2l1q, new Reward(1, 0, 0, 1), R.drawable.sprite_cube, R.drawable.sprite_cube, R.drawable.sprite_cube);

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
        elementsOfGames.add(dialog13);
        elementsOfGames.add(quest1);

        levelTwo = new Level(2, elementsOfGames);
        return levelTwo;
    }

    public static Level createLevelThree() {
        final Dialog dialog1 = new Dialog("Последнее, что мы слышали о Компасе, это то что его видели последний раз 10 лет назад", "Ага", R.drawable.tenyears);
        final Dialog dialog2 = new Dialog("За такой долгий период могло произойти все, что угодно.", "Согласен", R.drawable.sprite_cube);
        final Dialog dialog3 = new Dialog("Говорят, он скрылся в соседней галактике, в Андромеде. Нам нужно туда!", "Хорошо", R.drawable.andromeda);
        final Dialog dialog4 = new Dialog("Давай найдем его и разберемся в чем дело.", null, R.drawable.sprite_cube);

        final ArrayList<Answer> answer2l1q = new ArrayList<>();

        answer2l1q.add(new Answer(0, "Лодка"));
        answer2l1q.add(new Answer(0, "Вертолет"));
        answer2l1q.add(new Answer(0, "Космолет"));
        answer2l1q.add(new Answer(0, "Мотоцикл"));

        final Quest quest1 = new Quest("Что нам нужно чтобы бороздить вселенную в поисках Компаса?", "Космолет", "Ну ты чего? Если будет такой настрой мы ничего не добьемся!", "Правильно! Ты получил еще по 1 единице каждого из ресурсов.", answer2l1q, new Reward(1, 1, 1, 1), R.drawable.sprite_cube, R.drawable.kosmolet, R.drawable.kosmolet);

        final ArrayList<ElementsOfLevel> elementsOfGames = new ArrayList<>();

        elementsOfGames.add(dialog1);
        elementsOfGames.add(dialog2);
        elementsOfGames.add(dialog3);
        elementsOfGames.add(dialog4);
        elementsOfGames.add(quest1);

        levelThree = new Level(3, elementsOfGames);
        return levelThree;
    }

    public static Level createLevelFour() {
        final Dialog dialog1 = new Dialog("Я знаю, что мастера по космическим кораблям зовут Электроник.", "Хмм", R.drawable.sprite_cube);
        final Dialog dialog2 = new Dialog("Он живет неподалеку от нас, отправляемся к нему!", "Вперед", R.drawable.sprite_cube);
        final Dialog dialog3 = new Dialog("О нет! Здесь что-то произошло, вокруг погром и нет следов жизни.", "Что будем делать?", R.drawable.haos);
        final Dialog dialog4 = new Dialog("Смотри, я нашел записку, прочти её!", null, R.drawable.zapiska);
        final Dialog dialog5 = new Dialog("«За мной охотятся Они, они знают, что я могу помочь найти Компаса, поэтому мне приходится скрываться, чтобы меня найти реши загадку»", null, R.drawable.zapiska);

        final ArrayList<Answer> answer4l1q = new ArrayList<>();

        answer4l1q.add(new Answer(0, "Уран"));
        answer4l1q.add(new Answer(0, "Солнце"));
        answer4l1q.add(new Answer(0, "Луна"));
        answer4l1q.add(new Answer(0, "Меркурий"));

        final Quest quest1 = new Quest("Какая планета солнечной системы вращается в направлении, противоположном Земле? ", "Уран", "Я конечно знал ответ, но не стал подсказывать, думал ты справишься сам!", " А тебе везет! Отличные познания!", answer4l1q, new Reward(0, 0, 1, 1), R.drawable.planeti, R.drawable.sprite_cube, R.drawable.sprite_cube);

        final ArrayList<ElementsOfLevel> elementsOfGames = new ArrayList<>();

        elementsOfGames.add(dialog1);
        elementsOfGames.add(dialog2);
        elementsOfGames.add(dialog3);
        elementsOfGames.add(dialog4);
        elementsOfGames.add(dialog5);
        elementsOfGames.add(quest1);

        levelFour = new Level(4, elementsOfGames);
        return levelFour;
    }

    public static Level createLevelFive() {
        final Dialog dialog1 = new Dialog("Предполагаю, его нужно искать в месте, связанным с этим названием.", null, R.drawable.sprite_cube);
        final Dialog dialog2 = new Dialog("В паре километров отсюда находится заброшенный космодром «Уран», скорее туда!", "Вперед", R.drawable.sprite_cube);
        final Dialog dialog3 = new Dialog("- Здравствуй Электроник, мы разгадали твою загадку и нашли тебя.", null, R.drawable.sprite_cube);
        final Dialog dialog4 = new Dialog("Нам нужна твоя помощь, нам нужен космический корабль, чтобы найти Компаса и вернуть его.", null, R.drawable.sprite_cube);
        final Dialog dialog5 = new Dialog("- Привет, Куб! Давно не виделись.", null, R.drawable.elektronik);
        final Dialog dialog6 = new Dialog("К счастью для вас, я как раз хотел бежать подальше с этой планеты, иначе Они меня скоро найдут.", null, R.drawable.elektronik);
        final Dialog dialog7 = new Dialog("Я помогу вам, только вот я забыл, где оставил ключ зажигания от корабля...", null, R.drawable.elektronik);
        final Dialog dialog8 = new Dialog("Помню, только лишь, что они там же, куда ставят букеты, а вот как называется, вылетело из головы", null, R.drawable.elektronik);
        final ArrayList<Answer> answer4l1q = new ArrayList<>();

        answer4l1q.add(new Answer(0, "На стол"));
        answer4l1q.add(new Answer(0, "В вазу"));
        answer4l1q.add(new Answer(0, "В щкаф"));
        answer4l1q.add(new Answer(0, "В угол"));

        final Quest quest1 = new Quest("Куда ставят букеты? ", "В вазу", "Да ну! Я бы не оставил бы их на видном месте, хорошо, что я вспомнил, что положил их в вазу, отправляемся скорей!", "Точно! Я же положил их вазу, ведь там искали бы в последнюю очередь, отправляемся скорее!", answer4l1q, new Reward(1, 1, 1, 1), R.drawable.sprite_cube, R.drawable.vaza, R.drawable.vaza);

        final ArrayList<ElementsOfLevel> elementsOfGames = new ArrayList<>();

        elementsOfGames.add(dialog1);
        elementsOfGames.add(dialog2);
        elementsOfGames.add(dialog3);
        elementsOfGames.add(dialog4);
        elementsOfGames.add(dialog5);
        elementsOfGames.add(dialog6);
        elementsOfGames.add(dialog7);
        elementsOfGames.add(dialog8);
        elementsOfGames.add(quest1);

        levelFive = new Level(5, elementsOfGames);
        return levelFive;
    }

    public static Level createLevelSix() {
        final Dialog dialog1 = new Dialog("Подлетая к концу нашей галактики, Млечного Пути герои наткнулись на указатель.", null, R.drawable.sprite_cube);
        final Dialog dialog2 = new Dialog("На нем написано в какой стороне находится та или иная галактика.", null, R.drawable.sprite_cube);


        final Dialog dialog3 = new Dialog("В галактике Андромеда всего одна планета и миллионы астероидов кольцами вращаются вокруг неё, чтобы их облететь, нужно знать их вдоль и поперек!", null, R.drawable.andromeda);

        final ArrayList<Answer> answer6l1q = new ArrayList<>();
        final ArrayList<Answer> answer6l2q = new ArrayList<>();

        answer6l1q.add(new Answer(0, "Андромеда"));
        answer6l1q.add(new Answer(0, "Сириус"));
        answer6l1q.add(new Answer(0, "Ума 2"));
        answer6l1q.add(new Answer(0, "БМО"));

        answer6l2q.add(new Answer(0, "Планеты"));
        answer6l2q.add(new Answer(0, "Мусор"));
        answer6l2q.add(new Answer(0, "Жизнь"));
        answer6l2q.add(new Answer(0, "Монстр"));

        final Quest quest1 = new Quest(": А ты помнишь в какую именно нам нужно галактику? ", "Андромеда", "Стой, по-моему нам в другую сторону. Ах, да, нам нужно в сторону Андромеды!", "Все верно, нам именно туда, полетели!", answer6l1q, new Reward(1, 1, 1, 1), R.drawable.andromeda, R.drawable.andromeda, R.drawable.andromeda);

        final Quest quest2 = new Quest("Что такое астероиды?", "Мусор", "Где-то здесь ошибка и она могла нам стоить жизни, почитай-ка космический словарь на досуге!", "Все верно, садись за руль, с такими знаниями мы их быстро обогнем!", answer6l2q, new Reward(1, 1, 1, 1), R.drawable.sprite_cube, R.drawable.asteroid, R.drawable.asteroid);

        final ArrayList<ElementsOfLevel> elementsOfGames = new ArrayList<>();

        elementsOfGames.add(dialog1);
        elementsOfGames.add(dialog2);
        elementsOfGames.add(quest1);
        elementsOfGames.add(dialog3);
        elementsOfGames.add(quest2);

        levelSix = new Level(6, elementsOfGames);
        return levelSix;
    }

    public static Level createLevelSeven() {
        final Dialog dialog1 = new Dialog("Команда смогла без проблем обогнуть астероиды, т.к. они знают, что мусор не имеет силы притяжения.", null, R.drawable.sprite_cube);
        final Dialog dialog2 = new Dialog("Приземлившись на землю, перед ними появилась голограмма.", null, R.drawable.gologramma);
        final Dialog dialog3 = new Dialog("-Вы кто такие? ", null, R.drawable.gologramma);
        final Dialog dialog4 = new Dialog(String.format("- %s, а ну-ка ответь им как нас зовут? ", Player.name), null, R.drawable.sprite_cube);

        final ArrayList<Answer> answer2l1q = new ArrayList<>();

        answer2l1q.add(new Answer(0, "Андромеда"));
        answer2l1q.add(new Answer(0, "Фургон"));
        answer2l1q.add(new Answer(0, "Команда"));
        answer2l1q.add(new Answer(0, "Носорог"));

        final Quest quest1 = new Quest("Как зовут всех членов команды?", "Команда", "Что? Ты опять все перепутал!", "Вот так то! Теперь и ты будешь знать, как нас зовут!", answer2l1q, new Reward(0, 1, 0, 1), R.drawable.sprite_cube, R.drawable.sprite_cube, R.drawable.sprite_cube);

        final ArrayList<ElementsOfLevel> elementsOfGames = new ArrayList<>();

        elementsOfGames.add(dialog1);
        elementsOfGames.add(dialog2);
        elementsOfGames.add(dialog3);
        elementsOfGames.add(dialog4);
        elementsOfGames.add(quest1);

        levelSeven = new Level(7, elementsOfGames);
        return levelSeven;
    }

    public static void loadAllLevels() {
        levelsArrayList.clear();
        levelsArrayList.add(createLevelOne());
        levelsArrayList.add(createLevelTwo());
        levelsArrayList.add(createLevelThree());
        levelsArrayList.add(createLevelFour());
        levelsArrayList.add(createLevelFive());
        levelsArrayList.add(createLevelSix());
        levelsArrayList.add(createLevelSeven());
    }
}
