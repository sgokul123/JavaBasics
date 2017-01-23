package com.bridgelabz.gokulproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText1,editText2;
    TextView editText3 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();

    }
    public void addListenerOnButton(){
        editText1=(EditText)findViewById(R.id.editText1);
        editText2=(EditText)findViewById(R.id.editText2);
        editText3=(TextView)findViewById(R.id.textView1);
        Button buttonSum = (Button) findViewById(R.id.button);

        buttonSum.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String value1=editText1.getText().toString();
                String value2=editText2.getText().toString();
                int a=Integer.parseInt(value1);
                int b=Integer.parseInt(value2);
                int sum=a+b;
                Toast.makeText(getApplicationContext(),"the sum is : "+sum,Toast.LENGTH_LONG).show();
                Intent intent =new Intent(MainActivity.this,MyLogin.class);
                startActivity(intent);

            }

        });

    }
}
