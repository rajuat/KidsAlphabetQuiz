package com.itservz.android.mayekplay;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.gms.ads.MobileAds;
import com.itservz.android.mayekplay.match.MatchActivity;
import com.itservz.android.mayekplay.prep.PrepActivity;
import com.itservz.android.mayekplay.quiz.QuizActivity;
import com.itservz.android.mayekplay.visual.VisualActivity;

public class MainActivity extends Activity {

    private boolean optionVisible = false;
    private boolean doubleBackToExitPressedOnce;

    private Button visualButton;
    private Button prepButton;
    private Button quizButton;
    private Button matchButton;

    private Animation visualShow;
    private Animation visualHide;

    private Animation prepShow;
    private Animation prepHide;

    private Animation quizShow;
    private Animation quizHide;

    private Animation matchShow;
    private Animation matchHide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-3940256099942544~3347511713");
        visualShow = AnimationUtils.loadAnimation(getApplication(), R.anim.visual_show);
        visualHide = AnimationUtils.loadAnimation(getApplication(), R.anim.visual_hide);

        prepShow = AnimationUtils.loadAnimation(getApplication(), R.anim.prep_show);
        prepHide = AnimationUtils.loadAnimation(getApplication(), R.anim.prep_hide);

        quizShow = AnimationUtils.loadAnimation(getApplication(), R.anim.quiz_show);
        quizHide = AnimationUtils.loadAnimation(getApplication(), R.anim.quiz_hide);

        matchShow = AnimationUtils.loadAnimation(getApplication(), R.anim.match_show);
        matchHide = AnimationUtils.loadAnimation(getApplication(), R.anim.match_hide);

        setContentView(R.layout.activity_main);

        visualButton = (Button) findViewById(R.id.goToVisual);
        prepButton = (Button) findViewById(R.id.goToPrep);
        quizButton = (Button) findViewById(R.id.goToQuiz);
        matchButton = (Button) findViewById(R.id.goToMatch);
    }

    private void expandMenu() {

        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) visualButton.getLayoutParams();
        layoutParams.rightMargin += (int) (visualButton.getWidth() * 0);
        layoutParams.bottomMargin += (int) (visualButton.getHeight() * 2.15);
        visualButton.setLayoutParams(layoutParams);
        visualButton.startAnimation(visualShow);
        visualButton.setClickable(true);

        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) prepButton.getLayoutParams();
        layoutParams2.rightMargin += (int) (prepButton.getWidth() * 1.08);
        layoutParams2.bottomMargin += (int) (prepButton.getHeight() * 1.87);
        prepButton.setLayoutParams(layoutParams2);
        prepButton.startAnimation(prepShow);
        prepButton.setClickable(true);

        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) quizButton.getLayoutParams();
        layoutParams3.rightMargin += (int) (quizButton.getWidth() * 1.87);
        layoutParams3.bottomMargin += (int) (quizButton.getHeight() * 1.08);
        quizButton.setLayoutParams(layoutParams3);
        quizButton.startAnimation(quizShow);
        quizButton.setClickable(true);

        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) matchButton.getLayoutParams();
        layoutParams4.rightMargin += (int) (matchButton.getWidth() * 2.15);
        layoutParams4.bottomMargin += (int) (matchButton.getHeight() * 0);
        matchButton.setLayoutParams(layoutParams4);
        matchButton.startAnimation(matchShow);
        matchButton.setClickable(true);
    }


    private void hideMenu() {

        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) visualButton.getLayoutParams();
        layoutParams.rightMargin -= (int) (visualButton.getWidth() * 0);
        layoutParams.bottomMargin -= (int) (visualButton.getHeight() * 2.15);
        visualButton.setLayoutParams(layoutParams);
        visualButton.startAnimation(visualHide);
        visualButton.setClickable(false);

        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) prepButton.getLayoutParams();
        layoutParams2.rightMargin -= (int) (prepButton.getWidth() * 1.08);
        layoutParams2.bottomMargin -= (int) (prepButton.getHeight() * 1.87);
        prepButton.setLayoutParams(layoutParams2);
        prepButton.startAnimation(prepHide);
        prepButton.setClickable(false);

        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) quizButton.getLayoutParams();
        layoutParams3.rightMargin -= (int) (quizButton.getWidth() * 1.87);
        layoutParams3.bottomMargin -= (int) (quizButton.getHeight() * 1.08);
        quizButton.setLayoutParams(layoutParams3);
        quizButton.startAnimation(quizHide);
        quizButton.setClickable(false);

        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) matchButton.getLayoutParams();
        layoutParams4.rightMargin -= (int) (matchButton.getWidth() * 2.15);
        layoutParams4.bottomMargin -= (int) (matchButton.getHeight() * 0);
        matchButton.setLayoutParams(layoutParams4);
        matchButton.startAnimation(matchHide);
        matchButton.setClickable(false);
    }

    public void click(View view) {
        if (view.getId() == R.id.fab) {
            if (optionVisible) {
                hideMenu();
                optionVisible = false;
            } else {
                expandMenu();
                optionVisible = true;
            }

        } else if (view.getId() == R.id.goToVisual) {
            hideMenu();
            optionVisible = false;
            Intent intent = new Intent(getBaseContext(), VisualActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.goToPrep) {
            hideMenu();
            optionVisible = false;
            Intent intent = new Intent(getBaseContext(), PrepActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.goToQuiz) {
            hideMenu();
            optionVisible = false;
            Intent intent = new Intent(getBaseContext(), QuizActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.goToMatch) {
            hideMenu();
            optionVisible = false;
            Intent intent = new Intent(getBaseContext(), MatchActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.info) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Nungairibo? Mayek yekpagi app amasu lei, pambra?");

            alertDialogBuilder.setPositiveButton("Hoi", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    final String appPackageName = "com.itservz.android.mayekid";
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                    } catch (android.content.ActivityNotFoundException anfe) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                    }
                }
            });

            alertDialogBuilder.setNegativeButton("Pamde", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        }
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
