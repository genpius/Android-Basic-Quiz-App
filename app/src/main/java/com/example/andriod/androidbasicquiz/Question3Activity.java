package com.example.andriod.androidbasicquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question3Activity extends AppCompatActivity {

    /*Initialization of all global variable */

    int score1;
    int score2;
    int score3;
    String name;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);

        /*getting intent extras from MainActivity.class and
        making declaration for the extras*/

        Intent answer = getIntent();
        score1 = answer.getIntExtra("score1", 0);
        score2 = answer.getIntExtra("score2", 0);
        name = answer.getStringExtra("personName");

        //log message for debugging
        Log.d("TestingInt1", "" + score1);
        Log.d("TestingInt2", "" + score2);
        Log.d("TestingIntN", "" + name);
    }

    //method to check and determine the radiobutton that was selected

    public void check(View view) {
        int score = 0;
        boolean radioButton = ((RadioButton) view).isChecked();//check if any of the radio button is checked
        switch (view.getId()) {
            case R.id.answer3_1://execute this if radiobutton 1 is clicked
                if (radioButton) {
                    score3 = score;
                    Log.d("Testing3a", "" + score3);//log message for debugging
                    break;
                }
            case R.id.answer3_2://execute this if radiobutton 2 is clicked
                if (radioButton) {
                    score3 = score;
                    Log.d("Testing3b", "" + score3);//log message for debugging
                    break;
                }
            case R.id.answer3_3://execute this if radiobutton 3 is clicked
                if (radioButton) {
                    score3 = score;
                    Log.d("Testing3c", "" + score3);//log message for debugging
                    break;
                }
            case R.id.answer3_4://execute this if radiobutton 4 is clicked
                if (radioButton) {
                    score = 10;
                    score3 = score;
                    Log.d("Testing3d", "" + score3);//log message for debugging
                    break;
                }
        }
    }

    /*Intent method to move from question3activity to question2activity by pressing the previous button
    in the question3activity xml*/
    public void previousPage2(View view) {
        Intent question2Intent = new Intent(Question3Activity.this, Question2Activity.class);

        //returning back received intent
        question2Intent.putExtra("score1", score1);
        question2Intent.putExtra("personName", name);
        startActivity(question2Intent);//start the activity
        finish();//finishes this activity
    }

    /*Intent method to move from question3activity to question4activity by pressing the next button
    in the question3activity xml*/
    public void lunchPage4(View view) {
        RadioGroup radioGroup = findViewById(R.id.question3_answer);
        if (radioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Attempt the question first", Toast.LENGTH_SHORT).show();
        } else {
            Intent question4Intent = new android.content.Intent(Question3Activity.this, Question4Activity.class);
            //adding extra details to the intent
            question4Intent.putExtra("score1", score1);
            question4Intent.putExtra("score2", score2);
            question4Intent.putExtra("score3", score3);
            question4Intent.putExtra("personName", name);
            startActivity(question4Intent);//start the activity
        }
    }
}
