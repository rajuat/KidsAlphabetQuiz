package com.itservz.android.mayekplay.prep;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ViewFlipper;

import com.itservz.android.mayekplay.R;

public class PrepActivity extends AppCompatActivity {

    private ViewFlipper viewFlipper;
    private View currentView;
    private String CORRECT_ANSWER = "correct_answer";
    private boolean CORRECT_ANSWER_SELECTED = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prep);

        viewFlipper = (ViewFlipper) findViewById(R.id.prepFlipper);

        View view2 = LayoutInflater.from(this).inflate(R.layout.prep2, null);
        viewFlipper.addView(view2);

        View view3 = LayoutInflater.from(this).inflate(R.layout.prep3, null);
        viewFlipper.addView(view3);

        View view4 = LayoutInflater.from(this).inflate(R.layout.prep4, null);
        viewFlipper.addView(view4);

        viewFlipper.setDisplayedChild(viewFlipper.indexOfChild(currentView));

        View view21 = view2.findViewById(R.id.prep21);
        view21.setBackgroundResource(R.drawable.pic);
        view21.setTag(CORRECT_ANSWER);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(CORRECT_ANSWER_SELECTED) {
                    viewFlipper.showNext();
                }
            }
        });
    }

    public void answered(View view) {
        if (view.getTag() != null && view.getTag().equals(CORRECT_ANSWER)) {
            CORRECT_ANSWER_SELECTED = true;
        } else {
            CORRECT_ANSWER_SELECTED = false;
        }
    }
}
