package com.bridgelabz.gokulproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class Demo extends AppCompatActivity {
    RadioButton radioButton1,radioButton2;
    Button button1;
    CheckBox checkBox1,checkBox2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        radioButton1=(RadioButton)findViewById(R.id.radioButton);
        radioButton2=(RadioButton)findViewById(R.id.radioButton2);
        checkBox1=(CheckBox)findViewById(R.id.checkBox3);
        checkBox2=(CheckBox)findViewById(R.id.checkBox4);
        button1=(Button)findViewById(R.id.button3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1="",s2="";
                if(radioButton1.isChecked()){
                    s1=radioButton1.getText().toString();
                 }
                else if(radioButton2.isChecked()){
                    s1=radioButton2.getText().toString();
                 }else{
                    Toast.makeText(getApplicationContext(), "Please Select any One ...", Toast.LENGTH_LONG).show();

                 }
                //radio button 2
                if(checkBox1.isChecked()){
                    s2=checkBox1.getText().toString();
                 }else if(checkBox2.isChecked()){
                    s2=checkBox2.getText().toString();
                 }
                else{
                    Toast.makeText(getApplicationContext(), "Please Select Any One...", Toast.LENGTH_LONG).show();
                 }
                Toast.makeText(getApplicationContext(),"Your Qualification is :  "+s2+" You are  a   "+s1, Toast.LENGTH_LONG).show();

            }
        });
    }
}
