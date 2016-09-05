package com.itservz.android.mayekplay;

import java.io.Serializable;

/**
 * Created by raju.athokpam on 19-08-2016.
 */
public class MayekCard implements Serializable {
    private String title;
    private int res;
    private int sound;


    public MayekCard(String title, int res, int sound) {
        this.title = title;
        this.res = res;
        this.sound = sound;
    }

    public int getSound() {
        return sound;
    }

    public int getRes() {
        return res;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "MayekCard{" +
                "title='" + title + '\'' +
                ", res=" + res +
                ", sound=" + sound +
                '}';
    }
}
