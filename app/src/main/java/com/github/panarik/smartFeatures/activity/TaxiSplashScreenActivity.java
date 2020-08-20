package com.github.panarik.smartFeatures.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.github.panarik.smartFeatures.R;

public class TaxiSplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread thread = new Thread() {

            @Override
            public void run(){
                try {
                    sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(TaxiSplashScreenActivity.this, TaxiSignInActivity.class));
                }
            }

        };

        thread.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}