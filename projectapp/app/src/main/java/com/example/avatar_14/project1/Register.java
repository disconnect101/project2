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

public class Register extends AppCompatActivity {

    EditText t1,t2,t3,t4,t5;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        t1 = (EditText)findViewById(R.id.editText3);
        t2 = (EditText)findViewById(R.id.editText4);
        t3 = (EditText)findViewById(R.id.editText2);
        t4 = (EditText)findViewById(R.id.editText6);
        t5 = (EditText)findViewById(R.id.editText7);

        b1 = (Button)findViewById(R.id.button3);
        b2 = (Button)findViewById(R.id.button4);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1,s2,s3,s4,s5;
                s1 = t1.getText().toString();
                s2 = t2.getText().toString();
                s3 = t3.getText().toString();
                s4 = t4.getText().toString();
                s5 = t5.getText().toString();

                if(s1.equals("") || s2.equals("") || s3.equals("") || s4.equals("") || s5.equals("")){
                    Toast.makeText(Register.this, "Incomplete information!!", Toast.LENGTH_SHORT).show();
                }

                else{
                    SQLiteDatabase db = openOrCreateDatabase("Database1" , MODE_PRIVATE , null);
                    db.execSQL("create table if not exists users (username varchar , email varchar , password varchar , city varchar , phone varchar)");
                    String q = "select * from users where username = '" + s1 + "'";
                    Cursor cursor = db.rawQuery(q , null);

                    if(cursor.getCount() > 0){
                        Toast.makeText(Register.this, "username already taken", Toast.LENGTH_SHORT).show();
                    }

                    else{
                        db.execSQL("insert into users values('" + s1 + "' , '" + s2 + "' , '" + s3 + "' , '" + s4 + "' , '" + s5 + "')");
                        Toast.makeText(Register.this, "Registration Successful!!!", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Register.this , Loggedin.class);
                        startActivity(i);
                    }
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Register.this , MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
