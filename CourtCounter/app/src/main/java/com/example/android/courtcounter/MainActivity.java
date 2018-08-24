package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int goalsFCB = 0;
    int foulsFCB = 0;
    int goalsRM = 0;
    int foulsRM = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayFCB(goalsFCB, foulsRM);
        displayRM(goalsRM, foulsRM);
    }

    public void addGoalFCB(View view) {
        displayFCB(++goalsFCB, foulsFCB);
    }

    public void addFoulFCB(View view) {
        displayFCB(goalsFCB, ++foulsFCB);

    }

    public void addGoalRM(View view) {
        displayRM(++goalsRM, foulsRM);
    }

    public void addFoulRM(View view) {
        displayRM(goalsRM, ++foulsRM);

    }


    public void resetAll(View view) {
        goalsFCB = 0;
        foulsFCB = 0;
        goalsRM = 0;
        foulsRM = 0;
        displayFCB(goalsFCB, foulsFCB);
        displayRM(goalsRM, foulsRM);
    }

    public void displayFCB(int goals, int fouls) {
        TextView scoreView = (TextView) findViewById(R.id.fcb_score);
        scoreView.setText("Goals: " + goals);
        TextView foulView = (TextView) findViewById(R.id.fcb_fouls);
        foulView.setText("Fouls: " + fouls);
    }

    public void displayRM(int goals, int fouls) {
        TextView scoreView = (TextView) findViewById(R.id.rm_score);
        scoreView.setText("Goals: " + goals);
        TextView foulView = (TextView) findViewById(R.id.rm_fouls);
        foulView.setText("Fouls: " + fouls);
    }
}
