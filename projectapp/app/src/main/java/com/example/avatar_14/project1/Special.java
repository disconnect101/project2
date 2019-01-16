package com.example.avatar_14.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Special extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6;
    static String s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special);

        b1 = (Button)findViewById(R.id.button13);
        b2 = (Button)findViewById(R.id.button14);
        b3 = (Button)findViewById(R.id.button15);
        b4 = (Button)findViewById(R.id.button16);
        b5 = (Button)findViewById(R.id.button17);
        b6 = (Button)findViewById(R.id.button19);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = "http://www.twitter.com";
                Intent i = new Intent(Special.this , Web.class);
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = "http://www.facebook.com";
                Intent i = new Intent(Special.this , Web.class);
                startActivity(i);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = "http://www.google.com";
                Intent i = new Intent(Special.this , Web.class);
                startActivity(i);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Special.this , Quiz.class);
                startActivity(i);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = "http://www.netcamp.in";
                Intent i = new Intent(Special.this , Web.class);
                startActivity(i);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Special.this , Sms.class);
                startActivity(i);
            }
        });


    }
}
