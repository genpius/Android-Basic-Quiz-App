package com.example.andriod.androidbasicquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class Splash extends AppCompatActivity {
    private RelativeLayout sR;
    private LinearLayout sL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sR = (RelativeLayout)findViewById(R.id.SLU_text);
        sL = (LinearLayout)findViewById(R.id.power_text);
        Animation sluAnim = AnimationUtils.loadAnimation(this, R.anim.mytransform);
        sR.startAnimation(sluAnim);
        sL.startAnimation(sluAnim);
        final Intent main = new Intent(this, MainActivity.class);
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(main);
                    finish();
                }
            }

        };
        timer.start();
    }
}
