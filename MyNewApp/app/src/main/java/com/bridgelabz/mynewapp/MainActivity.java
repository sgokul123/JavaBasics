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

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    EditText editTextName,editTextPass;
    Button btnAdd,buttonselect,buttondelete,buttonUpdate,buttonLogin,buttonBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner=(Spinner)findViewById(R.id.spinner);
        //textView=(TextView) findViewById(R.id.textView);
        buttondelete=(Button) findViewById(R.id.buttondelete);
        btnAdd=(Button) findViewById(R.id.buttonadd);
        buttonLogin=(Button) findViewById(R.id.buttonLogin);
        editTextName=(EditText) findViewById(R.id.editTextId);
        editTextPass=(EditText) findViewById(R.id.editTextPass);
        buttonBack=(Button) findViewById(R.id.buttonBack);
        buttonUpdate=(Button) findViewById(R.id.buttonUpdate);
        buttonselect=(Button) findViewById(R.id.buttonSelect);
        setInvisibleLogin();
        buttondelete.setVisibility(View.INVISIBLE);
        buttonUpdate.setVisibility(View.INVISIBLE);
        loadSpinnerData();
        buttonselect.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,ADDdata.class);
                startActivity(intent);

            }
        });
        buttondelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name= spinner.getSelectedItem().toString();
                DatabaseHandler db = new DatabaseHandler(getApplicationContext());
                if(db.deleteTitle(name)){
                 Toast.makeText(getApplicationContext(),"Record is deleted",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Record is not pressent ",Toast.LENGTH_LONG).show();
                }
                loadSpinnerData();
            }


        });
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHandler db = new DatabaseHandler(getApplicationContext());
                String name=editTextName.getText().toString();
                String pass =editTextPass.getText().toString();
                if(db.isUser(name,pass)){
                    Toast.makeText(getApplicationContext(),"user is loged in ",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"user is not logedin ",Toast.LENGTH_LONG).show();

                }
            }
        });
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInvisibleLogin();
            }
        });
    }

    private void loadSpinnerData() {
        // database handler
        DatabaseHandler db = new DatabaseHandler(getApplicationContext());
         // Spinner Drop down elements
        List<String> lables = db.getAllNames();
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position,long id) {

        String label = parent.getItemAtPosition(position).toString();
         Toast.makeText(parent.getContext(), "You selected: " + label,Toast.LENGTH_LONG).show();

    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                setInvisibleLogin();
                buttonUpdate.setVisibility(View.INVISIBLE);
                buttondelete.setVisibility(View.VISIBLE);
                return true;
            case R.id.item2:
                setInvisibleLogin();
                buttonUpdate.setVisibility(View.VISIBLE);
                buttondelete.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(), "Item 2 Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.item3:

                setVisibleLogin();
                buttonUpdate.setVisibility(View.INVISIBLE);
                buttondelete.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(), "Item 3 Selected", Toast.LENGTH_LONG).show();
                return true;
            default:
                Intent intent=new Intent(MainActivity.this,ADDdata.class);
                return super.onOptionsItemSelected(item);
        }
    }
    // Menu Item Adding
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);//Menu Resource, Menu
        return true;
    }
    private  void setVisibleLogin(){
        editTextName.setVisibility(View.VISIBLE);
        editTextPass.setVisibility(View.VISIBLE);
        buttonBack.setVisibility(View.VISIBLE);
        buttonLogin.setVisibility(View.VISIBLE);
        buttonUpdate.setVisibility(View.INVISIBLE);
        buttondelete.setVisibility(View.INVISIBLE);
        buttonselect.setVisibility(View.INVISIBLE);
        btnAdd.setVisibility(View.INVISIBLE);
        spinner.setVisibility(View.INVISIBLE);
    }
    private void setInvisibleLogin(){
        editTextName.setVisibility(View.INVISIBLE);
        editTextPass.setVisibility(View.INVISIBLE);
        buttonBack.setVisibility(View.INVISIBLE);
        buttonLogin.setVisibility(View.INVISIBLE);
        buttonUpdate.setVisibility(View.VISIBLE);
        buttondelete.setVisibility(View.VISIBLE);
        spinner.setVisibility(View.VISIBLE);
        buttonselect.setVisibility(View.VISIBLE);
        btnAdd.setVisibility(View.VISIBLE);

    }
}
