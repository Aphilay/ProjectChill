package com.example.kyleku.projectchill;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.os.Handler;
import android.view.View;


public class Question3 extends Activity {
    SeekBar seekBar;
    int defaultvalue = 0;
    TextView textView;
    int Response;
    int RevResponse;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout4);

        Intent intent = getIntent();
        Response = intent.getIntExtra("Q2",defaultvalue);

        seekBar = (SeekBar) findViewById(R.id.simpleSeekBar3);
        textView = findViewById(R.id.test3);

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

        final Button NextButton = findViewById(R.id.Next3);
        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Execute what code does here
                RevResponse = ReverseResponse(seekBar.getProgress());
                openQuestion4();
            }
        });

        final Button BackButton = findViewById(R.id.Back3);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Execute what code does here
                openQuestion2();
            }
        });



    }

    public void openQuestion4()
    {
        Intent openQuestion4 = new Intent(this,Question4.class);
        openQuestion4.putExtra("Q3",Response + RevResponse);
        setResult(RESULT_OK,openQuestion4);
        finish();
        startActivityForResult(openQuestion4,4);
    }

    public void openQuestion2()
    {
        Intent intent = new Intent(this,Question2.class);
        startActivity(intent);
    }
    public int getResponse(){
        return Response;
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







