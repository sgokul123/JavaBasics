package com.bridgelabz.happynewyear;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WishYou extends AppCompatActivity {
        Button button1,button2,button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_you);
        button1=(Button) findViewById(R.id.button2);
        button2=(Button) findViewById(R.id.button4);
        button3=(Button)findViewById(R.id.button5);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(WishYou.this,Gift.class);
                startActivity(intent);
                finish();

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s1="http://first-wishes.com/new/?n=Sonawane-Gokul/";
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(s1));
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(WishYou.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }
}
