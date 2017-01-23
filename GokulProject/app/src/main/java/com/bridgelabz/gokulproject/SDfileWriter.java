package com.bridgelabz.gokulproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SDfileWriter extends AppCompatActivity {
    String fname;
    String data;
    EditText editText1,editText2;
    TextView textView1,textView2;
    Button  button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdfile_writer);
        button2=(Button) findViewById(R.id.Buttread);
        button1=(Button) findViewById(R.id.ButtWrite);
        textView1=(TextView) findViewById(R.id.textView6);
        editText1=(EditText) findViewById(R.id.editText6);
        editText2=(EditText) findViewById(R.id.editText7);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override

            //write file
            public void onClick(View view) {
               try {
                   fname=editText1.getText().toString();
                   data=editText2.getText().toString();

                   File myFile = new File("/sdcard/"+fname);
                   myFile.createNewFile();
                   FileOutputStream fOut = new FileOutputStream(myFile);
                   OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
                   myOutWriter.append(data);
                   myOutWriter.close();
                   fOut.close();
                    textView1.setText(data);
                   Toast.makeText(getApplicationContext(),fname + " saved",Toast.LENGTH_LONG).show();

               }catch(Exception e){}
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
           //file reader
                    String aDataRow = "";
            String aBuffer = "";
            public void onClick(View view) {
               try{
                   textView1.setText("");
                   fname=editText1.getText().toString();
                   data=editText2.getText().toString();
                    File myFile = new File("/sdcard/"+fname);
                    FileInputStream fIn = new FileInputStream(myFile);
                    BufferedReader myReader = new BufferedReader(new InputStreamReader(fIn));

                    while ((aDataRow = myReader.readLine()) != null) {
                        aBuffer += aDataRow + "\n";
                    }
                    myReader.close();
                    textView1.setText(aBuffer);
                   Toast.makeText(getApplicationContext(),aBuffer+"",Toast.LENGTH_LONG).show();
                }catch(Exception e){

                }


            }
        });

    }
}
