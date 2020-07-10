package com.github.panarik.mobile.app.shop.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.github.panarik.mobile.app.shop.R;

public class VideoLocalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_local);

        VideoView videoView = findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.wedding);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        //videoView.start();

    }

    public void toPlayingAudio(View view) {
        Intent VideoWebActivity = new Intent(VideoLocalActivity.this, VideoWebActivity.class);
        startActivity(VideoWebActivity);
    }
}