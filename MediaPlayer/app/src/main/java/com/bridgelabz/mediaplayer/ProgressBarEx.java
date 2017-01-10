package com.bridgelabz.mediaplayer;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProgressBarEx extends AppCompatActivity {

    Button btnStartProgress;
    ProgressDialog progressBar;
    private int progressBarStatus = 0;
    private Handler progressBarHandler = new Handler();
    private long fileSize = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_ex);
        addListenerOnButtonClick();
    }
    public void addListenerOnButtonClick() {
        btnStartProgress = (Button) findViewById(R.id.button9);
        btnStartProgress.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // creating progress bar dialog
                progressBar = new ProgressDialog(v.getContext());
                progressBar.setCancelable(true);
                progressBar.setMessage("File downloading ...");
                progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressBar.setProgress(0);
                progressBar.setMax(100);
                progressBar.show();
                //reset progress bar and filesize status
                progressBarStatus = 0;
                fileSize = 0;

                new Thread(new Runnable() {
                    public void run() {
                        while (progressBarStatus < 100) {
                            // performing operation
                         //   progressBarStatus = doOperation();
                            try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
                            // Updating the progress bar
                            progressBarHandler.post(new Runnable() {
                                public void run() {
                                    progressBar.setProgress(progressBarStatus);
                                    progressBarStatus= progressBarStatus+10;
                                }
                            });
                        }
                        // performing operation if file is downloaded,
                        if (progressBarStatus >= 100) {
                            // sleeping for 1 second after operation completed
                            try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
                            // close the progress bar dialog
                            progressBar.dismiss();
                        }
                    }
                }).start();
            }//end of onClick method
        });
    }
    // checking how much file is downloaded and updating the filesize

}
