package duff.ru.hypercube.Utils;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import duff.ru.hypercube.R;

/**
 * Created by maks on 15.03.18.
 */

public class Utils {

    public static void replaceFragmentWithAnimationFade(FragmentManager fragmentManager, Fragment fragment, String tag, boolean addToBackStack) {

        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.fade_to_up, R.anim.fade_to_back, R.anim.fade_to_up, R.anim.fade_to_back);
        fragmentTransaction.replace(R.id.container, fragment);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(tag);
        }
        fragmentTransaction.commit();
    }

    public static void playButtonAnswerSound(Context context) {
        MediaPlayer mp = MediaPlayer.create(context, R.raw.button_answer);
        mp.start();
    }

}
