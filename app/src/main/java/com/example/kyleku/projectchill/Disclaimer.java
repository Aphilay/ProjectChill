package com.example.kyleku.projectchill;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.os.Handler;
import android.view.View;


public class Disclaimer extends Activity {


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout3);


        final Button StartSurveyButton = findViewById(R.id.Take_Survey);
        StartSurveyButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Execute what code does here
                openQuestion1();
            }

        });

    }
    public void openQuestion1()
    {
        Intent intent = new Intent(this,Question1.class);
        startActivityForResult(intent,1);
    }
}







