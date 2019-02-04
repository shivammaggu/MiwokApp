package com.example.android.miwok;

public class Word {

    private String mdefaultTrans;

    private String mmiwaktrans;

    /** Image resource ID for the word */
    private int mResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    private int mMusicResID;

    public Word(String defaultTrans, String miwakTrans, int musicResID) {

        mdefaultTrans = defaultTrans;
        mmiwaktrans = miwakTrans;
        mMusicResID = musicResID;
    }


    public Word(String defaultTrans, String miwakTrans, int resourceId, int musicResID) {

        mdefaultTrans = defaultTrans;
        mmiwaktrans = miwakTrans;
        mResourceId = resourceId;
        mMusicResID = musicResID;
    }

    public String getMdefaultTrans() {
        return mdefaultTrans;
    }

    public String getMmiwaktrans() {
        return mmiwaktrans;
    }

    public int getmResourceId() { return mResourceId; }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mResourceId != NO_IMAGE_PROVIDED;
    }

    public int getmMusicResID() {
        return mMusicResID;
    }
}