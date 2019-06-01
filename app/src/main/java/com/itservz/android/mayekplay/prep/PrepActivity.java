package com.itservz.android.mayekplay.prep;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;

import com.itservz.android.mayekplay.QuizPrepBaseActivity;
import com.itservz.android.mayekplay.R;

public class PrepActivity extends QuizPrepBaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_quiz);
        initialize(savedInstanceState, false);
        setProgress();
    }

    public void answered(final View view) {
        ANSWER_SELECTED = true;
        //viewBuilder.resetBackgroundColor(viewFlipper.getDisplayedChild());
        if (view.getTag() != null && view.getTag().equals(CORRECT_ANSWER)) {
            new CountDownTimer(700, 700) {
                public void onTick(long millisUntilFinished) {
                    view.setBackgroundColor(Color.GREEN);
                }

                public void onFinish() {
                    result.incrementNoOfCorrectAnswers();
                    correctAnswerTextView.setText("" + result.getNoOfCorrectAnswers());
                    generateNextQuestion();
                    view.setBackgroundColor(Color.TRANSPARENT);
                }
            }.start();
        } else {
            new CountDownTimer(700, 700) {
                public void onTick(long millisUntilFinished) {
                    view.setBackgroundColor(Color.RED);
                }

                public void onFinish() {
                    result.incrementAccumulatedWrongAttempts();
                    wrongAttemptsTextView.setText("" + result.getAccumulatedWrongAttempts());
                    viewBuilder.build(viewFlipper.getDisplayedChild(), questionAsSound);
                    view.setBackgroundColor(Color.TRANSPARENT);
                }
            }.start();
        }
        setProgress();
    }
}