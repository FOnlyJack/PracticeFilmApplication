package com.example.changemax.sqhappy.ui.view;

import android.content.Context;
import android.util.AttributeSet;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by Nathen on 2016/11/26.
 */

public class JCVAutoFullVideoView extends JCVideoPlayerStandard {
    public JCVAutoFullVideoView(Context context) {
        super(context);
    }

    public JCVAutoFullVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onAutoCompletion() {
        if (currentScreen == SCREEN_WINDOW_FULLSCREEN) {
            setUiWitStateAndScreen(CURRENT_STATE_AUTO_COMPLETE);
        } else {
            super.onAutoCompletion();
        }

    }
}
