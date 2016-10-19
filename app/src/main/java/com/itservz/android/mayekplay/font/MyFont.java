package com.itservz.android.mayekplay.font;

import android.content.Context;
import android.graphics.Typeface;


public class MyFont {
    private Typeface ratha;
    private Typeface ratha99;
    private Typeface rathayek;
    private static MyFont INSTANCE = null;

    private MyFont(Context context){
        ratha = Typeface.createFromAsset(context.getAssets(), "fonts/RATHA.TTF");
        ratha99 = Typeface.createFromAsset(context.getAssets(), "fonts/RATHA99.TTF");
        rathayek = Typeface.createFromAsset(context.getAssets(), "fonts/rathayek.TTF");
    }

    public static MyFont getInstance(Context context) {
        if(INSTANCE == null){
            INSTANCE = new MyFont(context);
        }
        return INSTANCE;
    }

    public Typeface getRathayek() {
        return rathayek;
    }

}
