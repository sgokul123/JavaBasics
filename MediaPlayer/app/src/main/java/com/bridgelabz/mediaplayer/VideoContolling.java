package com.bridgelabz.mediaplayer;

import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoContolling extends AppCompatActivity {


    VideoView videoview ;
    MediaController mediacontroller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_contolling);

        videoview = (VideoView)findViewById(R.id.videoView);
        mediacontroller = new MediaController(VideoContolling.this);

        videoview.setVideoPath( "/storage/sdcard1/Music/dfg.mp4");

        mediacontroller.setAnchorView(videoview);

        videoview.setMediaController(mediacontroller);
        videoview.requestFocus();
        videoview.start();

    }

}
