package com.bridgelabz.mediaplayer;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class AlertDialogBox extends AppCompatActivity {
    Button button;
    AlertDialog alert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_box);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
       button=(Button)findViewById(R.id.button8);
        builder.setTitle("Do you want close this application");
        builder.setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                     public void onClick(DialogInterface dialog, int id) {
                      //  Action for 'NO' Button
                      dialog.cancel();
            }
        });
         alert = builder.create();
        alert.setTitle("AlertDialogExample");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert.show();
            }
        });
      

    }
}
