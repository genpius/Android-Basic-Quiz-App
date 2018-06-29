package com.example.andriod.androidbasicquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

public class Question5Activity extends AppCompatActivity {

    /*Initialization of all global variable */

    int score1;
    int score2;
    int score3;
    int score4;
    int score5;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);

        /*getting intent extras from MainActivity.class and
        making declaration for the extras*/

        Intent answer = getIntent();
        score1 = answer.getIntExtra("score1", 0);
        score2 = answer.getIntExtra("score2", 0);
        score3 = answer.getIntExtra("score3", 0);
        score4 = answer.getIntExtra("score4", 0);
        name = answer.getStringExtra("personName");

        //log message for debugging
        Log.d("TestingInt1", "" + score1);
        Log.d("TestingInt2", "" + score2);
        Log.d("TestingInt3", "" + score3);
        Log.d("TestingInt4", "" + score4);
        Log.d("TestingIntN", "" + name);
    }

    //method to check and determine the radiobutton that was selected

    public void check(View view) {
        int score = 0;
        boolean radioButton = ((RadioButton) view).isChecked();//check if any of the radio button is checked
        switch (view.getId()) {
            case R.id.answer5_1://execute this if radiobutton 1 is clicked
                if (radioButton) {
                    score5 = score;
                    Log.d("Testing5a", "" + score5);//log message for debugging
                    break;
                }
            case R.id.answer5_2://execute this if radiobutton 2 is clicked
                if (radioButton) {
                    score5 = score;
                    Log.d("Testing5b", "" + score5);//log message for debugging
                    break;
                }
            case R.id.answer5_3://execute this if radiobutton 3 is clicked
                if (radioButton) {
                    score = 10;
                    score5 = score;
                    Log.d("Testing5c", "" + score5);//log message for debugging
                    break;
                }
            case R.id.answer5_4://execute this if radiobutton 4 is clicked
                if (radioButton) {
                    Log.d("Testing5d", "" + score5);//log message for debugging
                    break;
                }
        }
    }

    /*Intent method to move from question5activity to question4activity by pressing the previous button
    in the question5activity xml*/
    public void previousPage4(android.view.View view) {
        android.content.Intent question4Intent = new android.content.Intent(Question5Activity.this, Question4Activity.class);

        //returning back received intent
        question4Intent.putExtra("score1", score1);
        question4Intent.putExtra("score2", score2);
        question4Intent.putExtra("score3", score3);
        question4Intent.putExtra("personName", name);
        startActivity(question4Intent);//start the activity
        finish();//finishes this activity
    }

    /*Intent method to move from question5activity to question6activity by pressing the next button
    in the question5activity xml*/
    public void lunchPage6(android.view.View view) {
        android.content.Intent question6Intent = new android.content.Intent(Question5Activity.this, Question6Activity.class);

        //adding extra details to the intent
        question6Intent.putExtra("score1", score1);
        question6Intent.putExtra("score2", score2);
        question6Intent.putExtra("score3", score3);
        question6Intent.putExtra("score4", score4);
        question6Intent.putExtra("score5", score5);
        question6Intent.putExtra("personName", name);
        startActivity(question6Intent);//start the activity
    }
}
