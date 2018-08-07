package com.example.android.mediaplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class NowPlayingActivity extends AppCompatActivity {

    private static final String SONG_TITLE = "songTitle";
    private static final String SONG_ARTIST = "songArtist";

    String songTitle;
    String songArtist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing);

        Intent nowPlayingIntent = getIntent();
        Bundle extras = nowPlayingIntent.getExtras();

        if (extras != null) {
            songArtist = extras.getString(SONG_ARTIST);
            songTitle = extras.getString(SONG_TITLE);

            TextView nowPlayingTitleView = findViewById(R.id.nowPlayingSongTitle);
            nowPlayingTitleView.setText(getString(R.string.media_title, songTitle));
            TextView nowPlayingArtistView = findViewById(R.id.nowPlayingSongArtist);
            nowPlayingArtistView.setText(getString(R.string.media_artist,songArtist));
            Toast.makeText(this, R.string.now_playing, Toast.LENGTH_SHORT).show();
        }
    }
}
