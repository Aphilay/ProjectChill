package com.example.kyleku.projectchill;

import android.os.Handler;
import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;

public class WelcomeActivity extends Activity{
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run(){
                Intent homeIntent = new Intent( WelcomeActivity.this, ForkActivity.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}

