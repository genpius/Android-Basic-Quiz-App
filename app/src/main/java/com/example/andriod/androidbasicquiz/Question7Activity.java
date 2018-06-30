package com.example.andriod.androidbasicquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

public class Question7Activity extends AppCompatActivity {

    /*Initialization of all global variable */

    int score1;
    int score2;
    int score3;
    int score4;
    int score5;
    int score6;
    int score7;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question7);

        /*getting intent extras from MainActivity.class and
        making declaration for the extras*/

        Intent answer = getIntent();
        score1 = answer.getIntExtra("score1", 0);
        score2 = answer.getIntExtra("score2", 0);
        score3 = answer.getIntExtra("score3", 0);
        score4 = answer.getIntExtra("score4", 0);
        score5 = answer.getIntExtra("score5", 0);
        score6 = answer.getIntExtra("score6", 0);
        name = answer.getStringExtra("personName");

        //log message for debugging
        Log.d("TestingInt1", "" + score1);
        Log.d("TestingInt2", "" + score2);
        Log.d("TestingInt3", "" + score3);
        Log.d("TestingInt4", "" + score4);
        Log.d("TestingInt5", "" + score5);
        Log.d("TestingInt6", "" + score6);
        Log.d("TestingIntN", "" + name);
    }

    /*Intent method to move from question7activity to question6activity by pressing the previous button
    in the question7activity xml*/
    public void previousPage6(android.view.View view) {
        android.content.Intent question6Intent = new android.content.Intent(Question7Activity.this, Question6Activity.class);

        //returning back received intent
        question6Intent.putExtra("score1", score1);
        question6Intent.putExtra("score2", score2);
        question6Intent.putExtra("score3", score3);
        question6Intent.putExtra("score4", score4);
        question6Intent.putExtra("score5", score5);
        question6Intent.putExtra("personName", name);
        startActivity(question6Intent);//start the activity
        finish();//finishes this activity
    }

    /*Intent method to move from question7activity to question8activity by pressing the next button
    in the question7activity xml*/
    public void lunchPage8(android.view.View view) {
        int score = 0;
        EditText editText = (EditText) findViewById(R.id.edit_text);//finding the editable view on the activity
        String inputText = editText.getText().toString();//extracting the user input on the view
        if (inputText.matches("")) {
            Toast.makeText(this, "Attempt the question first", Toast.LENGTH_SHORT).show();
        } else {
            String answerText = getString(R.string.answer7);//right answer for the question
            boolean edit = inputText.equals(answerText);//returns true or false
            if (edit) {
                score = 10;
                score7 = score;
                Log.d("Testing7a", "" + score7);//log message for debugging
            } else {
                score7 = score;
                Log.d("Testing7b", "" + score7);//log message for debugging
            }

            android.content.Intent question8Intent = new android.content.Intent(Question7Activity.this, Question8Activity.class);
            //adding extra details to the intent
            question8Intent.putExtra("score1", score1);
            question8Intent.putExtra("score2", score2);
            question8Intent.putExtra("score3", score3);
            question8Intent.putExtra("score4", score4);
            question8Intent.putExtra("score5", score5);
            question8Intent.putExtra("score6", score6);
            question8Intent.putExtra("score7", score7);
            question8Intent.putExtra("personName", name);
            startActivity(question8Intent);//start the activity
        }
    }
}
