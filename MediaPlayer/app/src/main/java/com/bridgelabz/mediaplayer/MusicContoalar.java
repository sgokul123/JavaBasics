package com.bridgelabz.mediaplayer;

import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MusicContoalar extends AppCompatActivity {
     MediaPlayer mp;
    Button start,pause,stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_contoalar);

        start=(Button)findViewById(R.id.button);
        pause=(Button)findViewById(R.id.button2);
        stop=(Button)findViewById(R.id.button3);
        //creating media player
       assign();

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                assign();
             }
        });
    }

    private void assign() {
        mp=new MediaPlayer();
        try{
            //you can change the path, here path is external directory(e.g. sdcard) /Music/maine.mp3
            //mp.setDataSource(Environment.getExternalStorageDirectory().getPath()+"/storage/sdcard1/Music/maine.mp3");
            mp.setDataSource("/storage/sdcard1/Music/maine.mp3");
            mp.prepare();
        }catch(Exception e){e.printStackTrace();}
    }
}
