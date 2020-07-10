package com.github.panarik.mobile.app.shop.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.github.panarik.mobile.app.shop.R;

public class PictureEffectsActivity extends AppCompatActivity implements View.OnClickListener {

    int statFliper = 1;
    int statResizeView = 1;
    int statFlowerImageView = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another_things);

        ImageView fliper = findViewById(R.id.fliper);
        ImageView resizeView = findViewById(R.id.resizeView);
        ImageView flowerImageView1 = findViewById(R.id.flowerImageView1);
        ImageView flowerImageView2 = findViewById(R.id.flowerImageView2);
        ImageView flowerImageView3 = findViewById(R.id.flowerImageView3);
        ImageView flowerImageView4 = findViewById(R.id.flowerImageView4);
        flowerImageView2.animate().alpha(0).setDuration(0);
        flowerImageView3.animate().alpha(0).setDuration(0);
        flowerImageView4.animate().alpha(0).setDuration(0);

        fliper.setOnClickListener(this);
        resizeView.setOnClickListener(this);
        flowerImageView1.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        ImageView fliper = findViewById(R.id.fliper);
        ImageView resizeView = findViewById(R.id.resizeView);
        ImageView flowerImageView = findViewById(R.id.flowerImageView1);
        ImageView flowerImageView2 = findViewById(R.id.flowerImageView2);
        ImageView flowerImageView3 = findViewById(R.id.flowerImageView3);
        ImageView flowerImageView4 = findViewById(R.id.flowerImageView4);

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
                    resizeView.animate().scaleY(2f).scaleX(2f).setDuration(500);
                } else {
                    resizeView.animate().scaleY(1f).scaleX(1f).setDuration(500);
                }
                break;

            case R.id.flowerImageView1:

                if (statFlowerImageView  == 1) {
                    flowerImageView.animate().alpha(0).setDuration(500);
                    flowerImageView2.animate().alpha(100).setDuration(8000);
                    statFlowerImageView = statFlowerImageView + 1;
                    Log.d("statFlowerImageView", "" + statFlowerImageView);
                } else if (statFlowerImageView  == 2) {
                    flowerImageView2.animate().alpha(0).setDuration(500);
                    flowerImageView3.animate().alpha(100).setDuration(8000);
                    statFlowerImageView = statFlowerImageView + 1;
                    Log.d("statFlowerImageView", "" + statFlowerImageView);
                } else if(statFlowerImageView  == 3){
                    flowerImageView3.animate().alpha(0).setDuration(0);
                    flowerImageView4.animate().alpha(100).setDuration(8000);
                    statFlowerImageView = statFlowerImageView + 1;
                    Log.d("statFlowerImageView", "" + statFlowerImageView);
                }
                break;

        }
    }

    public void goToVideoViewActivity(View view) {
        Intent goToVideoViewActivity = new Intent(PictureEffectsActivity.this, VideoViewActivity.class);
        startActivity(goToVideoViewActivity);
    }
}
