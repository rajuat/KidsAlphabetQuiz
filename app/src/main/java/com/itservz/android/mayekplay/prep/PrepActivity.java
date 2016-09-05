package com.itservz.android.mayekplay.prep;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.itservz.android.mayekplay.R;
import com.itservz.android.mayekplay.ViewBuilder;

public class PrepActivity extends AppCompatActivity {

    private ViewFlipper viewFlipper;
    private View currentView;
    public static String CORRECT_ANSWER = "correct_answer";
    private boolean CORRECT_ANSWER_SELECTED = false;
    private int viewIndex = 0;
    private ImageView soundButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prep);

        viewIndex = 0;
        viewFlipper = (ViewFlipper) findViewById(R.id.prepFlipper);

        ViewBuilder viewBuilder = new ViewBuilder();
        viewBuilder.setViewsToFlipper(this, viewFlipper);
        currentView = viewBuilder.getView(viewIndex);

        viewBuilder.build(viewIndex);
        final int sound = viewBuilder.getSound();

        viewFlipper.setDisplayedChild(viewFlipper.indexOfChild(currentView));

        soundButton = (ImageView) findViewById(R.id.sound_btn);
        soundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SoundPool soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 0);
                soundPool.play(sound, 0.99f, 0.99f, 0, 0, 1);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(CORRECT_ANSWER_SELECTED) {
                    viewFlipper.showNext();
                }
                currentView = viewFlipper.getCurrentView();
            }
        });
    }

    public void answered(View view) {
        if (view.getTag() != null && view.getTag().equals(CORRECT_ANSWER)) {
            CORRECT_ANSWER_SELECTED = true;
        } else {
            CORRECT_ANSWER_SELECTED = false;
        }
    }
}
