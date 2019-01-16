package com.example.avatar_14.project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Web extends AppCompatActivity {

    WebView w1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        w1 = (WebView)findViewById(R.id.webView);

        w1.loadUrl(Special.s1);


    }
}
