package com.github.panarik.smartFeatures.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.github.panarik.smartFeatures.R;

public class TaxiChooseModeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taxi_choose_mode);
    }

    public void goToPassengerSignIn(View view) {
        startActivity(new Intent(this, TaxiPassengerSignInActivity.class));
    }

    public void goToDriverSignIn(View view) {
        startActivity(new Intent(this, TaxiDriverSignInActivity.class));
    }
}