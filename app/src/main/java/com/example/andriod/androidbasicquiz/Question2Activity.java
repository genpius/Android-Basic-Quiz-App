package com.example.andriod.androidbasicquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question2Activity extends AppCompatActivity {

    /*Initialization of all global variable */

    int score1;
    int score2;
    String name;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        /*getting intent extras from MainActivity.class and
        making declaration for the extras*/

        Intent answer = getIntent();
        score1 = answer.getIntExtra("score1", 0);
        name = answer.getStringExtra("personName");

        //log message for debugging
        Log.d("TestingInt1", ""+score1);
        Log.d("TestingIntN", ""+name);

    }

    //method to check and determine the radiobutton that was selected

    public void check(View view){
        int score = 0;
        boolean radioButton = ((RadioButton) view).isChecked();//check if any of the radio button is checked
        switch (view.getId()){
            case R.id.answer2_1://execute this if radiobutton 1 is clicked
                if(radioButton){
                    score2 = score;
                    Log.d("Testing2a", ""+score2);//log message for debugging
                    break;
                }
            case R.id.answer2_2://execute this if radiobutton 2 is clicked
                if(radioButton){
                    score2 = score;
                    Log.d("Testing2b", ""+score2);//log message for debugging
                    break;
                }
            case R.id.answer2_3://execute this if radiobutton 3 is clicked
                if(radioButton){
                    score2 = score + 10;
                    Log.d("Testing2c", ""+score2);//log message for debugging
                    break;
                }
            case R.id.answer2_4://execute this if radiobutton 3 is clicked
                if(radioButton){
                    score2 = score;
                    Log.d("Testing2d", ""+score2);//log message for debugging
                    break;
                }
        }
    }

    /*Intent method to move from question2activity to question1activity by pressing the previous button
    in the question2activity xml*/
    public void previousPage1(View view) {
        Intent question1Intent = new Intent(Question2Activity.this, Question1Activity.class);
        question1Intent.putExtra("personName", name);//returning back received intent
        startActivity(question1Intent);//start the activity
        finish();//finishes this activity
    }

    /*Intent method to move from question2activity to question3activity by pressing the next button
    in the question2activity xml*/
    public void lunchPage3(View view) {
        RadioGroup radioGroup = findViewById(R.id.question2_answer);
        if (radioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Attempt the question first", Toast.LENGTH_SHORT).show();
        } else {
            Intent question2Intent = new Intent(Question2Activity.this, Question3Activity.class);
            //adding extra details to the intent
            question2Intent.putExtra("score1", score1);
            question2Intent.putExtra("score2", score2);
            question2Intent.putExtra("personName", name);
            startActivity(question2Intent);//start the activity
        }
    }

}



