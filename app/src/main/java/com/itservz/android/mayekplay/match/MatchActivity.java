package com.itservz.android.mayekplay.match;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.itservz.android.mayekplay.R;
import com.itservz.android.mayekplay.ViewBuilder;

public class MatchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        ViewBuilder viewBuilder = new ViewBuilder();
        //viewBuilder.build();
    }
}
