package com.github.panarik.smartFeatures.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.github.panarik.smartFeatures.R;
import com.github.panarik.smartFeatures.activity.mainMenu.MainActivity;

import java.util.Timer;
import java.util.TimerTask;

public class PlayingAudioActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer; //плеер
    ImageView playPauseIcon; //динамическая кнопка "play/pause"
    SeekBar seekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_audio);

        playPauseIcon = findViewById(R.id.controlPlayPause);
        seekBar = findViewById(R.id.seekBar);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.audio);
        seekBar.setMax(mediaPlayer.getDuration()); //длительность аудио трека
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { //листенер изменения положения seekBar
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Timer().scheduleAtFixedRate(new TimerTask() { //создаём таймер, который будет обновлять seekBar
            @Override
            public void run() {
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
            }
        }, 0, 100); // запуск сразу, обновление 10 раз в сек.
    }

    public void Backward(View view) {
        seekBar.setProgress(0);
        mediaPlayer.seekTo(0);
        mediaPlayer.pause();
        playPauseIcon.setImageResource(R.drawable.ic_logo_media_play_75);

    }

    public void Forward(View view) {
        seekBar.setProgress(mediaPlayer.getDuration());
        mediaPlayer.seekTo(mediaPlayer.getDuration());
        mediaPlayer.pause();
        playPauseIcon.setImageResource(R.drawable.ic_logo_media_play_75);
    }

    public void Play(View view) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            playPauseIcon.setImageResource(R.drawable.ic_logo_media_play_75);
        } else {
            mediaPlayer.start();
            playPauseIcon.setImageResource(R.drawable.ic_logo_media_pause_75);
        }
    }

    public void goToMainActivity(View view) {
        Intent goToMainActivity = new Intent(this, MainActivity.class);
        startActivity(goToMainActivity);
    }

}
