package com.example.android.userprofile;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView name = (TextView) findViewById(R.id.name);
        name.setText("Nigga Patel");

        TextView birthday = (TextView) findViewById(R.id.birthday);
        birthday.setText("69th September");

        TextView country = (TextView) findViewById(R.id.country);
        country.setText("Indonasia");

        ImageView profile_pic = (ImageView) findViewById(R.id.profile_picture);
        profile_pic.setImageResource(R.drawable.profile_picture);

        setContentView(R.layout.activity_main);

    }
}
