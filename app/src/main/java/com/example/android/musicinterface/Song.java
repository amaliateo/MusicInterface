package com.example.android.musicinterface;

public class Song {
    private String mSongTitle;
    private String mSongDuration;
    private String mArtistName;

    public Song(String ArtistName, String SongTitle, String SongDuration) {
        mArtistName = ArtistName;
        mSongTitle = SongTitle;
        mSongDuration = SongDuration;
    }

    public String getArtistName() {
        return mArtistName;
    }

    public String getSongTitle() {
        return mSongTitle;
    }

    public String getSongDuration() {
        return mSongDuration;
    }

}
