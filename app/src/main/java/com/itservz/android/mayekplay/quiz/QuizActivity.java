package com.itservz.android.mayekplay.quiz;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.widget.ViewFlipper;

import com.facebook.FacebookSdk;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.itservz.android.mayekplay.QuizPrepBaseActivity;
import com.itservz.android.mayekplay.R;
import com.itservz.android.mayekplay.ViewBuilder;

public class QuizActivity extends QuizPrepBaseActivity {
    public static String CORRECT_ANSWER = "correct_answer";
    private boolean CORRECT_ANSWER_SELECTED = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_quiz);

        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        viewFlipper = (ViewFlipper) findViewById(R.id.prepFlipperQuiz);

        viewBuilder = new ViewBuilder();
        viewBuilder.setViewsToFlipper(this, viewFlipper);
        initialize(savedInstanceState);

    }

    public void answered(final View view) {
        ANSWER_SELECTED = true;
        viewBuilder.resetBackgroundColor(viewFlipper.getDisplayedChild());
        if (view.getTag() != null && view.getTag().equals(CORRECT_ANSWER)) {

            new CountDownTimer(700, 700) {
                public void onTick(long millisUntilFinished) {
                    view.setBackgroundColor(Color.GREEN);
                }

                public void onFinish() {
                    CORRECT_ANSWER_SELECTED = true;
                    result.incrementNoOfCorrectAnswers();
                    correctAnswerEditText.setText("" + result.getNoOfCorrectAnswers());
                    result.setScore(result.getScore()+result.getNoOfCorrectAnswers());
                    scoreEditText.setText(""+result.getScore());
                    generateNextQuestion();
                    setProgress();
                }
            }.start();
        } else {
            new CountDownTimer(700, 700) {
                public void onTick(long millisUntilFinished) {
                    view.setBackgroundColor(Color.RED);
                }

                public void onFinish() {
                    CORRECT_ANSWER_SELECTED = false;
                    result.incrementAccumulatedWrongAttempts();
                    wrongAttemptsEditText.setText("" + result.getAccumulatedWrongAttempts());
                    result.setScore(result.getScore()-result.getAccumulatedWrongAttempts());
                    scoreEditText.setText(""+(result.getScore()));
                    viewBuilder.build(viewFlipper.getDisplayedChild(), questionAsSound);
                    setProgress();
                }
            }.start();
        }
    }
}