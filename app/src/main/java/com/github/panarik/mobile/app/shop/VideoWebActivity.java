package com.github.panarik.mobile.app.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class VideoWebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_web);
    }

    public void toPlayingAudio(View view) {
        Intent PlayingAudioActivity = new Intent(VideoWebActivity.this, PlayingAudioActivity.class);
        startActivity(PlayingAudioActivity);
    }


}
