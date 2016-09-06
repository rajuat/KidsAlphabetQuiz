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
        mSounds.put(R.raw.akok, this.mShortPlayer.load(pContext, R.raw.akok, 1));
        mSounds.put(R.raw.bsam, this.mShortPlayer.load(pContext, R.raw.bsam, 1));
        mSounds.put(R.raw.clai, this.mShortPlayer.load(pContext, R.raw.clai, 1));
        mSounds.put(R.raw.dmit, this.mShortPlayer.load(pContext, R.raw.dmit, 1));
        mSounds.put(R.raw.epa, this.mShortPlayer.load(pContext, R.raw.epa, 1));
        mSounds.put(R.raw.fna, this.mShortPlayer.load(pContext, R.raw.fna, 1));
        mSounds.put(R.raw.gchil, this.mShortPlayer.load(pContext, R.raw.gchil, 1));
        mSounds.put(R.raw.htil, this.mShortPlayer.load(pContext, R.raw.htil, 1));
        mSounds.put(R.raw.iknou, this.mShortPlayer.load(pContext, R.raw.iknou, 1));
        mSounds.put(R.raw.jngou, this.mShortPlayer.load(pContext, R.raw.jngou, 1));
        mSounds.put(R.raw.kthou, this.mShortPlayer.load(pContext, R.raw.kthou, 1));
        mSounds.put(R.raw.lwai, this.mShortPlayer.load(pContext, R.raw.lwai, 1));
        mSounds.put(R.raw.myang, this.mShortPlayer.load(pContext, R.raw.myang, 1));
        mSounds.put(R.raw.nhuk, this.mShortPlayer.load(pContext, R.raw.nhuk, 1));
        mSounds.put(R.raw.ouoon, this.mShortPlayer.load(pContext, R.raw.ouoon, 1));
        mSounds.put(R.raw.pee, this.mShortPlayer.load(pContext, R.raw.pee, 1));
        mSounds.put(R.raw.qpham, this.mShortPlayer.load(pContext, R.raw.qpham, 1));
        mSounds.put(R.raw.ratiya, this.mShortPlayer.load(pContext, R.raw.ratiya, 1));
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
