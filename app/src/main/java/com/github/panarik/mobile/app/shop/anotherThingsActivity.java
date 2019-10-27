package com.github.panarik.mobile.app.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

public class anotherThingsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another_things);

    }

    public void flip(View view) {
        ImageView fliper = findViewById(R.id.fliper);
        fliper.animate().rotation(180).setDuration(500);
    }

    public void zoom(View view) {
        ImageView resizeView = findViewById(R.id.resizeView);
        resizeView.animate().scaleY(0.2f).scaleX(0.2f).rotation(720).translationXBy(300).setDuration(1000);

    }
}
