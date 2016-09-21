package com.itservz.android.mayekplay.visual;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.itservz.android.mayekplay.R;

public class VisualActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_visual);

        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                //.addTestDevice("A0A3D2227CBAA74DAC3C250E4861EED3")
                .build();
        adView.loadAd(adRequest);
    }
}
