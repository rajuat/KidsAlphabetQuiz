package com.itservz.android.mayekplay;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import java.util.HashMap;

/**
 * Created by raju.athokpam on 24-08-2016.
 */
public class MayekSoundPoolPlayer {
    private SoundPool mShortPlayer = null;
    private HashMap mSounds = new HashMap();

    public MayekSoundPoolPlayer(Context pContext) {
        this.mShortPlayer = new SoundPool(4, AudioManager.STREAM_MUSIC, 0);
        mSounds.put(R.raw.a, this.mShortPlayer.load(pContext, R.raw.a, 1));
        mSounds.put(R.raw.b, this.mShortPlayer.load(pContext, R.raw.b, 1));
        mSounds.put(R.raw.c, this.mShortPlayer.load(pContext, R.raw.c, 1));
        mSounds.put(R.raw.d, this.mShortPlayer.load(pContext, R.raw.d, 1));
        mSounds.put(R.raw.e, this.mShortPlayer.load(pContext, R.raw.e, 1));
        mSounds.put(R.raw.f, this.mShortPlayer.load(pContext, R.raw.f, 1));
        mSounds.put(R.raw.g, this.mShortPlayer.load(pContext, R.raw.g, 1));
        mSounds.put(R.raw.h, this.mShortPlayer.load(pContext, R.raw.h, 1));
        mSounds.put(R.raw.i, this.mShortPlayer.load(pContext, R.raw.i, 1));
        mSounds.put(R.raw.j, this.mShortPlayer.load(pContext, R.raw.j, 1));
        mSounds.put(R.raw.k, this.mShortPlayer.load(pContext, R.raw.k, 1));
        mSounds.put(R.raw.l, this.mShortPlayer.load(pContext, R.raw.l, 1));
        mSounds.put(R.raw.m, this.mShortPlayer.load(pContext, R.raw.m, 1));
        mSounds.put(R.raw.n, this.mShortPlayer.load(pContext, R.raw.n, 1));
        mSounds.put(R.raw.o, this.mShortPlayer.load(pContext, R.raw.o, 1));
        mSounds.put(R.raw.p, this.mShortPlayer.load(pContext, R.raw.p, 1));
        mSounds.put(R.raw.q, this.mShortPlayer.load(pContext, R.raw.q, 1));
        mSounds.put(R.raw.r, this.mShortPlayer.load(pContext, R.raw.r, 1));
        mSounds.put(R.raw.s, this.mShortPlayer.load(pContext, R.raw.s, 1));
        mSounds.put(R.raw.t, this.mShortPlayer.load(pContext, R.raw.t, 1));
        mSounds.put(R.raw.u, this.mShortPlayer.load(pContext, R.raw.u, 1));
        mSounds.put(R.raw.v, this.mShortPlayer.load(pContext, R.raw.v, 1));
        mSounds.put(R.raw.w, this.mShortPlayer.load(pContext, R.raw.w, 1));
        mSounds.put(R.raw.x, this.mShortPlayer.load(pContext, R.raw.x, 1));
        mSounds.put(R.raw.y, this.mShortPlayer.load(pContext, R.raw.y, 1));
        mSounds.put(R.raw.z, this.mShortPlayer.load(pContext, R.raw.z, 1));
    }

    public void playShortResource(int piResource) {
        int iSoundId = (Integer) mSounds.get(piResource);
        this.mShortPlayer.play(iSoundId, 0.99f, 0.99f, 0, 0, 1);
    }

    public void release() {
        this.mShortPlayer.release();
        this.mShortPlayer = null;
    }
}
