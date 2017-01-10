package com.bridgelabz.mediaplayer;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
        Button buttonstart,buttonstop,buttonnext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonnext=(Button) findViewById(R.id.buttonNext);
        buttonstart=(Button) findViewById(R.id.buttonstart);
        buttonstop=(Button) findViewById(R.id.buttonstop);


        buttonstop.setOnClickListener(this);
        buttonnext.setOnClickListener(this);
        buttonstart.setOnClickListener(this);


    }

    @Override
    public void onClick(View src) {
        switch (src.getId()) {
            case R.id.buttonstart:
                startService(new Intent(this, MyService.class));
                break;
            case R.id.buttonstop:
                stopService(new Intent(this, MyService.class));
                break;
            case R.id.buttonNext:
               Intent intent=new Intent(this,MyService.class);
                startActivity(intent);
                break;
        }

    }
}
