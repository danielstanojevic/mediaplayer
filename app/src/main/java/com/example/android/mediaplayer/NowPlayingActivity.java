package com.example.android.mediaplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing);

        Intent nowPlayingIntent = getIntent();

        TextView nowPlayingTitleView = findViewById(R.id.nowPlayingSongTitle);
        TextView nowPlayingArtistView = findViewById(R.id.nowPlayingSongArtist);
        Toast.makeText(this, "Now Playing...", Toast.LENGTH_SHORT).show();
        startActivity(nowPlayingIntent);
        //nowPlayingTitleView.setText(nowPlayingIntent.getStringExtra());
    }
}
