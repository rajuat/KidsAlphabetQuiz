package com.itservz.android.mayekplay;

import android.app.Activity;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.itservz.android.mayekplay.prep.PrepActivity;

/**
 * Created by raju.athokpam on 12-09-2016.
 */
public class QuizPrepBaseActivity extends Activity implements View.OnClickListener {
    public static String CORRECT_ANSWER = "correct_answer";
    protected MayekSoundPoolPlayer mayekSoundPoolPlayer;
    protected Integer questionAsSound;
    protected boolean ANSWER_SELECTED = false;
    protected ViewBuilder viewBuilder;
    protected ViewFlipper viewFlipper;
    protected View currentView;
    protected Result result;
    protected TextView correctAnswerTextView;
    protected TextView wrongAttemptsTextView;
    protected TextView scoreTextView;
    protected TextView questionTitleTextView;
    protected String FLIPPER_POSITION = "FLIPPER_POSITION";
    protected String QUESTION_AS_SOUND = "QUESTION_AS_SOUND";
    protected String WRONG_ANSWER = "WRONG_ANSWER";
    protected String RIGHT_ANSWER = "RIGHT_ANSWER";
    protected String SCORE = "SCORE";
    private boolean abc;


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.sound_btn) {
            mayekSoundPoolPlayer.playShortResource(questionAsSound);
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

    protected void initialize(Bundle savedInstanceState, boolean userReturns) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        abc = prefs.getBoolean(MainActivity.ABC, false);
        viewFlipper = (ViewFlipper) findViewById(R.id.prepFlipperQuiz);
        viewBuilder = new ViewBuilder(abc, getApplicationContext());
        viewBuilder.setViewsToFlipper(this, viewFlipper);
        if (userReturns) {
            currentView = viewBuilder.getView(0);
            viewFlipper.setDisplayedChild(viewFlipper.indexOfChild(currentView));
            questionAsSound = viewBuilder.getQuestionAsSound();
            result = new Result();
        } else if (savedInstanceState != null) {
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

        //result.setTotalNoOfQuestions(viewBuilder.getTotalNoOfViews());
        correctAnswerTextView = (TextView) findViewById(R.id.correct_answers_value);
        wrongAttemptsTextView = (TextView) findViewById(R.id.wrong_attempts_value);
        scoreTextView = (TextView) findViewById(R.id.score_value);
        questionTitleTextView = (TextView) findViewById(R.id.question_title);
        if (abc) {
            questionTitleTextView.setText(Alphabets.getInstance().getCardMap().get(questionAsSound).getTitle());
        } else {
            questionTitleTextView.setText(Mayeks.getInstance().getCardMap().get(questionAsSound).getTitle());
        }
    }

    protected void generateNextQuestion() {
        if (viewFlipper.getDisplayedChild() < viewBuilder.getTotalNoOfViews() - 1) {
            questionAsSound = viewBuilder.getQuestionAsSound();
            viewBuilder.build(viewFlipper.getDisplayedChild() + 1, questionAsSound);
            mayekSoundPoolPlayer.playShortResource(questionAsSound);
            if (abc) {
                questionTitleTextView.setText(Alphabets.getInstance().getCardMap().get(questionAsSound).getTitle());
            } else {
                questionTitleTextView.setText(Mayeks.getInstance().getCardMap().get(questionAsSound).getTitle());
            }

            viewFlipper.showNext();
            currentView = viewFlipper.getCurrentView();
            ANSWER_SELECTED = false;
        } else {
            final Dialog endDialog = new Dialog(this, R.style.full_screen_dialog);
            endDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            endDialog.setContentView(R.layout.activity_quiz_end);
            endDialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            endDialog.getWindow().setFormat(PixelFormat.TRANSLUCENT);
            ColorDrawable drawable = new ColorDrawable(Color.WHITE);
            drawable.setAlpha(80);
            endDialog.getWindow().setBackgroundDrawable(drawable);

            Button smallBtn = (Button) endDialog.findViewById(R.id.quiz_dailog_close);
            smallBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    endDialog.dismiss();
                    finish();
                }
            });

            Button playAgainBtn = (Button) endDialog.findViewById(R.id.quiz_dailog_play_again);
            playAgainBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    endDialog.dismiss();
                    initialize(null, true);
                }
            });

            TextView scoreAllTextView = (TextView) endDialog.findViewById(R.id.score_value_all);
            if (this instanceof PrepActivity) {
                scoreAllTextView.setText("Take quiz :-)");
            } else {
                if (result.getScore() < 0) {
                    scoreAllTextView.setText("0 :(");
                } else {
                    scoreAllTextView.setText("" + result.getScore());
                }
            }
            TextView correctAnswerAllTextView = (TextView) endDialog.findViewById(R.id.correct_answers_value_all);
            correctAnswerAllTextView.setText("" + result.getNoOfCorrectAnswers());
            TextView wrongAttemptsAllTextView = (TextView) endDialog.findViewById(R.id.wrong_attempts_value_all);
            wrongAttemptsAllTextView.setText("" + result.getAccumulatedWrongAttempts());
            TextView totalQuestion = (TextView) endDialog.findViewById(R.id.total_no_questions_value);
            totalQuestion.setText("" + result.getTotalNoOfQuestions());

            //for english locale
            if (abc) {
                ((TextView) endDialog.findViewById(R.id.score_label_all)).setText("Score");
                ((TextView) endDialog.findViewById(R.id.correct_answers_label_all)).setText("Correct answers");
                ((TextView) endDialog.findViewById(R.id.wrong_attempts_label_all)).setText("Incorrect answers");
                ((TextView) endDialog.findViewById(R.id.total_no_questions)).setText("No of questions");

                ((Button) endDialog.findViewById(R.id.quiz_dailog_play_again)).setText(" Play again ");
                ((Button) endDialog.findViewById(R.id.quiz_dailog_close)).setText("Play another");
            }
            endDialog.show();
        }
    }

    protected void setProgress() {

        int completed = result.getNoOfCorrectAnswers() + result.getAccumulatedWrongAttempts();
        result.setTotalNoOfQuestions(viewBuilder.getTotalNoOfViews() + result.getAccumulatedWrongAttempts());
        TextView progress = (TextView) findViewById(R.id.progress_quiz);
        progress.setText("" + completed + " / " + result.getTotalNoOfQuestions());
    }

    /*public void shareOnFacebook(View view){
        FacebookHelper.shares(getApplicationContext(), currentView);
    }*/
}
