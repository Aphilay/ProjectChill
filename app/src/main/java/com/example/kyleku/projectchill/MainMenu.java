package com.example.kyleku.projectchill;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainMenu extends AppCompatActivity {

    private Button button_fs;
    private Button button_mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the view from activity_main.xml
        setContentView(R.layout.activity_main_menu);

        // Locate the button in activity_main.xml
        button_fs = (Button) findViewById(R.id.fs_button);

        // Capture button clicks
        button_fs.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start Blank.class
                Intent myIntent = new Intent(MainMenu.this,
                        GameActivity.class);
                startActivity(myIntent);
            }
        });

        // Locate the button in activity_main.xml
        button_mp = (Button) findViewById(R.id.mp_button);

        // Capture button clicks
        button_mp.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start Blank.class
                Intent myIntent = new Intent(MainMenu.this,
                        MainMusicActivity.class);
                startActivity(myIntent);
            }
        });
        //test

    }

}
