package com.itservz.android.mayekplay.match;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.itservz.android.mayekplay.R;
import com.itservz.android.mayekplay.ViewBuilder;

import java.util.ArrayList;
import java.util.List;

public class MatchActivity extends AppCompatActivity {
    private ViewBuilder viewBuilder;
    private View linearLayout;
    private ImageView matching = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        viewBuilder = new ViewBuilder();
        linearLayout = ((ViewStub) findViewById(R.id.stub_prep16)).inflate();
        viewBuilder.buildMatch(linearLayout, 10);

    }


    public void click(View view) {
        if (view.getId() == R.id.next_btn_match) {
            viewBuilder.buildMatch(linearLayout, 10);
        }
    }

    boolean secondClick = false;
    public void answered(View view) {
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            if (!secondClick) {
                matching = imageView;
                imageView.setImageResource(0);
                secondClick = true;
            } else if (matching.getTag().equals(imageView.getTag())) {
                imageView.setImageResource(0);
                secondClick = false;
            } else {
                imageView.setImageResource(R.drawable.opacity);
                matching.setImageResource(R.drawable.opacity);
                secondClick = false;
            }

        }
    }
}
