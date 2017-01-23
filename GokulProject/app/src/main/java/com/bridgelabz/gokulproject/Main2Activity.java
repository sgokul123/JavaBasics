package com.bridgelabz.gokulproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Main2Activity extends AppCompatActivity {
    StringBuilder result = new StringBuilder();
    ToggleButton toggleButton1,toggleButton2;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        toggleButton1=(ToggleButton) findViewById(R.id.toggleButton);
         toggleButton2=(ToggleButton) findViewById(R.id.toggleButton2);
         b1=(Button)findViewById(R.id.button2);
       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               result.append("ToggleButton1 : ").append(toggleButton1.getTextOff());
               result.append("\nToggleButton2 : ").append(toggleButton2.getTextOn());
               result.append("ToggleButton1 : ").append(toggleButton1.getTextOn());
               result.append("\nToggleButton2 : ").append(toggleButton2.getTextOff());

               Intent intent = new Intent(Main2Activity.this,Demo.class);
               startActivity(intent);
               //Displaying the message in toast
               Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();
           }
       });


    }

}
