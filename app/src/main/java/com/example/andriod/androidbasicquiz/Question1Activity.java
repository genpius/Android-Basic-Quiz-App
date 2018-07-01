package com.example.andriod.androidbasicquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question1Activity extends AppCompatActivity {

    /*Initialization of all global variable */

    int score1;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        /*getting intent extras from MainActivity.class and
        making declaration for the extra*/

        Intent mName = getIntent();
        name = mName.getStringExtra("personName");

        //log message for debugging
        Log.d("TestingIntN", ""+name);
    }

    //method to check and determine the radiobutton that was selected

    public void check(View view){
        int score = 0;
        boolean radioButton = ((RadioButton) view).isChecked();//check if any of the radio button is checked

        //using the switch and case method to determine
        switch (view.getId()){
            case R.id.answer1_1://execute this if radiobutton 1 is clicked
                if(radioButton){
                    score1 = score + 10;
                    Log.d("Testing1", ""+score1);//log message for debugging
                    break;
                }
            case R.id.answer1_2://execute this if radiobutton 2 is clicked
                if(radioButton){
                    score1 = score;
                    Log.d("Testing2", ""+score1);//log message for debugging
                    break;
                }
            case R.id.answer1_3://execute this if radiobutton 3 is clicked
                if(radioButton){
                    score1 = score;
                    Log.d("Testing3", ""+score1);//log message for debugging
                    break;
                }
            case  R.id.answer1_4://execute this if radiobutton 4 is clicked
                if(radioButton){
                    score1 = score;
                    Log.d("Testing4", ""+score1);//log message for debugging
                    break;
                }
        }
    }

    /*Intent method to move from question1activity to question2activity by pressing the next button
    in the question1activity xml*/

    public void lunchPage2(View view) {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.question1_answer);

        if (radioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Attempt the question first", Toast.LENGTH_SHORT).show();
        } else {
            Intent question2Intent = new Intent(Question1Activity.this, Question2Activity.class);
            //adding extra details to the intent
            question2Intent.putExtra("score1", score1);
            question2Intent.putExtra("personName", name);
            startActivity(question2Intent);//start the question2activity
        }
    }
}
