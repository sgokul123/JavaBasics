package com.bridgelabz.mynewapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomePage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView textView;
    Intent myIntent;
    String name;
    Button buttoncal,logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        myIntent=getIntent();
        textView=(TextView) findViewById(R.id.textView2);
        name =myIntent.getStringExtra("name");
        buttoncal=(Button) findViewById(R.id.buttoncal);
        logout=(Button)findViewById(R.id.logout);
        textView.setText(textView.getText()+name.toUpperCase());
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this,MainActivity.class);
                finish();
            }
        });
        buttoncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this,Calculator.class);
                startActivity(intent);

            }
        });
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                //User Info
                    Intent intent=new Intent(HomePage.this,UserInfo.class);
                intent.putExtra("name",name);
                    startActivity(intent);

                return true;
            case R.id.item2:
                Intent intent1=new Intent(HomePage.this,Calculator.class);
                startActivity(intent1);
               // Toast.makeText(getApplicationContext(), "Item 2 Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.item3:

                Toast.makeText(getApplicationContext(), "Item 3 Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.item4:
                finish();
                return  true;
            default:
                //   Intent intent=new Intent(MainActivity.this,Calculators.class);
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }
    // Menu Item Adding
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);//Menu Resource, Menu
        return true;
    }
}