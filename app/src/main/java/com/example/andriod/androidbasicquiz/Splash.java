package com.example.andriod.androidbasicquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Splash extends AppCompatActivity {
    private RelativeLayout sR;
    private LinearLayout sL;
    TextView lText;
    Animation lTextAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //finding the various required views
        sR = (RelativeLayout)findViewById(R.id.SLU_text);
        sL = (LinearLayout)findViewById(R.id.power_text);
        lText = (TextView) findViewById(R.id.l_text);
        Animation sluAnim = AnimationUtils.loadAnimation(this, R.anim.mytransform);//loading mytransform anim xml
        //excuting the animation effect
        sR.startAnimation(sluAnim);
        sL.startAnimation(sluAnim);
        rotatelTextAnim();//starting animation on the L text view
        final Intent main = new Intent(this, MainActivity.class);
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(main);//starting the main activity
                    finish();//destroy the splash page
                }
            }

        };
        timer.start();//timer count begins
    }

    //method to implement the animation on the L text
    private void rotatelTextAnim() {
        lTextAnim = AnimationUtils.loadAnimation(this, R.anim.rotate);//loading animation from the resources xml
        lText.startAnimation(lTextAnim);//setting animation on the text view
    }
}
