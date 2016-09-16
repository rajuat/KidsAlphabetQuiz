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
    protected boolean ANSWER_SELECTED = false;
    protected ViewBuilder viewBuilder;
    protected ViewFlipper viewFlipper;
    protected View currentView;
    protected Result result;
    protected EditText correctAnswerEditText;
    protected EditText wrongAttemptsEditText;
    protected EditText scoreEditText;
    protected EditText questionTitleEditText;
    protected String FLIPPER_POSITION = "FLIPPER_POSITION";
    protected String QUESTION_AS_SOUND = "QUESTION_AS_SOUND";
    protected String WRONG_ANSWER = "WRONG_ANSWER";
    protected String RIGHT_ANSWER = "RIGHT_ANSWER";
    protected String SCORE = "SCORE";


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.sound_btn) {
            mayekSoundPoolPlayer.playShortResource(questionAsSound);
        } else if (view.getId() == R.id.next_btn) {
            if (ANSWER_SELECTED) {
                generateNextQuestion();
            } else {
                //blind click on next button
                Toast.makeText(this, "Choose an answer :-)", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        int position = viewFlipper.getDisplayedChild();
        savedInstanceState.putInt(FLIPPER_POSITION, position);
        savedInstanceState.putInt(QUESTION_AS_SOUND, questionAsSound);
        savedInstanceState.putInt(WRONG_ANSWER, result.getAccumulatedWrongAttempts());
        savedInstanceState.putInt(RIGHT_ANSWER, result.getNoOfCorrectAnswers());
        savedInstanceState.putInt(SCORE, result.getScore());
        super.onSaveInstanceState(savedInstanceState);
    }

    protected void initialize(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            int flipperPosition = savedInstanceState.getInt(FLIPPER_POSITION);
            viewFlipper.setDisplayedChild(flipperPosition);
            currentView = viewFlipper.getCurrentView();
            questionAsSound = savedInstanceState.getInt(QUESTION_AS_SOUND);
            result = new Result(savedInstanceState.getInt(WRONG_ANSWER), savedInstanceState.getInt(RIGHT_ANSWER), savedInstanceState.getInt(SCORE));
        } else {
            currentView = viewBuilder.getView(viewFlipper.getDisplayedChild());
            viewFlipper.setDisplayedChild(viewFlipper.indexOfChild(currentView));
            questionAsSound = viewBuilder.getQuestionAsSound();
            result = new Result();
        }

        viewBuilder.build(viewFlipper.getDisplayedChild(), questionAsSound);
        mayekSoundPoolPlayer = new MayekSoundPoolPlayer(getApplicationContext());
        mayekSoundPoolPlayer.playShortResource(questionAsSound);

        ImageView soundButton = (ImageView) findViewById(R.id.sound_btn);
        soundButton.setOnClickListener(this);

        ImageView nextButton = (ImageView) findViewById(R.id.next_btn);
        nextButton.setOnClickListener(this);

        result.setTotalNoOfQuestions(viewBuilder.getTotalNoOfViews());
        correctAnswerEditText = (EditText) findViewById(R.id.correct_answers_value);
        wrongAttemptsEditText = (EditText) findViewById(R.id.wrong_attempts_value);
        scoreEditText = (EditText) findViewById(R.id.score_value);
        questionTitleEditText = (EditText) findViewById(R.id.question_title);
        questionTitleEditText.setText(Mayeks.getInstance().getCardMap().get(questionAsSound).getTitle());
    }

    protected void generateNextQuestion() {
        if (viewFlipper.getDisplayedChild() < viewBuilder.getTotalNoOfViews() - 1) {
            ANSWER_SELECTED = true;
            questionAsSound = viewBuilder.getQuestionAsSound();
            viewBuilder.build(viewFlipper.getDisplayedChild() + 1, questionAsSound);
            mayekSoundPoolPlayer.playShortResource(questionAsSound);
            questionTitleEditText.setText(Mayeks.getInstance().getCardMap().get(questionAsSound).getTitle());
            viewFlipper.showNext();
            currentView = viewFlipper.getCurrentView();
        } else {
            //end of quiz
            setContentView(R.layout.activity_quiz_end);
            EditText scoreAllEditText = (EditText) findViewById(R.id.score_value_all);
            if (result.getScore() == 0) {
                scoreAllEditText.setText("Take quiz for scores :-)");
            } else {
                scoreAllEditText.setText("" + result.getScore());
            }
            EditText correctAnswerAllEditText = (EditText) findViewById(R.id.correct_answers_value_all);
            correctAnswerAllEditText.setText("" + result.getNoOfCorrectAnswers());
            EditText wrongAttemptsAllEditText = (EditText) findViewById(R.id.wrong_attempts_value_all);
            wrongAttemptsAllEditText.setText("" + result.getAccumulatedWrongAttempts());
            EditText totalQuestion = (EditText) findViewById(R.id.total_no_questions_value);
            totalQuestion.setText("" + viewBuilder.getTotalNoOfViews());
        }
    }

    /*public void shareOnFacebook(View view){
        FacebookHelper.shares(getApplicationContext(), currentView);
    }*/
}
