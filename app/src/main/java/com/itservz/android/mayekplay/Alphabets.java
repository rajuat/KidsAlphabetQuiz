package com.itservz.android.mayekplay;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Raju on 8/25/2016.
 */
public class Alphabets {
    private final ArrayList<MayekCard> values;
    private final List<Integer> keys;
    private Map<Integer, MayekCard> cards = null;
    private static Alphabets instance = null;

    private Alphabets() {
        cards = new HashMap<>();
        cards.put(R.raw.a, new MayekCard("", R.drawable.aa, R.raw.a));
        cards.put(R.raw.b, new MayekCard("", R.drawable.bb, R.raw.b));
        cards.put(R.raw.c, new MayekCard("", R.drawable.cc, R.raw.c));
        cards.put(R.raw.d, new MayekCard("", R.drawable.dd, R.raw.d));
        cards.put(R.raw.e, new MayekCard("", R.drawable.ee, R.raw.e));
        cards.put(R.raw.f, new MayekCard("", R.drawable.ff, R.raw.f));
        cards.put(R.raw.g, new MayekCard("", R.drawable.gg, R.raw.g));
        cards.put(R.raw.h, new MayekCard("", R.drawable.hh, R.raw.h));
        cards.put(R.raw.i, new MayekCard("", R.drawable.ii, R.raw.i));
        cards.put(R.raw.j, new MayekCard("", R.drawable.jj, R.raw.j));
        cards.put(R.raw.k, new MayekCard("", R.drawable.kk, R.raw.k));
        cards.put(R.raw.l, new MayekCard("", R.drawable.ll, R.raw.l));
        cards.put(R.raw.m, new MayekCard("", R.drawable.mm, R.raw.m));
        cards.put(R.raw.n, new MayekCard("", R.drawable.nn, R.raw.n));
        cards.put(R.raw.o, new MayekCard("", R.drawable.oo, R.raw.o));
        cards.put(R.raw.p, new MayekCard("", R.drawable.pp, R.raw.p));
        cards.put(R.raw.q, new MayekCard("", R.drawable.qq, R.raw.q));
        cards.put(R.raw.r, new MayekCard("", R.drawable.rr, R.raw.r));
        cards.put(R.raw.s, new MayekCard("", R.drawable.ss, R.raw.s));
        cards.put(R.raw.t, new MayekCard("", R.drawable.tt, R.raw.t));
        cards.put(R.raw.u, new MayekCard("", R.drawable.uu, R.raw.u));
        cards.put(R.raw.v, new MayekCard("", R.drawable.vv, R.raw.v));
        cards.put(R.raw.w, new MayekCard("", R.drawable.ww, R.raw.w));
        cards.put(R.raw.x, new MayekCard("", R.drawable.xx, R.raw.x));
        cards.put(R.raw.y, new MayekCard("", R.drawable.yy, R.raw.y));
        cards.put(R.raw.z, new MayekCard("", R.drawable.zz, R.raw.z));
        values = new ArrayList<MayekCard>(cards.values());
        keys = new ArrayList<Integer>(cards.keySet());
    }

    public static Alphabets getInstance() {
        if (instance == null) {
            instance = new Alphabets();
        }
        return instance;
    }

    public List<MayekCard> getCardList() {
        return values;
    }


    public Map<Integer, MayekCard> getCardMap() {
        return cards;
    }

    public List<Integer> getKeys() {
        return keys;
    }

}