package com.example.android.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;


public class MusicLibrary extends AppCompatActivity {


    private AdapterView.OnItemClickListener nowPlayingListner = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            openNowPlaying(view);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_library);

        ArrayList<Song> songs = new ArrayList<Song>();

        songs.add(new Song("Time in a Bottle ", "Burning Love 2", "Jim Croce", "2:26"));
        // Eminem
        songs.add(new Song("Not Afraid", "Recovery", "Eminem", "4:11", R.drawable.recovery));
        songs.add(new Song("W.T.P.", "Recovery", "Eminem", "3:58", R.drawable.recovery));
        songs.add(new Song("Cinderella Man", "Recovery", "Eminem", "4:39", R.drawable.recovery));
        // Kendrick Lamar
        songs.add(new Song("DNA.", "DAMN.", "Kendrick Lamar", "3;05", R.drawable.damn));
        songs.add(new Song("HUMBLE.", "DAMN.", "Kendrick Lamar", "2;57", R.drawable.damn));
        songs.add(new Song("LOYALTY.", "DAMN.", "Kendrick Lamar", "3;47", R.drawable.damn));
        // Post Malone
        songs.add(new Song("White Iverson", "Stoney", "Post Malone", "4:14", R.drawable.malone));
        songs.add(new Song("rockstar", "beerbongs & bentleys", "Post Malone", "3:39"));

        Collections.sort(songs);

        MusicAdapter adapter =
                new MusicAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(nowPlayingListner);

    }

    public void openNowPlaying(View view) {
        Intent nowPlayingIntent = new Intent(this, NowPlaying.class);
        TextView songTextView = (TextView) view.findViewById(R.id.song_text_view);
        TextView artistTextView = (TextView) view.findViewById(R.id.artist_text_view);

        String song_name = songTextView.getText().toString();
        String artist_name = artistTextView.getText().toString();

        nowPlayingIntent.putExtra("song_name", song_name);
        nowPlayingIntent.putExtra("artist_name", artist_name);
        startActivity(nowPlayingIntent);
    }

}
