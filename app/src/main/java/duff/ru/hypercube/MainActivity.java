package duff.ru.hypercube;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import duff.ru.hypercube.Game.Levels;
import duff.ru.hypercube.Utils.Utils;
import duff.ru.hypercube.View.FragmentMainMenu;

public class MainActivity extends AppCompatActivity {

    public static SharedPreferences sharedPref;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPref = getPreferences(Context.MODE_PRIVATE);

        Player.loadSettings();

        if (Player.progress != -1) {
            Levels.loadAllLevels();
        }

        Utils.replaceFragmentWithAnimationFade(getSupportFragmentManager(), new FragmentMainMenu(), null, false);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Player.saveAllSettings();

    }
}
