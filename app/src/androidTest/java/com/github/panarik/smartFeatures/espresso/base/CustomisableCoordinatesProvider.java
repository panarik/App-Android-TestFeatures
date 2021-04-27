package com.github.panarik.smartFeatures.espresso.base;

import android.view.View;

import androidx.test.espresso.action.CoordinatesProvider;

public class CustomisableCoordinatesProvider implements CoordinatesProvider {

    private int x;
    private int y;

    public CustomisableCoordinatesProvider(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public float[] calculateCoordinates(View view) {
        return new float[]{x,y};
    }
}
