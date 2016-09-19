package com.itservz.android.mayekplay.match;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
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

    private int squares;
    private int matches;
    private int bounces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_match);

        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("A0A3D2227CBAA74DAC3C250E4861EED3")
                .build();
        adView.loadAd(adRequest);

        viewBuilder = new ViewBuilder();

        viewStub6 = ((ViewStub) findViewById(R.id.stub_prep6)).inflate();
        viewBuilder.buildMatch(viewStub6, 6);
        squares = 6;
        viewStub4 = ((ViewStub) findViewById(R.id.stub_prep4)).inflate();
        viewStub4.setVisibility(View.GONE);
        viewStub8 = ((ViewStub) findViewById(R.id.stub_prep8)).inflate();
        viewStub8.setVisibility(View.GONE);
        viewStub10121416 = ((ViewStub) findViewById(R.id.stub_prep16)).inflate();
        viewStub10121416.setVisibility(View.GONE);
        adjustDifficulty();
    }

    private void adjustDifficulty() {
        final SeekBar seekOpq = (SeekBar) findViewById(R.id.opacity_seek);
        seekOpq.setMax(16);
        seekOpq.setProgress(6);
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
                int progress = seekBar.getProgress();
                squares = progress;
                buildLayout(progress);
            }

        });
    }

    private void buildLayout(int progress) {
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
            if(imageView.equals(matching)){
                //clicks the same image twice
                return;
            }
            new CountDownTimer(500, 500) {
                public void onTick(long millisUntilFinished) {
                    imageView.setImageResource(0);
                }

                public void onFinish() {
                    if (!secondClick) {
                        matching = imageView;
                        secondClick = true;
                    } else if (matching.getTag().equals(imageView.getTag())) {
                        secondClick = false;
                        matches++;
                        if(matches == squares/2){
                            final Dialog endDialog = new Dialog(matchActivity);
                            endDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                            endDialog.setContentView(R.layout.activity_match_end);
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
                                    buildLayout(squares);
                                }
                            });
                            TextView matchResult = (TextView) endDialog.findViewById(R.id.match_result);
                            String string = "You had " + bounces + " bounces out of " + matches + " matches.";
                            matchResult.setText(string);

                            endDialog.show();
                        }
                    } else {
                        imageView.setImageResource(R.drawable.questionmark);
                        matching.setImageResource(R.drawable.questionmark);
                        secondClick = false;
                        bounces++;
                    }
                }
            }.start();


        }
    }
}
