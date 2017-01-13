package com.bridgelabz.mynewapp;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ADDdata extends AppCompatActivity {
    String name, pass, pass2, add, phone;
    Button buttonBack, buttonSubmit;
    EditText editTextName, editTextpPhone, editTextAddress, editTextPass1, editTextPass2;
    DatabaseHandler db = new DatabaseHandler(this);

    // DatabaseHandler databH;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddata);
        buttonBack = (Button) findViewById(R.id.button4back);
        buttonSubmit = (Button) findViewById(R.id.button3submit);
        editTextName = (EditText) findViewById(R.id.editTextname);
        editTextAddress = (EditText) findViewById(R.id.editTextadd);
        editTextpPhone = (EditText) findViewById(R.id.editTextphone);
        editTextPass1 = (EditText) findViewById(R.id.editText4pass);
        editTextPass2 = (EditText) findViewById(R.id.editText5pass);
        //Go to Back Page
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ADDdata.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //Add record to database
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = editTextName.getText().toString().trim();
                add = editTextAddress.getText().toString().trim();
                phone = editTextpPhone.getText().toString();
                pass = editTextPass1.getText().toString();
                pass2 = editTextPass2.getText().toString();
                insertIntoDB();
              }
        });

    }

    protected void insertIntoDB() {
        if (name.equals("") || add.equals("") || phone.equals("") || pass.equals("") || pass2.equals("")) {
            Toast.makeText(getApplicationContext(), "Please fill all fields", Toast.LENGTH_LONG).show();
        } else if (!pass.equals(pass2)) {
            editTextPass2.setText("");
            editTextPass1.setText("");
            Toast.makeText(getApplicationContext(), "Please Re-Enter Same Password", Toast.LENGTH_LONG).show();
        } else {
            db.InsertRec(name, pass, phone, add);
            Toast.makeText(getApplicationContext(),"record is inserted",Toast.LENGTH_LONG).show();
            cleareAll();
        }

    }
    public void cleareAll(){
            editTextAddress.setText("");
        editTextName.setText("");
        editTextPass2.setText("");
        editTextPass1.setText("");
        editTextpPhone.setText("");
    }
}