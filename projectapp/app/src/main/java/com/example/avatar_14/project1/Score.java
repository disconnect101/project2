package com.example.avatar_14.project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Score extends AppCompatActivity {

    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        t1 = (TextView)findViewById(R.id.textView3);

        t1.setText("Your score is : \n" + Quiz.score);
    }
}
