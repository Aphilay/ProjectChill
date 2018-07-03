package com.example.kyleku.projectchill;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.view.View;


public class Question1 extends Activity {
    SeekBar seekBar;
    int Response;
    TextView textView;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);


        seekBar =  findViewById(R.id.simpleSeekBar1);
        textView = findViewById(R.id.test);
        seekBar.setMax(5);
        seekBar.setProgress(0);
        Response = seekBar.getProgress();

        textView.setText("Use slide bar to answer the above queston");
        textView.setTextSize(17);




        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });



        final Button NextButton = findViewById(R.id.Next1);
        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Execute what code does here

                Response = seekBar.getProgress();
                openQuestion2();
            }

        });


        final Button BackButton = findViewById(R.id.Back);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Execute what code does here
                openDisclaimer();
            }
        });



    }


    public void openQuestion2()
    {
        Intent openQuestion2 = new Intent(this,Question2.class);
        openQuestion2.putExtra("Q1",Response);
        setResult(RESULT_OK,openQuestion2);
        finish();
        startActivityForResult(openQuestion2,2);
    }

    public void openDisclaimer()
    {
        Intent intent = new Intent(this,Disclaimer.class);
        startActivity(intent);
    }


    public int getResponse(){
        return Response;
    }

    public void setResponse(int x){
        Response = x;
    }
}







