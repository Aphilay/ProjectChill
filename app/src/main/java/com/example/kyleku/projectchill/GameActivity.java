package com.example.kyleku.projectchill;



import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {


    SharedPreferences preferences;
    int oldScore = 0;
    TextView txtSc;
    ImageView imageSpinner;

    GestureDetectorCompat gestureDetectorCompat;
    boolean isSpinning = false;
    RotateAnimation rotate;

    int yourScore  = 0;
    ProgressBar progressBar;
    int progressStatus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        preferences = getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
        oldScore = preferences.getInt("high_score",0);

        txtSc = (TextView)findViewById(R.id.txtHighScore);
       // txtSc.setText("High Score: " + oldScore);

        imageSpinner = (ImageView)findViewById(R.id.imageSpinner);

        gestureDetectorCompat = new GestureDetectorCompat(this, new MyGestureListener());


    }
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        this.gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener{

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2, float x, float y)
        {
            if(!isSpinning)
            {
                int fromDegrees = 0;
                int toDegrees = getToDegrees(event1.getX(), event1.getY(),event2.getX(),event2.getY(),event1.getEventTime(),event2.getEventTime());
                int duration = 10000; // spin duration 20s
                yourScore = (int)Math.floor(toDegrees/360);


                rotate = new RotateAnimation(fromDegrees, toDegrees, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotate.setDuration(duration);
                rotate.setInterpolator(new LinearInterpolator());

                rotate.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        final Dialog dialog = new Dialog(GameActivity.this);
                        dialog.setContentView(R.layout.layout_game_end);




                        Button btnReplay = (Button) dialog.findViewById(R.id.btnReplay);
                        Button btnBack = (Button) dialog.findViewById(R.id.btnBack);

                        btnReplay.setOnClickListener(new View.OnClickListener(){

                            @Override
                            public void onClick(View v)
                            {
                                //Reset
                                isSpinning = false;
                                progressStatus = 0;
                                yourScore = 0;
                                progressBar.setProgress(0);
                                dialog.dismiss();

                            }

                        });


                        btnBack.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent =  new Intent(GameActivity.this, MainMenu.class);
                                startActivity(intent);
                            }
                        });
                        dialog.show();

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                //start spin
                imageSpinner.startAnimation(rotate);



                isSpinning = true;
                return true;

            }
            else
            {
                return false;
            }
        }

        private int getToDegrees(float x1, float y1, float x2, float y2, long eventTime1, long evenTime2)
        {
            double distance = Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
            int toDegrees = (int)Math.ceil(distance*(evenTime2-eventTime1));

            return toDegrees;
        }

    }
}
