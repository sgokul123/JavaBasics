package com.bridgelabz.gokulproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.bridgelabz.gokulproject.R.id.email;

public class Registration extends AppCompatActivity {
    String Name,Add,E_mail,Number,Pass1,Pass2;

    Button button1;
    EditText editText1,editText2,editText3,editText4,editText5,editText6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_registration);

        editText1=(EditText)findViewById(R.id.Name);

        editText2=(EditText) findViewById(R.id.Email);
        editText3=(EditText) findViewById(R.id.Address);
        editText4=(EditText)findViewById(R.id.Phone);
        editText5=(EditText)findViewById(R.id.Password);
        editText6=(EditText) findViewById(R.id.RePassword);
        button1 = (Button)findViewById(R.id.Register);
        button1.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                Name=editText1.getText().toString();

                Add=editText3.getText().toString();
                E_mail=editText2.getText().toString();
               
                Number=editText4.getText().toString();
                Pass1=editText5.getText().toString();
                Pass2=editText6.getText().toString();
                if (Pass1.equals(Pass2) && !E_mail.equals("")) {
                    Toast.makeText(getApplicationContext(), "Name :" + Name + "EMail : " + E_mail + "Address : " + Add + "Phone : " + Number, Toast.LENGTH_LONG).show();
                    ;
                    Intent intent = new Intent(Registration.this, Main2Activity.class);
                    startActivity(intent);
                }
                else {
                    editText1.setText("");
                    editText2.setText("");
                    editText3.setText("");
                    editText4.setText("");
                    editText5.setText("");
                    editText6.setText("");
                    Toast.makeText(getApplicationContext(), "Please Enter Same Password ...", Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}
