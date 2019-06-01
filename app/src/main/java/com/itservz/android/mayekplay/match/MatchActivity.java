package com.itservz.android.mayekplay.match;

import android.app.Activity;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.itservz.android.mayekplay.MainActivity;
import com.itservz.android.mayekplay.R;
import com.itservz.android.mayekplay.ViewBuilder;

public class MatchActivity extends Activity {
    private ViewBuilder viewBuilder;
    private ImageView matching = null;
    boolean secondClick = false;

    private View viewStub4;
    private View viewStub6;
    private View viewStub8;
    private View viewStub10121416;
    private int matches;
    private int bounces;
    private int progress;
    private boolean abc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_match);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        abc = prefs.getBoolean(MainActivity.ABC, false);

        viewBuilder = new ViewBuilder(abc, getApplicationContext());

        viewStub6 = ((ViewStub) findViewById(R.id.stub_prep6)).inflate();
        viewBuilder.buildMatch(viewStub6, 6);
        viewStub4 = ((ViewStub) findViewById(R.id.stub_prep4)).inflate();
        viewStub4.setVisibility(View.GONE);
        viewStub8 = ((ViewStub) findViewById(R.id.stub_prep8)).inflate();
        viewStub8.setVisibility(View.GONE);
        viewStub10121416 = ((ViewStub) findViewById(R.id.stub_prep16)).inflate();
        viewStub10121416.setVisibility(View.GONE);
        adjustDifficulty();

        if(abc){
            ((TextView) findViewById(R.id.seek_bar_easy)).setText("  Easy  ");
            ((TextView) findViewById(R.id.seek_bar_difficult)).setText("Difficult");
        }
    }

    private void adjustDifficulty() {
        final SeekBar seekOpq = (SeekBar) findViewById(R.id.opacity_seek);
        seekOpq.getProgressDrawable().setColorFilter(0xFF00FF00, PorterDuff.Mode.MULTIPLY);
        //seekOpq.getThumb().setColorFilter(0xFF00FF00, PorterDuff.Mode.MULTIPLY);
        seekOpq.setMax(16);
        seekOpq.setProgress(6);
        progress = seekOpq.getProgress();
        seekOpq.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress <= 4) {
                    seekBar.setProgress(4);
                } else if (progress <= 6) {
                    seekBar.setProgress(6);
                } else if (progress <= 8) {
                    seekBar.setProgress(8);
                } else if (progress <= 10) {
                    seekBar.setProgress(10);
                } else if (progress <= 12) {
                    seekBar.setProgress(12);
                } else if (progress <= 14) {
                    seekBar.setProgress(14);
                } else if (progress <= 16) {
                    seekBar.setProgress(16);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                progress = seekBar.getProgress();
                buildLayout(progress);
            }

        });
    }

    private void buildLayout(int progress) {
        matches = 0;
        if (progress == 4) {
            viewStub4.setVisibility(View.VISIBLE);
            viewStub6.setVisibility(View.GONE);
            viewStub8.setVisibility(View.GONE);
            viewStub10121416.setVisibility(View.GONE);
            viewBuilder.buildMatch(viewStub4, progress);
        } else if (progress == 6) {
            viewStub4.setVisibility(View.GONE);
            viewStub6.setVisibility(View.VISIBLE);
            viewStub8.setVisibility(View.GONE);
            viewStub10121416.setVisibility(View.GONE);
            viewBuilder.buildMatch(viewStub6, progress);
        } else if (progress == 8) {
            viewStub4.setVisibility(View.GONE);
            viewStub6.setVisibility(View.GONE);
            viewStub8.setVisibility(View.VISIBLE);
            viewStub10121416.setVisibility(View.GONE);
            viewBuilder.buildMatch(viewStub8, progress);
        } else if ((progress == 10) || (progress == 12) || (progress == 14) || (progress == 16)) {
            viewStub4.setVisibility(View.GONE);
            viewStub6.setVisibility(View.GONE);
            viewStub8.setVisibility(View.GONE);
            viewStub10121416.setVisibility(View.VISIBLE);
            viewBuilder.buildMatch(viewStub10121416, progress);
        }
    }

    public void answered(View view) {
        if (view instanceof ImageView) {
            final MatchActivity matchActivity = this;
            final ImageView imageView = (ImageView) view;
            if (imageView.equals(matching)) {
                //clicks the same image twice - still clearing the image
                return;
            }
            if (!secondClick) {
                imageView.setImageResource(0);
                matching = imageView;
                secondClick = true;
            } else if (matching.getTag().equals(imageView.getTag())) {
                imageView.setImageResource(0);
                secondClick = false;
                matches++;
                matching.setClickable(false);
                imageView.setClickable(false);
                //end of game
                if (matches >= progress / 2) {
                    final Dialog endDialog = new Dialog(matchActivity, R.style.full_screen_dialog);
                    endDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    endDialog.setContentView(R.layout.activity_match_end);
                    endDialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                    endDialog.getWindow().setFormat(PixelFormat.TRANSLUCENT);
                    ColorDrawable drawable = new ColorDrawable(Color.WHITE);
                    drawable.setAlpha(80);
                    endDialog.getWindow().setBackgroundDrawable(drawable);

                    Button smallBtn = (Button) endDialog.findViewById(R.id.match_dailog_close);
                    smallBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            endDialog.dismiss();
                            finish();
                        }
                    });
                    Button playAgainBtn = (Button) endDialog.findViewById(R.id.match_dailog_play_again);
                    playAgainBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            endDialog.dismiss();
                            buildLayout(progress);
                        }
                    });
                    TextView matchResult = (TextView) endDialog.findViewById(R.id.match_result);
                    int efficiency = ((matches * 100) / (matches + bounces));
                    String string = "You had " + bounces + " bounces out of " + matches + " matches. " + efficiency + " % efficient.";
                    matchResult.setText(string);
                    if(abc){
                        ((Button) endDialog.findViewById(R.id.match_dailog_play_again)).setText(" Play again ");
                        ((Button) endDialog.findViewById(R.id.match_dailog_close)).setText("Play another");
                    }
                    endDialog.show();
                }
            } else {
                notMatches(imageView).start();
            }
        }
    }

    private CountDownTimer notMatches(final ImageView imageView) {
        return new CountDownTimer(500, 500) {
            public void onTick(long millisUntilFinished) {
                imageView.setImageResource(0);
            }

            public void onFinish() {
                imageView.setImageResource(R.drawable.questionmark);
                matching.setImageResource(R.drawable.questionmark);
                secondClick = false;
                bounces++;
            }
        };
    }

}

