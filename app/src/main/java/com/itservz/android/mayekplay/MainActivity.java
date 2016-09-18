package com.itservz.android.mayekplay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;

import com.google.android.gms.ads.MobileAds;
import com.itservz.android.mayekplay.match.MatchActivity;
import com.itservz.android.mayekplay.prep.PrepActivity;
import com.itservz.android.mayekplay.quiz.QuizActivity;
import com.itservz.android.mayekplay.visual.VisualActivity;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class MainActivity extends Activity {

    private boolean optionVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-3940256099942544~3347511713");

        final Button visualButton =(Button) findViewById(R.id.goToVisual);
        final Button prepButton = (Button) findViewById(R.id.goToPrep);
        final Button quizButton = (Button) findViewById(R.id.goToQuiz);
        final Button matchButton = (Button) findViewById(R.id.goToMatch);

        final Animation visualShow = AnimationUtils.loadAnimation(getApplication(), R.anim.visual_show);
        final Animation visualHide = AnimationUtils.loadAnimation(getApplication(), R.anim.visual_hide);

        final Animation prepShow = AnimationUtils.loadAnimation(getApplication(), R.anim.prep_show);
        final Animation prepHide = AnimationUtils.loadAnimation(getApplication(), R.anim.prep_hide);

        final Animation quizShow = AnimationUtils.loadAnimation(getApplication(), R.anim.quiz_show);
        final Animation quizHide = AnimationUtils.loadAnimation(getApplication(), R.anim.quiz_hide);

        final Animation matchShow = AnimationUtils.loadAnimation(getApplication(), R.anim.match_show);
        final Animation matchHide = AnimationUtils.loadAnimation(getApplication(), R.anim.match_hide);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (optionVisible) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) visualButton.getLayoutParams();
                    layoutParams.rightMargin -= (int) (matchButton.getWidth() * 1.7);
                    layoutParams.bottomMargin -= (int) (matchButton.getHeight() * 0.25);
                    //matchButton.setLayoutParams(layoutParams);
                    visualButton.startAnimation(visualHide);
                    visualButton.setClickable(false);

                    prepButton.startAnimation(prepHide);
                    prepButton.setClickable(false);

                    quizButton.startAnimation(quizHide);
                    quizButton.setClickable(false);

                    matchButton.startAnimation(matchHide);
                    matchButton.setClickable(false);
                    optionVisible =  false;
                } else {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) visualButton.getLayoutParams();
                    layoutParams.rightMargin += (int) (visualButton.getWidth() * 1.7);
                    layoutParams.bottomMargin += (int) (visualButton.getHeight() * 0.25);
                    //matchButton.setLayoutParams(layoutParams);
                    visualButton.startAnimation(visualShow);
                    visualButton.setClickable(true);

                    prepButton.startAnimation(prepShow);
                    prepButton.setClickable(true);

                    quizButton.startAnimation(quizShow);
                    quizButton.setClickable(true);

                    matchButton.startAnimation(matchShow);
                    matchButton.setClickable(true);

                    optionVisible = true;
                }
            }
        });
    }

    public void click(View view) {
        if (view.getId() == R.id.goToVisual) {
            Intent intent = new Intent(getBaseContext(), VisualActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.goToPrep) {
            Intent intent = new Intent(getBaseContext(), PrepActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.goToQuiz) {
            Intent intent = new Intent(getBaseContext(), QuizActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.goToMatch) {
            Intent intent = new Intent(getBaseContext(), MatchActivity.class);
            startActivity(intent);
        }
    }

        /*final Button buttonVisual = (Button) findViewById(R.id.goToVisual);
        buttonVisual.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            }
        });

        final Button buttonPrep = (Button) findViewById(R.id.goToPrep);
        buttonPrep.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), PrepActivity.class);
                startActivity(intent);
            }
        });

        final Button buttonQuiz = (Button) findViewById(R.id.goToQuiz);
        buttonQuiz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), QuizActivity.class);
                startActivity(intent);
            }
        });

        final Button buttonMatch = (Button) findViewById(R.id.goToMatch);
        buttonMatch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MatchActivity.class);
                startActivity(intent);
            }
        });*/


}
