package com.example.avatar_14.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Quiz extends AppCompatActivity {

    TextView t1;
    RadioButton r1,r2,r3,r4;
    Button b1;
    int c = 1;
    static int score;

    String q1[] ={"Buddhist and Jain" , "2720" , "Atlantic" , "Wealth Tax"};
    String q2[] = {"Hindu and Muslim" , "3720" , "Artic" , "Gift Tax"};
    String q3[] = {"Buddhist" , "2270" , "Pacific" , "Education Tax"};
    String q4[] = {"Hindu , Buddhist and Jain" , "3270" , "Antartic" , "Road Tax"};

    String Q[] = {"The caves and rock-cut temples of Ellora are? ?" , "Congo River in Africa is how many miles long ?" , "The Southern Ocean also known was ?" , "Which tax was abolished by government in 2015 Budget ?"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        t1 = (TextView)findViewById(R.id.textView2);

        r1 = (RadioButton)findViewById(R.id.radioButton);
        r2 = (RadioButton)findViewById(R.id.radioButton2);
        r3 = (RadioButton)findViewById(R.id.radioButton3);
        r4 = (RadioButton)findViewById(R.id.radioButton4);

        b1 = (Button)findViewById(R.id.button18);


        r1.setText(q1[0]);
        r2.setText(q2[0]);
        r3.setText(q3[0]);
        r4.setText(q4[0]);
        t1.setText(Q[0]);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (c){
                    case 1:if(r4.isChecked()){
                        score++;
                    }
                    break;

                    case 2:if(r1.isChecked()){
                        score++;
                    }
                    break;

                    case 3:if(r4.isChecked()){
                        score++;
                    }
                        break;

                    case 4:if(r2.isChecked()){
                        score++;
                    }
                    break;
                }

                if(c == 4){
                    Intent i = new Intent(Quiz.this , Score.class);
                    startActivity(i);
                    finish();
                }

                if (c < 4) {
                    r1.setText(q1[c]);
                    r2.setText(q2[c]);
                    r3.setText(q3[c]);
                    r4.setText(q4[c]);
                    t1.setText(Q[c]);
                    c++;

                }

            }
        });
    }
}
