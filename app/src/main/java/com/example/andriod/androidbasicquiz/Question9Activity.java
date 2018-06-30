package com.example.andriod.androidbasicquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class Question9Activity extends AppCompatActivity {

    /*Initialization of all global variable */

    int score1;
    int score2;
    int score3;
    int score4;
    int score5;
    int score6;
    int score7;
    int score8;
    int score9;
    int score9a;
    int score9b;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question9);

        /*getting intent extras from MainActivity.class and
        making declaration for the extras*/

        Intent answer = getIntent();
        score1 = answer.getIntExtra("score1", 0);
        score2 = answer.getIntExtra("score2", 0);
        score3 = answer.getIntExtra("score3", 0);
        score4 = answer.getIntExtra("score4", 0);
        score5 = answer.getIntExtra("score5", 0);
        score6 = answer.getIntExtra("score6", 0);
        score7 = answer.getIntExtra("score7", 0);
        score8 = answer.getIntExtra("score8", 0);
        name = answer.getStringExtra("personName");

        //log message for debugging
        Log.d("TestingInt1", "" + score1);
        Log.d("TestingInt2", "" + score2);
        Log.d("TestingInt3", "" + score3);
        Log.d("TestingInt4", "" + score4);
        Log.d("TestingInt5", "" + score5);
        Log.d("TestingInt6", "" + score6);
        Log.d("TestingInt7", "" + score7);
        Log.d("TestingInt8", "" + score8);
        Log.d("TestingIntN", "" + name);
    }

    //method to check and determine the radiobutton that was selected

    //execute this if checkbox 1 is clicked
    public void check(View view) {
        int score = 0;
        score9a = 0;
        CheckBox checkBox1 = findViewById(R.id.answer9_1);
        if (checkBox1.isChecked()) {
            score = 5;
            score9a = score;
            Log.d("Testing9a", "" + score9a);//log message for debugging
        } else {
            score9a = score;
        }
    }

    //execute this if radiobutton 2 is clicked
    public void check1(View view) {
        int score = 0;
        score9b = 0;
        CheckBox checkBox2 = findViewById(R.id.answer9_2);
        if (checkBox2.isChecked()) {
            score = 5;
            score9b = score;
            Log.d("Testing9b", "" + score9b);//log message for debugging
        } else {
            score9b = score;
        }
    }


    /*Intent method to move from question9activity to question8activity by pressing the previous button
    in the question9activity xml*/
    public void previousPage8(android.view.View view) {
        android.content.Intent question8Intent = new android.content.Intent(Question9Activity.this, Question8Activity.class);

        //returning back received intent
        question8Intent.putExtra("score1", score1);
        question8Intent.putExtra("score2", score2);
        question8Intent.putExtra("score3", score3);
        question8Intent.putExtra("score4", score4);
        question8Intent.putExtra("score5", score5);
        question8Intent.putExtra("score6", score6);
        question8Intent.putExtra("score7", score7);
        question8Intent.putExtra("personName", name);
        startActivity(question8Intent);//start the activity
        finish();//finishes this activity
    }

    /*Intent method to move from question9activity to question10activity by pressing the next button
    in the question9activity xml*/
    public void lunchPage10(android.view.View view) {
        CheckBox checkBox1 = findViewById(R.id.answer9_1);
        CheckBox checkBox2 = findViewById(R.id.answer9_2);
        CheckBox checkBox3 = findViewById(R.id.answer9_3);
        CheckBox checkBox4 = findViewById(R.id.answer9_4);
        if (checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked() || checkBox4.isChecked()) {
            score9 = score9a + score9b;
            Log.d("Testing9", "" + score9);//log message for debugging
            android.content.Intent question10Intent = new android.content.Intent(Question9Activity.this, Question10Activity.class);//adding extra details to the intent
            question10Intent.putExtra("score1", score1);
            question10Intent.putExtra("score2", score2);
            question10Intent.putExtra("score3", score3);
            question10Intent.putExtra("score4", score4);
            question10Intent.putExtra("score5", score5);
            question10Intent.putExtra("score6", score6);
            question10Intent.putExtra("score7", score7);
            question10Intent.putExtra("score8", score8);
            question10Intent.putExtra("score9", score9);
            question10Intent.putExtra("personName", name);
            startActivity(question10Intent);//start the activity
        } else {
            Toast.makeText(this, "Attempt the question first", Toast.LENGTH_SHORT).show();
        }
    }
}
