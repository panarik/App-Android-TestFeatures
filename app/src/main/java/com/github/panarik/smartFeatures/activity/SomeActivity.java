package com.github.panarik.smartFeatures.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.github.panarik.smartFeatures.app.shop.R;

public class SomeActivity extends AppCompatActivity {

    private static final String TAG = "SomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_some);

        Log.d(TAG, "onCreate: called");
    }
}
