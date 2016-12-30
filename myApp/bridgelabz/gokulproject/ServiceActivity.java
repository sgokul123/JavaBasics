package com.bridgelabz.gokulproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ServiceActivity extends AppCompatActivity {
    Button buttonStart, buttonStop,buttonNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonStop = (Button) findViewById(R.id.buttonStop);
        buttonNext = (Button) findViewById(R.id.nextPage);

     //  nextPage buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener((View.OnClickListener) this);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonStart:
                        startService(new Intent(ServiceActivity.this, MyService.class));
                        break;
                    case R.id.buttonStop:
                        stopService(new Intent(ServiceActivity.this, MyService.class));
                        break;
                    case R.id.nextPage:
                        Intent intent = new Intent(ServiceActivity.this, NExtActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}