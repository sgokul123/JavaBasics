package com.bridgelabz.mynewapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UserInfo extends AppCompatActivity {
    DatabaseHandler db;
    TextView textView,textView2,textView3;
    Button button;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        textView=(TextView)findViewById(R.id.textView3);
        textView2=(TextView)findViewById(R.id.textView4);
        textView3=(TextView)findViewById(R.id.textView5);
        button=(Button) findViewById(R.id.buttonCloseInf);
          Intent intent=getIntent();
                name  =intent.getStringExtra("name");
                 db = new DatabaseHandler(getApplicationContext());
                display();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    private void display(){
        Cursor cursor=db.getUser(name);
        if (cursor.moveToFirst()) {
            textView.setText(textView.getText()+cursor.getString(1));
            textView2.setText(textView2.getText()+cursor.getString(3));
            textView3.setText(textView3.getText()+cursor.getString(4));
            Toast.makeText(getApplicationContext(), ""+cursor.getString(1), Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"sorrry",Toast.LENGTH_LONG).show();
        }
    }
}
