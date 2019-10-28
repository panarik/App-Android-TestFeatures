package com.github.panarik.mobile.app.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

public class anotherThingsActivity extends AppCompatActivity implements View.OnClickListener {

    int statFliper = 1;
    int statResizeView = 1;
    int statFlowerImageView = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another_things);

        ImageView fliper = findViewById(R.id.fliper);
        ImageView resizeView = findViewById(R.id.resizeView);
        ImageView flowerImageView = findViewById(R.id.resizeView);
        fliper.setOnClickListener(this);
        resizeView.setOnClickListener(this);
        flowerImageView.setOnClickListener(this);


    }
/*

    public void flip(View view) {
        ImageView fliper = findViewById(R.id.fliper);
        fliper.animate().rotation(180).setDuration(500);
    }

    public void zoom(View view) {
        ImageView resizeView = findViewById(R.id.resizeView);
        resizeView.animate().scaleY(0.2f).scaleX(0.2f).rotation(720).translationXBy(300).setDuration(1000);
    }
*/

    @Override
    public void onClick(View v) {

        ImageView fliper = findViewById(R.id.fliper);
        ImageView resizeView = findViewById(R.id.resizeView);
        ImageView flowerImageView = findViewById(R.id.resizeView);

        switch (v.getId()) // Метод view.getId()
        {
            case R.id.fliper:
                statFliper = statFliper + 1;

                if (statFliper % 2 == 0) {
                    fliper.animate().rotation(180).setDuration(1000);
                } else {
                    fliper.animate().rotation(0).setDuration(1000);
                }
                break;
            case R.id.resizeView:
                statResizeView = statResizeView + 1;

                if (statResizeView % 2 == 0) {
                    flowerImageView.animate().scaleY(1f).scaleX(1f).setDuration(1000);
                } else {
                    resizeView.animate().scaleY(3f).scaleX(3f).setDuration(1000);
                }
                break;


        }
    }
}
