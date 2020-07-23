package com.github.panarik.smartFeatures.activity;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.github.panarik.smartFeatures.R;

public class LandscapeActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landscape);
    }
}