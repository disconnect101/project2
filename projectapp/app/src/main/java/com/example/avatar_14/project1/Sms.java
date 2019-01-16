package com.example.avatar_14.project1;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Sms extends AppCompatActivity {

    EditText ph,mssg;
    Button b1;
    AppCompatActivity act = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        b1 = (Button)findViewById(R.id.button20);

        ph = (EditText)findViewById(R.id.editText13);
        mssg = (EditText)findViewById(R.id.editText12);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String p = ph.getText().toString();
                String m = mssg.getText().toString();

                if(ContextCompat.checkSelfPermission(act , Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(act , new String[]{Manifest.permission.SEND_SMS} , 1);
                }

                else{
                    SmsManager sm = SmsManager.getDefault();
                    sm.sendTextMessage(p , null , m , null , null);
                }
            }
        });
    }
}
