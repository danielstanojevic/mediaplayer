package com.example.android.mediaplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.AdapterView.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an arrayList of
        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("My Jam","Daniel"));
        songs.add(new Song("title", "artist"));
        songs.add(new Song("three", "tolookosu"));
        songs.add(new Song("four", "oyyisa"));
        songs.add(new Song("five", "massokka"));
        songs.add(new Song("six", "temmokka"));
        songs.add(new Song("seven", "kenekaku"));
        songs.add(new Song("eight", "kawinta"));
        songs.add(new Song("nine", "wo'e"));
        songs.add(new Song("ten", "na'aacha"));

        final SongAdapter adapter = new SongAdapter(this, songs);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        //When user clicks on a song, it takes them to the Currently Playing screen.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {

                Song currentSong = songs.get(i);

                Intent currentlyPlayingIntent = new Intent(MainActivity.this, NowPlayingActivity.class);
                currentlyPlayingIntent.putExtra("songTitle", currentSong.getSongTitle());
                currentlyPlayingIntent.putExtra("songArtist", currentSong.getSongArtist());
                startActivity(currentlyPlayingIntent);
            }
        });

        //adapter.setCustomOnClickListener(R.id.list_item, NowPlayingActivity.class);
        //adapter.setCustomOnClickListener(listView.getAdapter().,NowPlayingActivity.class,listView);
    }

    public void setCustomOnClickListener(int resourceID, final Class className) {
        // Find the View that shows the numbers category
        View view = findViewById(resourceID);

        // Set a click listener on  that View
        if (view != null) {
            view.setOnClickListener(
                    new OnClickListener() {
                        // The code in this method will be executed when the respective View is clicked on.
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(MainActivity.this, className);
                            startActivity(intent);
                        }
                    });
        }
    }
}
