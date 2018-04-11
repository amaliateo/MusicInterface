package com.example.android.musicinterface;

public class Song {
    private String mSongTitle;
    private String mSongDuration;

    public Song(String SongTitle, String SongDuration){
        mSongTitle = SongTitle;
        mSongDuration = SongDuration;
    }
    public String getSongTitle (){
        return mSongTitle;
    }
    public String getSongDuration(){
        return mSongDuration;
    }
}
