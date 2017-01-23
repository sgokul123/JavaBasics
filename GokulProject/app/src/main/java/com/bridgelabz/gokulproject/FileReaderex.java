package com.bridgelabz.gokulproject;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class FileReaderex extends AppCompatActivity {
    String fname;
    String data;
    EditText editText1,editText2;
    TextView textView1;
    Button button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_readerex);

        button1=(Button) findViewById(R.id.button8);
        button2=(Button) findViewById(R.id.button7);
        textView1=(TextView) findViewById(R.id.textView5);
        editText1=(EditText) findViewById(R.id.editText4);
        editText2=(EditText) findViewById(R.id.editText5);



        button1.setOnClickListener(new View.OnClickListener() {
           // @Override
            FileOutputStream fout;

            public void onClick(View view) {
                fname =editText1.getText().toString();
                data= editText2.getText().toString();
            try {

                fout = openFileOutput(fname, Context.MODE_PRIVATE);
                fout.write(data.getBytes());
                fout.close();
            }catch(Exception e){
                Toast.makeText(getApplicationContext(),e+"",Toast.LENGTH_LONG).show();
            }

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
         //   @Override
            StringBuffer sri=new StringBuffer();
            public void onClick(View view) {
                try {textView1.setText("");
                        String inputString;
                    BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput(fname)));
                    while ((inputString = br.readLine()) != null) {
                        sri.append(inputString + "\n");
                    }
                        textView1.setText(sri);
                    br.close();
                } catch(Exception e){
                    Toast.makeText(getApplicationContext(),e+"",Toast.LENGTH_LONG).show();

                    }
                }


        });



    }
}
