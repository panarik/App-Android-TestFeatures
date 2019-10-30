package com.github.panarik.mobile.app.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class PlayingAudioActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_audio);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.audio);
    }

    public void Play(View view) {
        mediaPlayer.start();
    }

    public void Pause(View view) {
        mediaPlayer.pause();
    }
}
