package com.itservz.android.mayekplay.prep;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.itservz.android.mayekplay.MayekSoundPoolPlayer;
import com.itservz.android.mayekplay.R;
import com.itservz.android.mayekplay.Result;
import com.itservz.android.mayekplay.ViewBuilder;

public class PrepActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewFlipper viewFlipper;
    private View currentView;
    public static String CORRECT_ANSWER = "correct_answer";
    private boolean CORRECT_ANSWER_SELECTED = false;
    private boolean ANSWER_SELECTED =  false;
    private int viewIndex = 0;
    private MayekSoundPoolPlayer mayekSoundPoolPlayer;
    private Integer questionAsSound;
    private ViewBuilder viewBuilder;
    private Result result;
    private EditText correctAnswerEditText;
    private EditText wrongAttemptsEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prep);

        viewIndex = 0;
        viewFlipper = (ViewFlipper) findViewById(R.id.prepFlipper);

        viewBuilder = new ViewBuilder();
        viewBuilder.setViewsToFlipper(this, viewFlipper);

        currentView = viewBuilder.getView(viewIndex);

        questionAsSound = viewBuilder.getQuestionAsSound();
        viewBuilder.build(viewIndex, questionAsSound);

        viewFlipper.setDisplayedChild(viewFlipper.indexOfChild(currentView));

        mayekSoundPoolPlayer = new MayekSoundPoolPlayer(getApplicationContext());
        mayekSoundPoolPlayer.playShortResource(questionAsSound);

        ImageView soundButton = (ImageView) findViewById(R.id.sound_btn);
        soundButton.setOnClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);

        result = new Result();
        result.setTotalNoOfQuestions(viewBuilder.getTotalNoOfViews());
        correctAnswerEditText = (EditText) findViewById(R.id.correct_answers_value);
        wrongAttemptsEditText = (EditText) findViewById(R.id.wrong_attempts_value);
    }

    public void answered(final View view) {
        ANSWER_SELECTED = true;
        viewBuilder.resetBackgroundColor(viewIndex);
        if (view.getTag() != null && view.getTag().equals(CORRECT_ANSWER)) {
            view.setBackgroundColor(Color.GREEN);
            CORRECT_ANSWER_SELECTED = true;
            result.incrementNoOfCorrectAnswers();
            correctAnswerEditText.setText(""+result.getNoOfCorrectAnswers());
        } else {
            new CountDownTimer(300, 300) {
                public void onTick(long millisUntilFinished) {
                    view.setBackgroundColor(Color.RED);
                }
                public void onFinish() {
                    CORRECT_ANSWER_SELECTED = false;
                    view.setBackgroundColor(Color.WHITE);
                    result.incrementAccumulatedWrongAttempts();
                    wrongAttemptsEditText.setText(""+result.getAccumulatedWrongAttempts());
                    viewBuilder.build(viewIndex, questionAsSound);
                }
            }.start();
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.sound_btn) {
            mayekSoundPoolPlayer.playShortResource(questionAsSound);
        }
        else if (view.getId() == R.id.fab) {
            if(ANSWER_SELECTED){
                if (viewIndex < viewBuilder.getTotalNoOfViews()-1 ) {
                    ANSWER_SELECTED = true;
                    viewIndex++;
                    questionAsSound = viewBuilder.getQuestionAsSound();
                    viewBuilder.build(viewIndex, questionAsSound);
                    mayekSoundPoolPlayer.playShortResource(questionAsSound);
                    viewFlipper.showNext();
                    currentView = viewFlipper.getCurrentView();
                } else {
                    //end of quiz
                    setContentView(R.layout.activity_prep_end);
                }
            } else {
                //blind click on next button
                Toast.makeText(this, "Choose an answer :-)", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
