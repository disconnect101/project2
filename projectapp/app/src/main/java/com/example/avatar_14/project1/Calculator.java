package com.example.avatar_14.project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {

    EditText t1,t2;
    TextView v1;
    Button b1,b2,b3,b4,b5,b6;
    double d1=0,d2=0;
    String s1,s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        b1 = (Button)findViewById(R.id.button31);
        b2 = (Button)findViewById(R.id.button32);
        b3 = (Button)findViewById(R.id.button33);
        b4 = (Button)findViewById(R.id.button34);
        b5 = (Button)findViewById(R.id.button21);
        b6 = (Button)findViewById(R.id.button22);

        t1 = (EditText)findViewById(R.id.editText8);
        t2 = (EditText)findViewById(R.id.editText9);

        v1 = (TextView)findViewById(R.id.textView);




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (!((s1 = t1.getText().toString()).equals("") || (s2 = t2.getText().toString()).equals(""))) {
                        d1 = Double.parseDouble(s1);
                        d2 = Double.parseDouble(s2);
                    }
                    v1.setText(String.valueOf(d1 + d2));
                }
                catch (Exception e){
                    Toast.makeText(Calculator.this, "Invalid Arguments !!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (!((s1 = t1.getText().toString()).equals("") || (s2 = t2.getText().toString()).equals(""))) {
                        d1 = Double.parseDouble(s1);
                        d2 = Double.parseDouble(s2);
                    }
                    v1.setText(String.valueOf(d1 - d2));
                }
                catch(Exception e){
                    Toast.makeText(Calculator.this, "Invalid Arguments !!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (!((s1 = t1.getText().toString()).equals("") || (s2 = t2.getText().toString()).equals(""))) {
                        d1 = Double.parseDouble(s1);
                        d2 = Double.parseDouble(s2);
                    }

                    v1.setText(String.valueOf(d1 * d2));
                }
                catch(Exception e){
                    Toast.makeText(Calculator.this, "Invalis Arguments !!!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (!((s1 = t1.getText().toString()).equals("") || (s2 = t2.getText().toString()).equals(""))) {
                        d1 = Double.parseDouble(s1);
                        d2 = Double.parseDouble(s2);
                    }
                    v1.setText(String.valueOf(d1 / d2));
                }
                catch(Exception e){
                    Toast.makeText(Calculator.this, "Invalid Arguments !!! ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText("");
                t2.setText("");
                v1.setText("");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(v1.getText().toString());
                t2.setText("");
                v1.setText("");

            }
        });


    }
}
