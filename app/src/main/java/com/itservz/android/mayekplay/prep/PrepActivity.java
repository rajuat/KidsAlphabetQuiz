package com.itservz.android.mayekplay.prep;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.itservz.android.mayekplay.MayekSoundPoolPlayer;
import com.itservz.android.mayekplay.QuizPrepBaseActivity;
import com.itservz.android.mayekplay.R;
import com.itservz.android.mayekplay.Result;
import com.itservz.android.mayekplay.ViewBuilder;

public class PrepActivity extends QuizPrepBaseActivity {

    //private boolean CORRECT_ANSWER_SELECTED = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prep);
        viewFlipper = (ViewFlipper) findViewById(R.id.prepFlipperPrep);
        viewBuilder.setViewsToFlipper(this, viewFlipper);
        initialize();
    }

    public void answered(final View view) {
        ANSWER_SELECTED = true;
        viewBuilder.resetBackgroundColor(viewIndex);
        if (view.getTag() != null && view.getTag().equals(CORRECT_ANSWER)) {
            new CountDownTimer(300, 300) {
                public void onTick(long millisUntilFinished) {
                    view.setBackgroundColor(Color.GREEN);
                }

                public void onFinish() {
                    //CORRECT_ANSWER_SELECTED = true;
                    result.incrementNoOfCorrectAnswers();
                    correctAnswerEditText.setText("" + result.getNoOfCorrectAnswers());
                    generateNextQuestion();
                }
            }.start();
        } else {
            new CountDownTimer(300, 300) {
                public void onTick(long millisUntilFinished) {
                    view.setBackgroundColor(Color.RED);
                }

                public void onFinish() {
                    //CORRECT_ANSWER_SELECTED = false;
                    view.setBackgroundColor(Color.WHITE);
                    result.incrementAccumulatedWrongAttempts();
                    wrongAttemptsEditText.setText("" + result.getAccumulatedWrongAttempts());
                    viewBuilder.build(viewIndex, questionAsSound);
                }
            }.start();
        }
    }
}