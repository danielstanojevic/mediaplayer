package com.example.android.mediaplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class NowPlayingActivity extends AppCompatActivity {

    String songTitle;
    String songArtist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing);

        Intent nowPlayingIntent = getIntent();
        Bundle extras = nowPlayingIntent.getExtras();

        if (extras != null) {
            songArtist = extras.getString("songArtist");
            songTitle = extras.getString("songTitle");

            TextView nowPlayingTitleView = findViewById(R.id.nowPlayingSongTitle);
            nowPlayingTitleView.setText(songTitle);
            TextView nowPlayingArtistView = findViewById(R.id.nowPlayingSongArtist);
            nowPlayingArtistView.setText(songArtist);
            Toast.makeText(this, "Now Playing...", Toast.LENGTH_SHORT).show();
        }
    }
}
