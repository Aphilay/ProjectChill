package com.example.kyleku.projectchill;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.os.Handler;
import android.view.View;


public class Question4 extends Activity {
    SeekBar seekBar;
    int Response;
    TextView textView;
    int defaultvalue = 0;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout5);

        Intent intent = getIntent();
        Response = intent.getIntExtra("Q3",defaultvalue);

        seekBar = (SeekBar) findViewById(R.id.simpleSeekBar4);
        textView = findViewById(R.id.test4);
        seekBar.setMax(5);
        seekBar.setProgress(0);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });

        final Button NextButton = findViewById(R.id.scorepage);
        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Execute what code does here
                //sendData();
                openScore();
            }
        });

        final Button BackButton = findViewById(R.id.Back4);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Execute what code does here
                openQuestion3();
            }
        });

    }

    public void openScore()
    {
        Intent openScore = new Intent(this,Score.class);
        openScore.putExtra("Q4",Response + seekBar.getProgress());
        setResult(RESULT_OK,openScore);
        finish();
        startActivity(openScore);
    }

    public void openQuestion3() {
        Intent intent = new Intent(this, Question3.class);
        startActivity(intent);
    }

    public void sendData()
    {
        Intent i = new Intent();
        int Answer = Response;




    }

    public int getResponse(){
        return Response;
    }
}







