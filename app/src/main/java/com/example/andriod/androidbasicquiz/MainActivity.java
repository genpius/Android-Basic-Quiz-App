package com.example.andriod.androidbasicquiz;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*Initialization of all global variable */

    Dialog myDialog;
    String name;
    Animation sluAnim;
    Animation suText;
    TextView sText;
    TextView lText;
    TextView uText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDialog = new Dialog(this);
    }

    // method for the begin button to create a pop up

    public void popUp(View view) {
        TextView sluX;
        //set content view on the popup xml
        myDialog.setContentView(R.layout.pop_up);
        //finding the various views required
        sluX = myDialog.findViewById(R.id.pop_close);
        lText = myDialog.findViewById(R.id.l_text);
        sText = myDialog.findViewById(R.id.s_text);
        uText =myDialog.findViewById(R.id.u_text);
        //executing the animations
        bounceLText();
        bounceSUText();
        //setting onClicklistner on the x button
        sluX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });//setting onclicklistner on the X button on the pop up
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//making the remaining layout transparent
        myDialog.show();



    }

    //method to implement a bounce effect on the S and U text views
    private void bounceSUText() {
        suText = AnimationUtils.loadAnimation(this, R.anim.bouncetop);//loading bouncetop anim xml
        sText.startAnimation(suText);
        uText.startAnimation(suText);
    }

    //method to implement a bounce effect on the L text view
    private void bounceLText() {
        sluAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);//loading bounce anim xml
        lText.startAnimation(sluAnim);
    }

    //Intent to move from this activity to the question 1 activity as the start button on pop is clicked

    public void lunchPage1(View view) {
        EditText personName = myDialog.findViewById(R.id.name);//finding the editable view on the pop up
        name = personName.getText().toString();//extracting the user input on the view
        Log.d("Testing", ""+ name);//log message for debugging
        if (name.matches("")) {
            Toast.makeText(this, "fill your name first", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "All the Best", Toast.LENGTH_SHORT).show();//toast message as button is clicked
            Intent question1intent = new Intent(MainActivity.this, Question1Activity.class);
            question1intent.putExtra("personName", name);//adding extra details to the intent
            startActivity(question1intent);//start the question1activity
        }
    }


}
