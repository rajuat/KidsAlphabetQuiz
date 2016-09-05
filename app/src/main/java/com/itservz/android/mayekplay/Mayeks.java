package com.itservz.android.mayekplay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Raju on 8/25/2016.
 */
public class Mayeks {
    private final ArrayList<MayekCard> values;
    private final List<Integer> keys;
    private Map<Integer, MayekCard> cards = null;
    private static Mayeks instance = null;

    private Mayeks() {
        cards = new HashMap<>();
        cards.put(R.raw.akok, new MayekCard("KOK", R.drawable.a, R.raw.akok));
        cards.put(R.raw.bsam, new MayekCard("SAM", R.drawable.b, R.raw.bsam));
        cards.put(R.raw.clai, new MayekCard("LAI", R.drawable.c, R.raw.clai));
        cards.put(R.raw.dmit, new MayekCard("MIT", R.drawable.d, R.raw.dmit));
        cards.put(R.raw.epa, new MayekCard("PA", R.drawable.e, R.raw.epa));
        cards.put(R.raw.fna, new MayekCard("NA", R.drawable.f, R.raw.fna));
        cards.put(R.raw.gchil, new MayekCard("CHIL", R.drawable.g, R.raw.gchil));
        cards.put(R.raw.htil, new MayekCard("TIL", R.drawable.h, R.raw.htil));
        cards.put(R.raw.iknou, new MayekCard("KHOU", R.drawable.i, R.raw.iknou));
        cards.put(R.raw.jngou, new MayekCard("NGOU", R.drawable.j, R.raw.jngou));
        cards.put(R.raw.kthou, new MayekCard("THOU", R.drawable.k, R.raw.kthou));
        cards.put(R.raw.lwai, new MayekCard("WAI", R.drawable.l, R.raw.lwai));
        cards.put(R.raw.myang, new MayekCard("YANG", R.drawable.m, R.raw.myang));
        cards.put(R.raw.nhuk, new MayekCard("HUK", R.drawable.n, R.raw.nhuk));
        cards.put(R.raw.ouoon, new MayekCard("UOON", R.drawable.o, R.raw.ouoon));
        cards.put(R.raw.pee, new MayekCard("EE", R.drawable.p, R.raw.pee));
        cards.put(R.raw.qpham, new MayekCard("PHAM", R.drawable.q, R.raw.qpham));
        cards.put(R.raw.ratiya, new MayekCard("ATIYA", R.drawable.r, R.raw.ratiya));
        values = new ArrayList<MayekCard>(cards.values());
        keys = new ArrayList<Integer>(cards.keySet());
    }

    public static Mayeks getInstance() {
        if (instance == null) {
            instance = new Mayeks();
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