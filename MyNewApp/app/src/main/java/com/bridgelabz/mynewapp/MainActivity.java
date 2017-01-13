package com.bridgelabz.mynewapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //Spinner spinner;
    EditText editTextName,editTextPass;
    Button btnAdd,buttonLogin,close;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          //textView=(TextView) findViewById(R.id.textView);
        btnAdd=(Button) findViewById(R.id.buttonadd);
        buttonLogin=(Button) findViewById(R.id.buttonLogin);
        editTextName=(EditText) findViewById(R.id.editTextId);
        editTextPass=(EditText) findViewById(R.id.editTextPass);
        close=(Button)findViewById(R.id.buttonclose);
         btnAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,ADDdata.class);
                startActivity(intent);
                finish();

            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHandler db = new DatabaseHandler(getApplicationContext());
                String name=editTextName.getText().toString();
                String pass =editTextPass.getText().toString();
                if(db.isUser(name,pass)){
                    Intent intent=new Intent(MainActivity.this,HomePage.class);
                    intent.putExtra("name",editTextName.getText().toString());
                    startActivity(intent);
                    editTextName.setText("");
                    editTextPass.setText("");
                    Toast.makeText(getApplicationContext(),"User is logIn ",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"This is Not a Valid User",Toast.LENGTH_LONG).show();

                }

            }
        });

    }
    private  void setVisibleLogin(){
        editTextName.setVisibility(View.VISIBLE);
        editTextPass.setVisibility(View.VISIBLE);
        buttonLogin.setVisibility(View.VISIBLE);
        btnAdd.setVisibility(View.INVISIBLE);
        }
    private void setInvisibleLogin(){
        editTextName.setVisibility(View.INVISIBLE);
        editTextPass.setVisibility(View.INVISIBLE);
        buttonLogin.setVisibility(View.INVISIBLE);
        btnAdd.setVisibility(View.VISIBLE);

    }
}
