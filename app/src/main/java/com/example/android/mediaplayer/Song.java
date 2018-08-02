package com.example.android.mediaplayer;

public class Song {
    private String mSongTitle;
    private String mSongArtist;

    public String getSongTitle() {
        return mSongTitle;
    }

    public String getSongArtist() {
        return mSongArtist;
    }
    //Constructor
    public Song(String songTitle, String songArtist){
        mSongTitle = songTitle;
        mSongArtist = songArtist;
    }
}
