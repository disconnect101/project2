package com.example.avatar_14.project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class advCalculator extends AppCompatActivity implements View.OnClickListener {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bc,be,bm,ba,bmi,bd,bf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adv_calculator);

        b1.findViewById(R.id.button29);
        b2.findViewById(R.id.button29);
        b3.findViewById(R.id.button29);
        b4.findViewById(R.id.button29);
        b5.findViewById(R.id.button29);
        b6.findViewById(R.id.button29);
        b7.findViewById(R.id.button29);
        b8.findViewById(R.id.button29);
        b9.findViewById(R.id.button29);
        b0.findViewById(R.id.button29);
        bc.findViewById(R.id.button29);
        be.findViewById(R.id.button29);
        bm.findViewById(R.id.button29);
        ba.findViewById(R.id.button29);
        bmi.findViewById(R.id.button29);
        bd.findViewById(R.id.button29);
        bf.findViewById(R.id.button29);

        b1.setOnClickListener(this);

        /*b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/



    }

    @Override
    public void onClick(View v) {
        v.getId();


    }
}
