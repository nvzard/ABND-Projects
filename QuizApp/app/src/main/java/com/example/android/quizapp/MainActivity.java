package com.example.android.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void computeResults(View view) {

        int score = 0;

        EditText q1 = (EditText) findViewById(R.id.q1);

        RadioButton q2_a = (RadioButton) findViewById(R.id.q2_a);
        RadioButton q2_b = (RadioButton) findViewById(R.id.q2_b);

        RadioButton q3_a = (RadioButton) findViewById(R.id.q3_a);
        RadioButton q3_b = (RadioButton) findViewById(R.id.q3_b);

        CheckBox q4_a = (CheckBox) findViewById(R.id.q4_a);
        CheckBox q4_b = (CheckBox) findViewById(R.id.q4_b);

        RadioButton q5_a = (RadioButton) findViewById(R.id.q5_a);
        RadioButton q5_b = (RadioButton) findViewById(R.id.q5_b);

        if(q1.getText().toString().toLowerCase().equals("camel"))
            score++;
        if(q2_a.isChecked())
            score++;
        if(q3_a.isChecked())
            score++;
        if(q4_a.isChecked() && q4_b.isChecked())
            score++;
        if(q5_b.isChecked())
            score++;

        // Raise a toast based on results
        showResults(score);
    }

    public void showResults(int score) {

        CharSequence text;

        if(score <= 2)
            text = "Score: " + score + "/5 Better luck next time.";
        else if(score > 2 && score < 5)
            text = "Score: " + score + "/5 Well done.";
        else
            text = "Score: " + score + "/5 Dude you are GOD :D";

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

    }
}
