package com.bridgelabz.mediaplayer;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AlarmMAnager extends AppCompatActivity {
        EditText editText1;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_manager);
        button1=(Button) findViewById(R.id.buttonstart);
        editText1=(EditText)findViewById(R.id.editText);

        button1.setOnClickListener(new View.OnClickListener() {
         @Override
            public void onClick(View view) {
            startAlert();


            }
        });
    }
    public void startAlert() {

        int i = Integer.parseInt(editText1.getText().toString());

        Intent intent = new Intent(this, MyBroadcastReceiver.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 234324243, intent, 0);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+ (i), pendingIntent);

        Toast.makeText(this, "Alarm set in " + i + " seconds",Toast.LENGTH_LONG).show();
    }
}
