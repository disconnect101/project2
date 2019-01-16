package com.example.avatar_14.project1;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText t1,t2;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button2);
        t1 = (EditText)findViewById(R.id.editText);
        t2 = (EditText)findViewById(R.id.editText10);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1,s2;
                s1 = t1.getText().toString();
                s2 = t2.getText().toString();

                if(s1.equals("") || s2.equals("")){
                    Toast.makeText(MainActivity.this, "Incomplete information!! fill all the fields ", Toast.LENGTH_LONG).show();
                }

                else{
                    SQLiteDatabase db = openOrCreateDatabase("Database1" , MODE_PRIVATE , null);
                    db.execSQL("create table if not exists users (username varchar , email varchar , password varchar , city varchar , phone varchar)");
                    String q = "select * from users where username = '" + s1 + "' and password = '" + s2 + "'";
                    Cursor cursor = db.rawQuery(q , null);


                    if(cursor.getCount() > 0){
                        Toast.makeText(MainActivity.this, "Logging in.", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this , Loggedin.class);
                        startActivity(i);
                        finish();
                    }

                    else{
                        Toast.makeText(MainActivity.this, "Wrong username or password, register if not already registered.", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this , Register.class);
                startActivity(i);
                finish();
            }
        });
    }
}
