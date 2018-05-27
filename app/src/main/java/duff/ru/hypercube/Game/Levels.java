package duff.ru.hypercube.Game;

import android.util.Log;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import duff.ru.hypercube.MainActivity;
import duff.ru.hypercube.Player;


/**
 * Created by maks on 16.03.18.
 */

public class Levels {


    public static String TAG = "hypercube";
    public static ArrayList<Level> levelsArrayList = new ArrayList<>();
    static String DIALOG = "dialog";
    static String QUEST = "quest";

    public static void loadAllLevels() {
        levelsArrayList.clear();
        JSONParser parser = new JSONParser();
        JSONObject doc = null;

        try {
            doc = (JSONObject) parser.parse(new InputStreamReader(MainActivity.context.getAssets().open("levels.json")));
        } catch (IOException e) {
            Log.d(TAG, "loadAllLevels: IOException");
            e.printStackTrace();
        } catch (ParseException e) {
            Log.d(TAG, "loadAllLevels: error read file");
            e.printStackTrace();
        }

        assert doc != null;

        JSONArray levels = (JSONArray) doc.get("Levels");
        for (Object l : levels) {
            JSONObject leveljson = (JSONObject) l;

            Log.d(TAG, "loadAllLevels: " + leveljson.get("id").toString());
            ArrayList<ElementsOfLevel> elementsOfLevels = new ArrayList<>();

            JSONArray elementsOfLevel = (JSONArray) leveljson.get("ElementsOfLevel");

            for (Object elementOfLevel : elementsOfLevel) {
                JSONObject elementOfLevelJson = (JSONObject) elementOfLevel;


                if (elementOfLevelJson.get("type").toString().equals(DIALOG)) {

                    String buttonText = elementOfLevelJson.get("buttonText").toString();
                    if (buttonText.equals("null")) {
                        buttonText = null;
                    }

                    String text = elementOfLevelJson.get("text").toString();
                    if (text.contains("%s")) {
                        text = String.format(text, Player.name);
                    }

                    Dialog dialog = new Dialog(text, buttonText, elementOfLevelJson.get("picture").toString());
                    elementsOfLevels.add(dialog);

                } else if (elementOfLevelJson.get("type").toString().equals(QUEST)){

                    ArrayList<Answer> answers = new ArrayList<>();
                    answers.add(new Answer(0, elementOfLevelJson.get("answer1").toString()));
                    answers.add(new Answer(0, elementOfLevelJson.get("answer2").toString()));
                    answers.add(new Answer(0, elementOfLevelJson.get("answer3").toString()));
                    answers.add(new Answer(0, elementOfLevelJson.get("answer4").toString()));

                    Quest quest = new Quest(elementOfLevelJson.get("question").toString(), elementOfLevelJson.get("trueAnswer").toString(), elementOfLevelJson.get("loserDialog").toString(), elementOfLevelJson.get("winsDialog").toString(), answers, new Reward(Integer.parseInt(elementOfLevelJson.get("pixels").toString()), Integer.parseInt(elementOfLevelJson.get("diaphragms").toString()), Integer.parseInt(elementOfLevelJson.get("hexes").toString()), Integer.parseInt(elementOfLevelJson.get("fortune").toString())), elementOfLevelJson.get("picture").toString(), elementOfLevelJson.get("picture").toString(), elementOfLevelJson.get("picture").toString());

                    elementsOfLevels.add(quest);

                    Log.d(TAG, "loadAllLevels: " + quest.question);
                    Log.d(TAG, "loadAllLevels: " + quest.trueAnswer);
                    Log.d(TAG, "loadAllLevels: " + quest.picture);
                }
            }

            levelsArrayList.add(new Level(Integer.parseInt(leveljson.get("id").toString()), elementsOfLevels));
        }
    }
}
