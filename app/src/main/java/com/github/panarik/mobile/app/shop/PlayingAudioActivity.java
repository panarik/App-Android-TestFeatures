package com.github.panarik.mobile.app.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.github.panarik.mobile.app.shop.catgame.*;

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

    public void toPetAtcivity(View view) {
        Intent PetActivity = new Intent(PlayingAudioActivity.this, PetActivity.class);
        startActivity(PetActivity);
    }

    /*
_________________________________________________
Before refactoring
    MediaPlayer mediaPlayer;
    String control = "Play";
    int controlPlayStatus = 1;
    SeekBar volumeSeekBar;
    AudioManager audioManager;
    Button buttonControl;
    View controlPlay;
    View controlPause;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_audio);



        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.audio);
        volumeSeekBar = findViewById(R.id.volumeSeekBar);
        buttonControl = findViewById(R.id.buttonControl);
        controlPlay = findViewById(R.id.controlPlay);
        controlPause = findViewById(R.id.controlPause);

        buttonControl.setOnClickListener(this);
        controlPlay.setOnClickListener(this);
        controlPause.setOnClickListener(this);

        controlPause.animate().alpha(0).setDuration(0);
        Log.d("controlPlayStatusM: ", "start - "+controlPlayStatus);

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
                controlPlayStatus = controlPlayStatus + 1;
                controlPlay.animate().alpha(0).setDuration(0);
                controlPause.animate().alpha(100).setDuration(0);
                break;
            case 2:
                mediaPlayer.pause();
                controlPlayStatus = controlPlayStatus - 1;
                controlPlay.animate().alpha(100).setDuration(0);
                controlPause.animate().alpha(0).setDuration(0);
                break;
        }
    }

    @Override
    public void onClick(View v) {

        Button buttonControl = findViewById(R.id.buttonControl);
        ImageView controlPlay = findViewById(R.id.controlPlay);
        ImageView controlPause = findViewById(R.id.controlPause);

        switch (v.getId()) {
            case R.id.buttonControl:
                switch (controlPlayStatus) {
                    case 1:
                        mediaPlayer.start();
                        buttonControl.setText("Pause");
                        Log.d("buttonControl: ", ""+buttonControl);
                        controlPlay.animate().alpha(0).setDuration(0);
                        controlPause.animate().alpha(100).setDuration(0);
                        controlPlayStatus = controlPlayStatus + 1;
                        Log.d("buttonControlMessage: ", ""+buttonControl);
                        Log.d("controlPlayStatusM: ", ""+controlPlayStatus);
                        break;
                    case 2:
                        mediaPlayer.pause();
                        buttonControl.setText("Play");
                        controlPlay.animate().alpha(100).setDuration(0);
                        controlPause.animate().alpha(0).setDuration(0);
                        controlPlayStatus = controlPlayStatus - 1;
                        Log.d("buttonControlMessage: ", ""+buttonControl);
                        Log.d("controlPlayStatusM: ", ""+controlPlayStatus);
                        break;
                }
                break;
            case R.id.controlPlay:
                switch (controlPlayStatus) {
                    case 1:
                        mediaPlayer.start();
                        controlPlayStatus = controlPlayStatus + 1;
                        controlPlay.animate().alpha(0).setDuration(0);
                        controlPause.animate().alpha(100).setDuration(0);
                        buttonControl.setText("Pause");
                        Log.d("controlPlayStatusM: ", "onClick controlPlay - "+controlPlayStatus);
                        break;
                    case 2:
                        mediaPlayer.pause();
                        controlPlayStatus = controlPlayStatus - 1;
                        controlPlay.animate().alpha(100).setDuration(0);
                        controlPause.animate().alpha(0).setDuration(0);
                        buttonControl.setText("Play");
                        Log.d("controlPlayStatusM: ", "onClick controlPlay - "+controlPlayStatus);
                        break;
                }
                break;
        }
    }
*/

}
