package com.example.kyleku.projectchill;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.os.Handler;
import android.view.View;


public class Score extends Activity {

    int result;
    TextView display;
    TextView display2;
    int defaultvalue = 0;

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout7);

        Intent intent = getIntent();
        int result = intent.getIntExtra("Q4",defaultvalue);


        display = findViewById(R.id.score7);
        display2 = findViewById(R.id.Ranking);

        display.setTextSize(22);
        display2.setTextSize(22);



        display.setText("Your Score:" + result + "/20");

        if(result ==20)
        {
            display2.setText("Your stress Ranking: " + "Dude go seek therapy");
        }
        else if(result < 20 && result >= 16)
        {
            display2.setText("Your stress Ranking: " + "Highly Stressed");
        }
        else if(result <= 15 && result >= 10)
        {
            display2.setText("Your stress Ranking: " + "Stressed ");
        }
        else  if(result <=9 && result >= 5)
        {
            display2.setText("Your stress Ranking: " + "Midly Stessed ");
        }
        else if(result <= 4 && result >= 1)
        {
            display2.setText("Your stress Ranking: " + "slightly ");
        }
        else
        {
            display2.setText("Your stress Ranking: " + "Bro whats your secret");
        }





        //connect this to chill main menu
        final Button NextButton = findViewById(R.id.Chillmenu);
        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Execute what code does here
                openChillMenu();

            }
        });

        final Button BackButton = findViewById(R.id.Retake);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Execute what code does here
                openRetake();
            }
        });



    }

    //Connect this to chill main menu
    public void openChillMenu()
    {

        Intent openMainMenu = new Intent(this,MainMenu.class);
        startActivity(openMainMenu);
    }

    public void openRetake()
    {
        Intent intent = new Intent(this,Disclaimer.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 4 && resultCode == RESULT_OK){
            int answerrecieved = data.getIntExtra("Q4",defaultvalue);
            result = answerrecieved;
            String message = data.getStringExtra("BigFoot");
            display.setText(message);
            //display.setText("Your Score:" + result + "/20");

        }
        else{
            display.setText("Failed");
        }

    }
}







