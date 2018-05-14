package duff.ru.hypercube.GameComponents;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by maks on 15.04.18.
 */

public class TextWriter extends AppCompatTextView {
    private CharSequence mText;
    private int mIndex;
    private long mDelay = 50; // in ms

    public TextWriter(Context context) {
        super(context);
    }

    public TextWriter(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private Handler mHandler = new Handler();
    private Runnable characterAdder = new Runnable() {
        @Override
        public void run() {
            setText(mText.subSequence(0, mIndex++));

            if (mIndex <= mText.length()) {
                mHandler.postDelayed(characterAdder, mDelay);
            }
        }
    };

    public void animateText(CharSequence txt) {
        mText = txt;
        mIndex = 0;
        setText("");
        mHandler.removeCallbacks(characterAdder);
        mHandler.postDelayed(characterAdder, mDelay);
    }

    public void setCharacterDelay(long m) {
        mDelay = m;
    }
}



