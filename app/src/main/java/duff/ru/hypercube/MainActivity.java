package duff.ru.hypercube;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import duff.ru.hypercube.Game.Levels;
import duff.ru.hypercube.Utils.Utils;
import duff.ru.hypercube.View.FragmentMainMenu;

public class MainActivity extends AppCompatActivity {

    public static SharedPreferences sharedPref;
    public static Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPref = getPreferences(Context.MODE_PRIVATE);
        context = getApplicationContext();

        PackageManager m = getPackageManager();
        String s = getPackageName();
        try {
            PackageInfo p = m.getPackageInfo(s, 0);
            s = p.applicationInfo.publicSourceDir;
            Log.d("hyper", "onCreate: " + s);
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("yourtag", "Error Package name not found ", e);
        }

        Player.loadSettings();

//        if (Player.progress != -1) {
            Levels.loadAllLevels();
//        }

        Utils.replaceFragmentWithAnimationFade(getSupportFragmentManager(), new FragmentMainMenu(), null, false);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Player.saveAllSettings();

    }
}
