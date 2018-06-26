package com.example.kyleku.projectchill;



import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HighScoreActivity extends AppCompatActivity {

    TextView txtHighScore;
    Button btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        txtHighScore = (TextView)findViewById(R.id.txtHighScore);
        btnBack =(Button)findViewById(R.id.btnBack);

        SharedPreferences preferences = getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
        int highScore = preferences.getInt("high_score",0);

        txtHighScore.setText("High score: " + highScore);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HighScoreActivity.this, MainMenu.class);
                startActivity(intent);
            }
        });

    }
}
