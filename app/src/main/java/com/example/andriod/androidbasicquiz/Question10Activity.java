package com.example.andriod.androidbasicquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

public class Question10Activity extends AppCompatActivity {

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
    int score10;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question10);

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
        score9 = answer.getIntExtra("score9", 0);
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
        Log.d("TestingInt9", "" + score9);
        Log.d("TestingIntN", "" + name);
    }

    /*Intent method to move from question10activity to question9activity by pressing the previous button
    in the question10activity xml*/
    public void previousPage9(android.view.View view) {
        android.content.Intent question9Intent = new android.content.Intent(Question10Activity.this, Question9Activity.class);

        //returning back received intent
        question9Intent.putExtra("score1", score1);
        question9Intent.putExtra("score2", score2);
        question9Intent.putExtra("score3", score3);
        question9Intent.putExtra("score4", score4);
        question9Intent.putExtra("score5", score5);
        question9Intent.putExtra("score6", score6);
        question9Intent.putExtra("score7", score7);
        question9Intent.putExtra("score8", score8);
        question9Intent.putExtra("personName", name);
        startActivity(question9Intent);//start the activity
        finish();//finishes this activity
    }

    /*Intent method to move from question10activity to gradeactivity by pressing the next button
    in the question10activity xml*/
    public void submit(android.view.View view) {
        int score = 0;
        EditText editText = findViewById(R.id.edit_text1);//finding the editable view on the activity
        String inputText = editText.getText().toString();//extracting the user input on the view
        String answerText = getString(R.string.answer10);//right answer for the question
        boolean edit = inputText.equals(answerText);//returns true or false
        if (edit) {
            score = 10;
            score10 = score;
            Log.d("Testing10a", "" + score10);//log message for debugging
        } else {
            score10 = score;
            Log.d("Testing10b", "" + score10);//log message for debugging
        }

        android.content.Intent submitIntent = new android.content.Intent(Question10Activity.this, GradeActivity.class);

        //adding extra details to the intent
        submitIntent.putExtra("score1", score1);
        submitIntent.putExtra("score2", score2);
        submitIntent.putExtra("score3", score3);
        submitIntent.putExtra("score4", score4);
        submitIntent.putExtra("score5", score5);
        submitIntent.putExtra("score6", score6);
        submitIntent.putExtra("score7", score7);
        submitIntent.putExtra("score8", score8);
        submitIntent.putExtra("score9", score9);
        submitIntent.putExtra("score10", score10);
        submitIntent.putExtra("personName", name);
        startActivity(submitIntent);//start the activity
    }
}
