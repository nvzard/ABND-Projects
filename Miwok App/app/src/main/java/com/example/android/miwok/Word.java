package com.example.android.miwok;

import android.media.MediaPlayer;

public class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int ImageResourceID = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int MediaResourceId;

    public Word(String defaultTranslation, String miwokTranslation, int MediaResourceId){
        this.mDefaultTranslation = defaultTranslation;
        this.mMiwokTranslation = miwokTranslation;
        this.MediaResourceId = MediaResourceId;
    }

    public Word(String defaultTranslation, String miwokTranslation, int ImageResourceID, int MediaResourceId){
        this.mDefaultTranslation = defaultTranslation;
        this.mMiwokTranslation = miwokTranslation;
        this.ImageResourceID = ImageResourceID;
        this.MediaResourceId = MediaResourceId;
    }

    public String getDefaultTranslation(){
        return this.mDefaultTranslation;
    }

    public String getMiwokTranslation(){
        return this.mMiwokTranslation;
    }

    public int getImageResourceID() {
        return ImageResourceID;
    }

    public boolean hasImage(){
        return this.ImageResourceID != NO_IMAGE_PROVIDED;
    }

    public int getMediaResourceId() {
        return MediaResourceId;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", ImageResourceID=" + ImageResourceID +
                ", MediaResourceId=" + MediaResourceId +
                '}';
    }
}
