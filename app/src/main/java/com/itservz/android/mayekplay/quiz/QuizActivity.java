package com.itservz.android.mayekplay.quiz;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

import com.itservz.android.mayekplay.QuizPrepBaseActivity;
import com.itservz.android.mayekplay.R;

public class QuizActivity extends QuizPrepBaseActivity {
    public static String CORRECT_ANSWER = "correct_answer";
    private boolean CORRECT_ANSWER_SELECTED = false;
    private int score = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        viewFlipper = (ViewFlipper) findViewById(R.id.prepFlipperQuiz);
        viewBuilder.setViewsToFlipper(this, viewFlipper);
        initialize();
    }

    public void answered(final View view) {
        ANSWER_SELECTED = true;
        viewBuilder.resetBackgroundColor(viewIndex);
        if (view.getTag() != null && view.getTag().equals(CORRECT_ANSWER)) {
            score = score*2;
            new CountDownTimer(300, 300) {
                public void onTick(long millisUntilFinished) {
                    view.setBackgroundColor(Color.GREEN);
                }

                public void onFinish() {
                    CORRECT_ANSWER_SELECTED = true;
                    result.incrementNoOfCorrectAnswers();
                    correctAnswerEditText.setText("" + result.getNoOfCorrectAnswers());
                    result.setScore(score);
                    scoreEditText.setText(""+score);
                    generateNextQuestion();
                }
            }.start();
        } else {
            new CountDownTimer(300, 300) {
                public void onTick(long millisUntilFinished) {
                    view.setBackgroundColor(Color.RED);
                }

                public void onFinish() {
                    CORRECT_ANSWER_SELECTED = false;
                    result.incrementAccumulatedWrongAttempts();
                    wrongAttemptsEditText.setText("" + result.getAccumulatedWrongAttempts());
                    result.setScore(score);
                    scoreEditText.setText(""+score);
                    generateNextQuestion();
                }
            }.start();
        }
    }
}