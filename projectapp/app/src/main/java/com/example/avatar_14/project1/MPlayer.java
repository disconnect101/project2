package com.example.avatar_14.project1;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class MPlayer extends AppCompatActivity implements SensorEventListener {

    MediaPlayer mp;
    Button b1,b2,b3;
    SeekBar s;
    Runnable runnable;
    Handler handler;
    Switch s1;
    TextView t1;


    Sensor sensor;
    SensorManager sm;

    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mplayer);

        b1 = (Button)findViewById(R.id.button10);
        b2 = (Button)findViewById(R.id.button9);


        mp = new MediaPlayer();

        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        sm.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);

        s1 = (Switch)findViewById(R.id.switch1);
        t1 = (TextView)findViewById(R.id.textView4);
        t1.setText("Sensor Off");


        s = (SeekBar)findViewById(R.id.seekBar);
        mp = MediaPlayer.create(this , R.raw.gnr);
        handler = new Handler();

        s.setMax(mp.getDuration());

        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(s1.isChecked()){
                    t1.setText("Sensor On");
                }
                else{
                    t1.setText("Sensor Off");
                }
            }
        });

        s.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mp.seekTo(s.getProgress());
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mp.isPlaying()) {
                    changeSeekBar();
                }

                mp.start();
            }

        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });

    }





    public void changeSeekBar(){

        if(mp.getDuration() != mp.getCurrentPosition()) {
            s.setProgress(mp.getCurrentPosition());
            runnable = new Runnable() {
                @Override
                public void run() {

                    changeSeekBar();

                }
            };

            handler.postDelayed(runnable, 1000);
        }

    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(s1.isChecked()) {
            if (event.values[0] > 5) {
                if(!mp.isPlaying()) {
                    changeSeekBar();
                }

                mp.start();
            } else {
                mp.pause();
            }
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}

