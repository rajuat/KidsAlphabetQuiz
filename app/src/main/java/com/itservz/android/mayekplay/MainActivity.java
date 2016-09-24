package com.itservz.android.mayekplay;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.widget.AppCompatRadioButton;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.MobileAds;
import com.itservz.android.mayekplay.match.MatchActivity;
import com.itservz.android.mayekplay.prep.PrepActivity;
import com.itservz.android.mayekplay.quiz.QuizActivity;
import com.itservz.android.mayekplay.visual.VisualActivity;

public class MainActivity extends Activity {

    public static String ABC = "en";

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
    private Dialog dialog;
    private SharedPreferences.Editor editor;
    private SharedPreferences prefs;
    private boolean abc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //MobileAds.initialize(getApplicationContext(), "ca-app-pub-3940256099942544~3347511713"); testads
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-7027483312186624~2667460990");
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

    @Override
    protected void onResume() {
        super.onResume();
        setLocaleText();
    }

    private void setLocaleText() {
        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        abc = prefs.getBoolean(ABC, false);
        if(abc){
            ((Button)findViewById(R.id.fab)).setText(" Start ");
            ((TextView) findViewById(R.id.title)).setText("Let's play Mayek :-)");
        } else {
            ((Button)findViewById(R.id.fab)).setText("Hourase");
            ((TextView) findViewById(R.id.title)).setText("Mayek sanase :-)");
        }
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
            if(abc){
                Toast.makeText(this, "Choose KOK SAM LAI option to use this.", Toast.LENGTH_SHORT).show();
            }
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
            dialog = new Dialog(this, R.style.full_screen_dialog);
            dialog.setContentView(R.layout.floating_setting);
            dialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            dialog.getWindow().setFormat(PixelFormat.TRANSLUCENT);
            ColorDrawable drawable = new ColorDrawable(Color.WHITE);
            drawable.setAlpha(80);
            dialog.getWindow().setBackgroundDrawable(drawable);

            RadioGroup radio = (RadioGroup) dialog.findViewById(R.id.radioLetters);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                for (int i = 0; i < radio.getChildCount(); i++) {
                    RadioButton button = (RadioButton) radio.getChildAt(i);
                    //button.setBackground(new ColorDrawable(Color.WHITE));
                    button.setButtonTintList(colorStateList);
                    button.invalidate();
                }
            }
            prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            boolean abc = prefs.getBoolean(ABC, false);
            if (abc) {
                radio.check(R.id.english);
            } else {
                radio.check(R.id.manipuri);
            }

            dialog.show();

            radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                    editor = prefs.edit();
                    RadioButton radioButton = (RadioButton) radioGroup.findViewById(checkedId);
                    int index = radioGroup.indexOfChild(radioButton);
                    switch (index) {
                        case 0:
                            editor.putBoolean(ABC, true);
                            editor.commit();
                            dialog.dismiss();
                            setLocaleText();
                            break;
                        case 1:
                            editor.putBoolean(ABC, false);
                            editor.commit();
                            dialog.dismiss();
                            setLocaleText();
                            break;
                    }
                }
            });

            Button mayekid = (Button) dialog.findViewById(R.id.mayekid);
            mayekid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final String appPackageName = "com.itservz.android.mayekid";
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                    } catch (ActivityNotFoundException anfe) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                    }
                    dialog.dismiss();
                }
            });

            ImageView rate = (ImageView) dialog.findViewById(R.id.rate);
            rate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.itservz.android.mayekplay")));
                }
            });

            Button back = (Button) dialog.findViewById(R.id.backToMainPage);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
        }

    }

    ColorStateList colorStateList = new ColorStateList(
            new int[][]{
                    new int[]{-android.R.attr.state_checked},
                    new int[]{android.R.attr.state_checked}
            },
            new int[]{

                    Color.WHITE
                    , Color.parseColor("#BA4A00"),
            }
    );

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
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}
