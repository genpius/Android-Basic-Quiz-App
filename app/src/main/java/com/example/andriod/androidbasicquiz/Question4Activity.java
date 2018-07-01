package com.example.andriod.androidbasicquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class Question4Activity extends AppCompatActivity {

    /*Initialization of all global variable */

    int score1;
    int score2;
    int score3;
    int score4;
    int score4a;
    int score4b;
    String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);

        /*getting intent extras from MainActivity.class and
        making declaration for the extras*/

        Intent answer = getIntent();
        score1 = answer.getIntExtra("score1", 0);
        score2 = answer.getIntExtra("score2", 0);
        score3 = answer.getIntExtra("score3", 0);
        name = answer.getStringExtra("personName");

        //log message for debugging
        Log.d("TestingInt1", "" + score1);
        Log.d("TestingInt2", "" + score2);
        Log.d("TestingInt3", "" + score3);
        Log.d("TestingIntN", "" + name);
    }

    //method to check and determine the checkbox that was selected

    //execute this if checkbox 2 is clicked
    public void check(View view) {
        int score = 0;
        score4a = 0;
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.answer4_2);
        if (checkBox2.isChecked()) {
            score = 5;
            score4a = score;
            Log.d("Testing4a", "" + score4a);//log message for debugging
        }else {
            score4a = score;
        }
    }

    //execute this if checkbox 4 is clicked
    public void check1(View view){
        int score = 0;
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.answer4_4);
        if (checkBox4.isChecked()) {
            score = 5;
            score4b = score;
            Log.d("Testing4b", "" + score4b);//log message for debugging
        } else {
            score4b = score;
        }
    }

    /*Intent method to move from question4activity to question3activity by pressing the previous button
    in the question4activity xml*/
    public void previousPage3(android.view.View view) {
        android.content.Intent question3Intent = new android.content.Intent(Question4Activity.this, Question3Activity.class);

        //returning back received intent
        question3Intent.putExtra("score1", score1);
        question3Intent.putExtra("score2", score2);
        question3Intent.putExtra("personName", name);
        startActivity(question3Intent);//start the activity
        finish();//finishes this activity
    }

    /*Intent method to move from question4activity to question5activity by pressing the next button
    in the question4activity xml*/
    public void lunchPage5(android.view.View view) {
        //find all CheckBox
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.answer4_1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.answer4_2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.answer4_3);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.answer4_4);
        //check if any one has been engaged
        if (checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked() || checkBox4.isChecked()) {
            score4 = score4a + score4b;
            Log.d("Testing4", "" + score4);//log message for debugging
            android.content.Intent question5Intent = new android.content.Intent(Question4Activity.this, Question5Activity.class);
            //adding extra details to the intent
            question5Intent.putExtra("score1", score1);
            question5Intent.putExtra("score2", score2);
            question5Intent.putExtra("score3", score3);
            question5Intent.putExtra("score4", score4);
            question5Intent.putExtra("personName", name);
            startActivity(question5Intent);//start the activity
        } else {
            Toast.makeText(this, "Attempt the question first", Toast.LENGTH_SHORT).show();
        }
    }
}
