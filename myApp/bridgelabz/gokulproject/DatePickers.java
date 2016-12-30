package com.bridgelabz.gokulproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class DatePickers extends AppCompatActivity {
    DatePicker datePick;
    TextView textView1;
    TimePicker timePicker;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);
        datePick=(DatePicker) findViewById(R.id.datePicker2);
        textView1=(TextView) findViewById(R.id.textView4);
        timePicker=(TimePicker) findViewById(R.id.timePicker);
        /// textView1.setText((String) datePick.getDayOfMonth());
        button=(Button) findViewById(R.id.showDate);
       button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textView1.setText(timePicker.getCurrentHour()+":"+timePicker.getCurrentMinute()+" :"+getDateOfday(datePick));
                Toast.makeText(getApplicationContext(),getDateOfday(datePick),Toast.LENGTH_LONG).show();
            }

       });

    }

    private StringBuilder getDateOfday(DatePicker datePick) {
                StringBuilder str=new StringBuilder();
                str.append(datePick.getDayOfMonth()+"/");
                str.append(datePick.getMonth()+"/");
                str.append(datePick.getYear());

        return str;
    }
}
