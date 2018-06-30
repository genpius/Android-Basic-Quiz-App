package com.example.andriod.androidbasicquiz;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static android.util.Log.d;

public class GradeActivity extends AppCompatActivity {

    /*Initialization of all global variable */
    private int score1;
    private int score2;
    private int score3;
    private int score4;
    private int score5;
    private int score6;
    private int score7;
    private int score8;
    private int score9;
    private int score10;
    private int grade;
    private String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);
        @SuppressLint("all")
        /*getting intent extras from Question10Activity.class and
        making declaration for each extra*/

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
        score10 = answer.getIntExtra("score10", 0);
        name = answer.getStringExtra("personName");

        // log debugging statements

        d("TestingInt1", "" + score1);
        d("TestingInt2", "" + score2);
        d("TestingInt3", "" + score3);
        d("TestingInt4", "" + score4);
        d("TestingInt5", "" + score5);
        d("TestingInt6", "" + score6);
        d("TestingInt7", "" + score7);
        d("TestingInt8", "" + score8);
        d("TestingInt9", "" + score9);
        d("TestingInt10", "" + score10);
        d("TestingIntN", "" + name);

        grade = score1 + score2 + score3 + score4 + score5 +
                score6 + score7 + score8 + score9 + score10;//Calculation for the grade point

        // Display call functions for the various text fields

        //Display call function for the score column on the xml table
        display1("" + score1);
        display2("" + score2);
        display3("" + score3);
        display4("" + score4);
        display5("" + score5);
        display6("" + score6);
        display7("" + score7);
        display8("" + score8);
        display9("" + score9);
        display10("" + score10);
        displayT("" + grade);

        //Display call function for the remark column on the xml table

        display1R();
        display2R();
        display3R();
        display4R();
        display5R();
        display6R();
        display7R();
        display8R();
        display9R();
        display10R();
        displayTR();

        displayGA();//Display call function for the Grade Analysis
    }


    // display method for the grade analysis
    @SuppressLint("all")
    private void displayGA() {
        TextView gradeSummary = (TextView) findViewById(R.id.grade_analysis);
        gradeSummary.setText(String.format("%s%s", getString(R.string.grade_analysis_text), name));
    }

    // display method for the question 1 score
    @SuppressLint("all")
    private void display1(String i) {
        TextView textView1 = (TextView) findViewById(R.id.score1);
        textView1.setText(String.format("%s", i));
    }

    // display method for the question 1 remark
    @SuppressLint("all")
    private void display1R() {
        TextView textView1R = (TextView) findViewById(R.id.remark1);
        boolean remark1 = (score1 == 10);
        int i;
        if (remark1) {
            i = R.string.correct_answer;
            textView1R.setText(i);
            textView1R.setTextColor(Color.rgb(0,250,0));
        }else {
            i = R.string.wrong_answer;
            textView1R.setText(i);
            textView1R.setTextColor(Color.rgb(250,0,0));
        }
    }

    // display method for the question 2 score

    private void display2(String i) {
        TextView textView2 = (TextView)findViewById(R.id.score2);
        textView2.setText(String.format("%s", i));
    }

    // display method for the question 2 remark
    @SuppressLint("all")
    private void display2R() {
        TextView textView2R = TextView) findViewById(R.id.remark2);
        boolean remark2 = (score2 == 10);
        int i;
        if (remark2) {
            i = R.string.correct_answer;
            textView2R.setText(i);
            textView2R.setTextColor(Color.rgb(0,250,0));
        }else {
            i = R.string.wrong_answer;
            textView2R.setText(i);
            textView2R.setTextColor(Color.rgb(250,0,0));
        }
    }

    // display method for the question 3 score
    @SuppressLint("all")
    private void display3(String i) {
        TextView textView3 = (TextView) findViewById(R.id.score3);
        textView3.setText(String.format("%s", i));
    }

    // display method for the question 3 remark
    @SuppressLint("all")
    private void display3R() {
        TextView textView3R = (TextView) findViewById(R.id.remark3);
        boolean remark3 = (score3 == 10);
        int i;
        if (remark3) {
            i = R.string.correct_answer;
            textView3R.setText(i);
            textView3R.setTextColor(Color.rgb(0,250,0));
        }else {
            i = R.string.wrong_answer;
            textView3R.setText(i);
            textView3R.setTextColor(Color.rgb(250,0,0));
        }
    }

    // display method for the question 4 score
    @SuppressLint("all")
    private void display4(String i) {
        TextView textView4 = (TextView)findViewById(R.id.score4);
        textView4.setText(String.format("%s", i));
    }

    // display method for the question 4 remark
    @SuppressLint("all")
    private void display4R() {
        TextView textView4R = (TextView) findViewById(R.id.remark4);
        boolean remark4a = (score4 == 10);
        boolean remark4b = (score4 == 5);
        int i;
        if (remark4a) {
            i = R.string.correct_answer;
            textView4R.setText(i);
            textView4R.setTextColor(Color.rgb(0,250,0));
        }else if (remark4b) {
            i = R.string.partial_answer;
            textView4R.setText(i);
            textView4R.setTextColor(Color.rgb(0,0,250));
        }else {
            i = R.string.wrong_answer;
            textView4R.setText(i);
            textView4R.setTextColor(Color.rgb(250,0,0));
        }
    }

    // display method for the question 5 score
    @SuppressLint("all")
    private void display5(String i) {
        TextView textView5 = (TextView) findViewById(R.id.score5);
        textView5.setText(String.format("%s", i));
    }

    // display method for the question 5 remark
    @SuppressLint("all")
    private void display5R() {
        TextView textView5R = (TextView) findViewById(R.id.remark5);
        boolean remark5 = (score5 == 10);
        int i;
        if (remark5) {
            i = R.string.correct_answer;
            textView5R.setText(i);
            textView5R.setTextColor(Color.rgb(0,250,0));
        }else {
            i = R.string.wrong_answer;
            textView5R.setText(i);
            textView5R.setTextColor(Color.rgb(250,0,0));
        }
    }

    // display method for the question 6 score
    @SuppressLint("all")
    private void display6(String i) {
        TextView textView6 = (TextView) findViewById(R.id.score6);
        textView6.setText(String.format("%s", i));
    }

    // display method for the question 6 remark
    @SuppressLint("all")
    private void display6R() {
        TextView textView6R = (TextView) findViewById(R.id.remark6);
        boolean remark6 = (score6 == 10);
        int i;
        if (remark6) {
            i = R.string.correct_answer;
            textView6R.setText(i);
            textView6R.setTextColor(Color.rgb(0,250,0));
        }else {
            i = R.string.wrong_answer;
            textView6R.setText(i);
            textView6R.setTextColor(Color.rgb(250,0,0));
        }
    }

    // display method for the question 7 score
    @SuppressLint("all")
    private void display7(String i) {
        TextView textView7 = (TextView) findViewById(R.id.score7);
        textView7.setText(String.format("%s", i));
    }

    // display method for the question 7 remark
    @SuppressLint("all")
    private void display7R() {
        TextView textView7R = (TextView) findViewById(R.id.remark7);
        boolean remark7 = (score7 == 10);
        int i;
        if (remark7) {
            i = R.string.correct_answer;
            textView7R.setText(i);
            textView7R.setTextColor(Color.rgb(0,250,0));
        }else {
            i = R.string.wrong_answer;
            textView7R.setText(i);
            textView7R.setTextColor(Color.rgb(250,0,0));
        }
    }

    // display method for the question 8 score
    @SuppressLint("all")
    private void display8(String i) {
        TextView textView8 = (TextView) findViewById(R.id.score8);
        textView8.setText(String.format("%s", i));
    }

    // display method for the question 8 remark
    @SuppressLint("all")
    private void display8R() {
        TextView textView8R = (TextView) findViewById(R.id.remark8);
        boolean remark8 = (score8 == 10);
        int i;
        if (remark8) {
            i = R.string.correct_answer;
            textView8R.setText(i);
            textView8R.setTextColor(Color.rgb(0,250,0));
        }else {
            textView8R.setText(R.string.wrong_answer);
            textView8R.setTextColor(Color.rgb(250,0,0));
        }
    }

    // display method for the question 9 score
    @SuppressLint("all")
    private void display9(String i) {
        TextView textView9 = (TextView) findViewById(R.id.score9);
        textView9.setText(String.format("%s", i));
    }

    // display method for the question 9 remark
    @SuppressLint("all")
    private void display9R() {
        TextView textView9R = (TextView) findViewById(R.id.remark9);
        boolean remark9a = (score9 == 10);
        boolean remark9b = (score9 == 5);
        int i;
        if (remark9a) {
            i = R.string.correct_answer;
            textView9R.setText(i);
            textView9R.setTextColor(Color.rgb(0,250,0));
        }else if (remark9b) {
            i = R.string.partial_answer;
            textView9R.setText(i);
            textView9R.setTextColor(Color.rgb(0,0,250));
        }else {
            i = R.string.wrong_answer;
            textView9R.setText(i);
            textView9R.setTextColor(Color.rgb(250,0,0));
        }
    }

    // display method for the question 10 score
    @SuppressLint("all")
    private void display10(String i) {
        TextView textView10 = (TextView) findViewById(R.id.score10);
        textView10.setText(String.format("%s", i));
    }

    // display method for the question 10 remark
    @SuppressLint("all")
    private void display10R() {
        TextView textView10R = (TextView) findViewById(R.id.remark10);
        boolean remark1 = (score10 == 10);
        int i;
        if (remark1) {
            i = R.string.correct_answer;
            textView10R.setText(i);
            textView10R.setTextColor(Color.rgb(0,250,0));
        }else {
            i = R.string.wrong_answer;
            textView10R.setText(i);
            textView10R.setTextColor(Color.rgb(250,0,0));
        }
    }

    // display method for the total score
    @SuppressLint("all")
    private void displayT(String i) {
        TextView textViewT = (TextView) findViewById(R.id.total_score);
        textViewT.setText(String.format("%s", i));
    }

    // display method for the total remark

    @SuppressLint("all")
    private void displayTR() {
        TextView textViewTR = TextView) findViewById(R.id.total_remark);
        boolean remarkTa = (grade >= 80);
        boolean remarkTb = ((grade >= 60 ) && (grade < 80));
        boolean remarkTc = ((grade >= 45) && (grade < 60));
        int i;
        if (remarkTa) {
            i = R.string.excellent;
            textViewTR.setText(i);
            textViewTR.setTextColor(Color.rgb(0,250,0));
            Toast.makeText(this, "" + name + ", you scored " + grade + "%."
                    + " Excellent", Toast.LENGTH_SHORT).show();//toast message for grade level of >= 80
        }else if (remarkTb) {
            i = R.string.very_good;
            textViewTR.setText(i);
            textViewTR.setTextColor(Color.rgb(0,0,250));
            Toast.makeText(this, "" + name + ", you scored " + grade + "%."
                    + " Very Good", Toast.LENGTH_SHORT).show();//toast message for grade level of >= 60 t0 < 80
        }else if (remarkTc) {
            i = R.string.good;
            textViewTR.setText(i);
            textViewTR.setTextColor(Color.rgb(200,0,200));
            Toast.makeText(this, "" + name + ", you scored " + grade + "%."
                    + " Good", Toast.LENGTH_SHORT).show();//toast message for grade level of >= 45 t0 < 60
        }else {
            i = R.string.failed;
            textViewTR.setText(i);
            textViewTR.setTextColor(Color.rgb(250,0,0));
            Toast.makeText(this, "" + name + ", you scored " + grade + "%."
                    + " Try Again", Toast.LENGTH_SHORT).show();//toast message for grade level of 0 t0 < 45
        }
    }

    //Intent to move from this activity to the answer activity
    public void answerPage(@SuppressWarnings("unused") View view) {
        Intent answer = new Intent(this, AnswersActivity.class);
        startActivity(answer);//start the activity
    }
}
