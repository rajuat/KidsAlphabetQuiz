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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        viewFlipper = (ViewFlipper) findViewById(R.id.prepFlipperQuiz);
        viewBuilder = new ViewBuilder();
        viewBuilder.setViewsToFlipper(this, viewFlipper);
        initialize(savedInstanceState);
    }

    public void answered(final View view) {
        ANSWER_SELECTED = true;
        viewBuilder.resetBackgroundColor(viewFlipper.getDisplayedChild());
        if (view.getTag() != null && view.getTag().equals(CORRECT_ANSWER)) {
            new CountDownTimer(300, 300) {
                public void onTick(long millisUntilFinished) {
                    view.setBackgroundColor(Color.GREEN);
                }

                public void onFinish() {
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
                    view.setBackgroundColor(Color.WHITE);
                    result.incrementAccumulatedWrongAttempts();
                    wrongAttemptsEditText.setText("" + result.getAccumulatedWrongAttempts());
                    viewBuilder.build(viewFlipper.getDisplayedChild(), questionAsSound);
                }
            }.start();
        }
    }
}