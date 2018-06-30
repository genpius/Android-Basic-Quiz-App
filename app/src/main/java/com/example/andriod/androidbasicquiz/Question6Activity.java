package com.example.andriod.androidbasicquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question6Activity extends AppCompatActivity {

    /*Initialization of all global variable */

    int score1;
    int score2;
    int score3;
    int score4;
    int score5;
    int score6;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question6);

        /*getting intent extras from MainActivity.class and
        making declaration for the extras*/

        Intent answer = getIntent();
        score1 = answer.getIntExtra("score1", 0);
        score2 = answer.getIntExtra("score2", 0);
        score3 = answer.getIntExtra("score3", 0);
        score4 = answer.getIntExtra("score4", 0);
        score5 = answer.getIntExtra("score5", 0);
        name = answer.getStringExtra("personName");

        //log message for debugging
        Log.d("TestingInt1", "" + score1);
        Log.d("TestingInt2", "" + score2);
        Log.d("TestingInt3", "" + score3);
        Log.d("TestingInt4", "" + score4);
        Log.d("TestingInt5", "" + score5);
        Log.d("TestingIntN", "" + name);
    }

    //method to check and determine the radiobutton that was selected

    public void check(View view) {
        int score = 0;
        boolean radioButton = ((RadioButton) view).isChecked();//check if any of the radio button is checked
        switch (view.getId()) {
            case R.id.answer6_1://execute this if radiobutton 1 is clicked
                if (radioButton) {
                    score = 10;
                    score6 = score;
                    Log.d("Testing6a", "" + score6);//log message for debugging
                    break;
                }
            case R.id.answer6_2://execute this if radiobutton 2 is clicked
                if (radioButton) {
                    score6 = score;
                    Log.d("Testing6b", "" + score6);//log message for debugging
                    break;
                }
        }
    }

    /*Intent method to move from question6activity to question5activity by pressing the previous button
    in the question6activity xml*/
    public void previousPage5(android.view.View view) {
        android.content.Intent question5Intent = new android.content.Intent(Question6Activity.this, Question5Activity.class);

        //returning back received intent
        question5Intent.putExtra("score1", score1);
        question5Intent.putExtra("score2", score2);
        question5Intent.putExtra("score3", score3);
        question5Intent.putExtra("score4", score4);
        question5Intent.putExtra("personName", name);
        startActivity(question5Intent);//start the activity
        finish();//finishes this activity
    }

    /*Intent method to move from question6activity to question7activity by pressing the next button
    in the question6activity xml*/
    public void lunchPage7(android.view.View view) {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.question6_answer);//find the radiogroup
        //check if any of the checkbox have been engaged before progressing
        if (radioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Attempt the question first", Toast.LENGTH_SHORT).show();
        } else {
            android.content.Intent question7Intent = new android.content.Intent(Question6Activity.this, Question7Activity.class);
            //adding extra details to the intent
            question7Intent.putExtra("score1", score1);
            question7Intent.putExtra("score2", score2);
            question7Intent.putExtra("score3", score3);
            question7Intent.putExtra("score4", score4);
            question7Intent.putExtra("score5", score5);
            question7Intent.putExtra("score6", score6);
            question7Intent.putExtra("personName", name);
            startActivity(question7Intent);//start the activity
        }
    }
}
