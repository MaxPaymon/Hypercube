package duff.ru.hypercube;

import android.content.SharedPreferences;

import static duff.ru.hypercube.Config.*;
import static duff.ru.hypercube.MainActivity.sharedPref;

/**
 * Created by maks on 15.03.18.
 */



public class Player {

    public static String name;
    public static int progress;

    //For game
    public static int pixels;
    public static int diaphragms;
    public static int hexes;
    public static int fortune;

    public static void loadSettings() {
        name = sharedPref.getString(SHARED_PREFERENCE_NAME, null);
        progress = sharedPref.getInt(SHARED_PREFERENCE_PROGRESS, -1);

        pixels = sharedPref.getInt(SHARED_PREFERENCE_PIXELS, 0);
        diaphragms = sharedPref.getInt(SHARED_PREFERENCE_DIAPHRAGMS, 0);
        hexes = sharedPref.getInt(SHARED_PREFERENCE_HEXES, 0);
        fortune = sharedPref.getInt(SHARED_PREFERENCE_FORTUNE, 0);
    }

    public static void saveStat() {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(SHARED_PREFERENCE_PIXELS, pixels);
        editor.putInt(SHARED_PREFERENCE_DIAPHRAGMS, diaphragms);
        editor.putInt(SHARED_PREFERENCE_HEXES, hexes);
        editor.putInt(SHARED_PREFERENCE_FORTUNE, fortune);
        editor.apply();
    }

    public static void saveSettings() {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(SHARED_PREFERENCE_NAME, name);
        editor.putInt(SHARED_PREFERENCE_PROGRESS, progress);
        editor.apply();
    }

    public static void saveAllSettings() {
        saveSettings();
        saveStat();
    }

    public static void setDefaultSettings() {
        name = "";
        progress = -1;
        pixels = 0;
        diaphragms = 0;
        hexes = 0;
        fortune = 0;
    }
}
