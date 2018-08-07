package com.example.android.mediaplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private static final String SONG_TITLE = "songTitle";
    private static final String SONG_ARTIST = "songArtist";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an arrayList of
        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Just Be", "Tiesto"));
        songs.add(new Song("Promises", "Andain"));
        songs.add(new Song("Voodoo People", "The Prodigy"));
        songs.add(new Song("Halcyon & On & On", "Orbital"));
        songs.add(new Song("One Love", "The Prodigy"));
        songs.add(new Song("Cowgirl", "Underworld"));
        songs.add(new Song("Atom Bomb", "Fluke"));
        songs.add(new Song("A Dream Within A Dream", "Dreadzone"));
        songs.add(new Song("The Saint", "Orbital"));
        songs.add(new Song("Out of My Mind", "Duran Duran"));

        final SongAdapter adapter = new SongAdapter(this, songs);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        //When user clicks on a song, it takes them to the NowPlayingActivity.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long id) {
                Song currentSong = songs.get(index);
                Intent nowPlayingIntent = new Intent(MainActivity.this, NowPlayingActivity.class);
                nowPlayingIntent.putExtra(SONG_TITLE, currentSong.getSongTitle());
                nowPlayingIntent.putExtra(SONG_ARTIST, currentSong.getSongArtist());
                startActivity(nowPlayingIntent);
            }
        });
    }
}
