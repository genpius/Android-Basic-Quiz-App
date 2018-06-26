package com.example.andriod.androidbasicquiz;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*Initialization of all global variable */

    Dialog myDialog;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDialog = new Dialog(this);
    }

    // method for the begin button to create a pop up

    public void popUp(View view) {
        TextView slu;
        Button start;
        myDialog.setContentView(R.layout.pop_up);
        slu = myDialog.findViewById(R.id.pop_close);
        start = myDialog.findViewById(R.id.start);
        slu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });//setting onclicklistner on the X button on the pop up
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//making the remaining layout transparent
        myDialog.show();



    }

    //Intent to move from this activity to the question 1 activity as the start button on pop is clicked

    public void lunchPage1(View view) {
        EditText personName = myDialog.findViewById(R.id.name);//finding the editable view on the pop up
        name = personName.getText().toString();//extracting the user input on the view
        Log.d("Testing", ""+ name);//log message for debugging
        Toast.makeText(this, "All the Best", Toast.LENGTH_SHORT).show();//toast message as button is clicked
        Intent question1intent = new Intent(MainActivity.this, Question1Activity.class);
        question1intent.putExtra("personName", name);//adding extra details to the intent
        startActivity(question1intent);//start the question1activity
    }


}
