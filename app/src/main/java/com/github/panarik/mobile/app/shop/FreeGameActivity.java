package com.github.panarik.mobile.app.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FreeGameActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_game);


    }

    public void chest(View view) {
        ImageView chestClosed = findViewById(R.id.chestClosed);
        ImageView chestEmpty = findViewById(R.id.chestEmpty);
        ImageView chestGold = findViewById(R.id.chestGold);
        Button tryAgain = findViewById(R.id.tryAgain);
        ImageView youVinView = findViewById(R.id.youVinView);

        int chanse = (int) (Math.random() * 4);
        if (chanse <= 2) {
            chestClosed.animate().alpha(0).setDuration(1);
            chestEmpty.animate().alpha(100).setDuration(500);
            tryAgain.animate().alpha(100).setDuration(500);

        }
        else if (chanse > 2){
            chestClosed.animate().alpha(0).setDuration(1);
            chestGold.animate().alpha(100).setDuration(500);
            youVinView.animate().alpha(100).setDuration(500);
        }
    }

    public void tryAgain(View view) {
        Intent goToMainIntent = new Intent(FreeGameActivity.this, MainActivity.class);
        startActivity(goToMainIntent);
    }

    public void anotherThings(View view) {
        Intent anotherThings = new Intent(FreeGameActivity.this, anotherThingsActivity.class);
        startActivity(anotherThings);
    }
}
