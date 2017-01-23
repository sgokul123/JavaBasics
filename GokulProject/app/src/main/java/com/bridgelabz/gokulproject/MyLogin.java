package com.bridgelabz.gokulproject;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MyLogin extends AppCompatActivity {
    EditText editText1,editText2;
    Button button1,button2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_login);
        button1=(Button) findViewById(R.id.Login);
        button2=(Button) findViewById(R.id.register);
        editText1=(EditText)findViewById(R.id.Email);
        editText2=(EditText) findViewById(R.id.password);

       /* button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(editText1.getText().toString().equals("gokul@gmail.com")&& editText2.getText().toString().equals("admin")){
                    Toast.makeText(getApplicationContext(),"WElcome you are loged in...",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Sorry Wrong Email and Password...",Toast.LENGTH_LONG).show();

                }
            }
        });*/

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(),"Please Register as a new User...",Toast.LENGTH_LONG).show();
                Intent intent =new Intent(MyLogin.this,Registration.class);
                startActivity(intent);

            }
        });


    }
}
