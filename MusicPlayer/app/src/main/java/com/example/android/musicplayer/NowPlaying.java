package com.example.android.musicplayer;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlaying extends AppCompatActivity {

    static int imageFlag = 0;

    private View.OnClickListener libraryListner = new View.OnClickListener() {
        public void onClick(View view) {
            finish();
        }
    };

    private View.OnClickListener playButtonListner = new View.OnClickListener() {
        public void onClick(View view) {
            ImageView image = (ImageView) view.findViewById(R.id.play);
            if (imageFlag == 0) {
                image.setImageResource(R.drawable.pause);
                imageFlag = 1;
            } else {
                image.setImageResource(R.drawable.play);
                imageFlag = 0;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_now_playing);

        ImageView playImage = (ImageView) findViewById(R.id.play);
        playImage.setImageResource(R.drawable.play);

        playImage.setOnClickListener(playButtonListner);

        TextView songTextView = (TextView) findViewById(R.id.song_name_now_playing);
        Bundle extras = getIntent().getExtras();
        String songName = extras.getString("song_name");
        String artistName = extras.getString("artist_name");
        songTextView.setText(songName + " by " + artistName);

        Button libButton = (Button) findViewById(R.id.back_button);
        libButton.setOnClickListener(libraryListner);
    }
}
