package com.itservz.android.mayekplay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

/**
 * Created by raju.athokpam on 12-09-2016.
 */
public class QuizPrepBaseActivity extends AppCompatActivity implements View.OnClickListener {
    public static String CORRECT_ANSWER = "correct_answer";
    protected MayekSoundPoolPlayer mayekSoundPoolPlayer;
    protected Integer questionAsSound;
    protected boolean ANSWER_SELECTED =  false;
    protected int viewIndex = 0;
    protected ViewBuilder viewBuilder;
    protected ViewFlipper viewFlipper;
    protected View currentView;
    protected Result result;
    protected EditText correctAnswerEditText;
    protected EditText wrongAttemptsEditText;
    protected EditText scoreEditText;

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.sound_btn) {
            mayekSoundPoolPlayer.playShortResource(questionAsSound);
        }
        else if (view.getId() == R.id.next_btn) {
            if(ANSWER_SELECTED){
                generateNextQuestion();
            } else {
                //blind click on next button
                Toast.makeText(this, "Choose an answer :-)", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBuilder = new ViewBuilder();
        viewIndex = 0;
    }

    protected void initialize() {
        currentView = viewBuilder.getView(viewIndex);

        questionAsSound = viewBuilder.getQuestionAsSound();
        viewBuilder.build(viewIndex, questionAsSound);

        viewFlipper.setDisplayedChild(viewFlipper.indexOfChild(currentView));

        mayekSoundPoolPlayer = new MayekSoundPoolPlayer(getApplicationContext());
        mayekSoundPoolPlayer.playShortResource(questionAsSound);

        ImageView soundButton = (ImageView) findViewById(R.id.sound_btn);
        soundButton.setOnClickListener(this);

        ImageView nextButton = (ImageView) findViewById(R.id.next_btn);
        nextButton.setOnClickListener(this);

        result = new Result();
        result.setTotalNoOfQuestions(viewBuilder.getTotalNoOfViews());
        correctAnswerEditText = (EditText) findViewById(R.id.correct_answers_value);
        wrongAttemptsEditText = (EditText) findViewById(R.id.wrong_attempts_value);
        scoreEditText = (EditText) findViewById(R.id.score_value);
    }

    protected void generateNextQuestion() {
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
            EditText scoreAllEditText = (EditText) findViewById(R.id.score_value_all);
            if(result.getScore() == 0){
                scoreAllEditText.setText("Take quiz for scores :-)");
            } else {
                scoreAllEditText.setText(""+result.getScore());
            }
            EditText correctAnswerAllEditText = (EditText) findViewById(R.id.correct_answers_value_all);
            correctAnswerAllEditText.setText(""+result.getNoOfCorrectAnswers());
            EditText wrongAttemptsAllEditText = (EditText) findViewById(R.id.wrong_attempts_value_all);
            wrongAttemptsAllEditText.setText(""+result.getAccumulatedWrongAttempts());
            EditText totalQuestion = (EditText) findViewById(R.id.total_no_questions_value);
            totalQuestion.setText(""+viewBuilder.getTotalNoOfViews());
        }
    }
}
