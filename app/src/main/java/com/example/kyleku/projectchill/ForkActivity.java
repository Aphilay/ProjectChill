package com.example.kyleku.projectchill;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class ForkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fork);
    }
    //public void surveyButton(View v){
      //  startActivity(new Intent(ForkActivity.this,MarksSurvey));
    //}
    public void mainMenuButton(View v){
        startActivity(new Intent(ForkActivity.this,MainMenu.class));
    }
}
