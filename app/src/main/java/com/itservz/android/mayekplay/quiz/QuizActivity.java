package com.itservz.android.mayekplay.quiz;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.itservz.android.mayekplay.QuizPrepBaseActivity;
import com.itservz.android.mayekplay.R;

public class QuizActivity extends QuizPrepBaseActivity {
    public static String CORRECT_ANSWER = "correct_answer";
    private boolean CORRECT_ANSWER_SELECTED = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
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
                    //view.setBackgroundColor(Color.GREEN);
                    ((ImageView) view).setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
                }

                public void onFinish() {
                    CORRECT_ANSWER_SELECTED = true;
                    result.incrementNoOfCorrectAnswers();
                    correctAnswerTextView.setText("" + result.getNoOfCorrectAnswers());
                    result.setScore(result.getScore()+result.getNoOfCorrectAnswers());
                    scoreTextView.setText(""+result.getScore());
                    generateNextQuestion();
                    setProgress();
                    ((ImageView) view).clearColorFilter();
                    //view.setBackgroundColor(Color.TRANSPARENT);
                }
            }.start();
        } else {
            new CountDownTimer(700, 700) {
                public void onTick(long millisUntilFinished) {
                    //view.setBackgroundColor(Color.RED);
                    ((ImageView) view).setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                }

                public void onFinish() {
                    CORRECT_ANSWER_SELECTED = false;
                    result.incrementAccumulatedWrongAttempts();
                    wrongAttemptsTextView.setText("" + result.getAccumulatedWrongAttempts());
                    result.setScore(result.getScore()-result.getAccumulatedWrongAttempts());
                    scoreTextView.setText(""+(result.getScore()));
                    viewBuilder.build(viewFlipper.getDisplayedChild(), questionAsSound);
                    setProgress();
                    ((ImageView) view).clearColorFilter();
                    //view.setBackgroundColor(Color.TRANSPARENT);
                }
            }.start();
        }
    }
}