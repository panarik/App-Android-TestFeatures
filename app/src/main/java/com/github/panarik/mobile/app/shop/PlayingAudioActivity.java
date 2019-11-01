package com.github.panarik.mobile.app.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

public class PlayingAudioActivity extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer mediaPlayer;
    String control = "Play";
    int controlPlayStatus = 1;
    SeekBar volumeSeekBar;
    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_audio);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.audio);
        volumeSeekBar = findViewById(R.id.volumeSeekBar);

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        volumeSeekBar.setMax(maxVolume);
        volumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("Progress_changed", "" + progress);
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void Control(View view) {

        Button buttonControl = findViewById(R.id.buttonControl);

        switch (control) {
            case "Play":
                mediaPlayer.start();
                buttonControl.setText("Pause");
                control = "Pause";
                break;
            case "Pause":
                mediaPlayer.pause();
                buttonControl.setText("Play");
                control = "Play";
                break;
        }
    }

    public void controlVolume(View view) {

        View controlPlay = findViewById(R.id.controlPlay);
        View controlPause = findViewById(R.id.controlPause);

        switch (controlPlayStatus) {
            case 1:
                mediaPlayer.start();
                controlPlayStatus = controlPlayStatus+1;
                controlPlay.animate().alpha(0).setDuration(500);
                controlPause.animate().alpha(100).setDuration(500);
                break;
            case 2:
                mediaPlayer.pause();
                controlPlayStatus = controlPlayStatus-1;
                controlPlay.animate().alpha(100).setDuration(500);
                controlPause.animate().alpha(0).setDuration(500);
                break;
        }
    }

    @Override
    public void onClick(View v) {

    }
}
