package com.example.kyleku.projectchill;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.os.Handler;
import android.view.View;


public class Question2 extends Activity {
    SeekBar seekBar;
    int Response;
    int RevResponse;
    TextView textView;
    int defaultvalue = 0;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);

        Intent intent = getIntent();
        Response = intent.getIntExtra("Q1",defaultvalue);


        seekBar = (SeekBar) findViewById(R.id.simpleSeekBar2);
        textView = findViewById(R.id.test2);

        seekBar.setMax(5);
        seekBar.setProgress(0);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        final Button NextButton = findViewById(R.id.Next2);
        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Execute what code does here
                RevResponse = ReverseResponse(seekBar.getProgress());
                openQuestion3();
            }
        });

        final Button BackButton = findViewById(R.id.Back2);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Execute what code does here
                openQuestion1();
            }
        });



    }

    public void openQuestion3()
    {
        Intent openQuestion3 = new Intent(this,Question3.class);
        openQuestion3.putExtra("Q2",Response + RevResponse);
        setResult(RESULT_OK,openQuestion3);
        finish();
        startActivityForResult(openQuestion3,3);
    }

    public void openQuestion1()
    {
        Intent intent = new Intent(this,Question1.class);
        startActivity(intent);
    }

    public int getResponse()
    {
        return Response;
    }

    public void setResponse(int x){
        Response = x;
    }

    public int ReverseResponse(int Response)
    {
        if(Response == 0){
            Response = 5;
        }
        else if(Response == 1){
            Response = 4;
        }
        else if(Response == 2){
            Response = 3;
        }
        else if(Response == 3){
            Response = 2;
        }
        else if (Response == 4){
            Response = 1;
        }
        else if (Response == 5){
            Response = 0;
        }
        return Response;
    }

}







