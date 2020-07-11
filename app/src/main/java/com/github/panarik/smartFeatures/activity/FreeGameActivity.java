package com.github.panarik.smartFeatures.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.github.panarik.smartFeatures.R;

public class FreeGameActivity extends AppCompatActivity {

    private ImageView chestClosed;
    private ImageView chestEmpty;
    private ImageView chestGold;
    private Button tryAgain;
    private ImageView youVinView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_game);

        chestClosed = findViewById(R.id.chestClosed);
        chestEmpty = findViewById(R.id.chestEmpty);
        chestGold = findViewById(R.id.chestGold);
        tryAgain = findViewById(R.id.tryAgain);
        youVinView = findViewById(R.id.youVinView);

        tryAgain.setVisibility(Button.INVISIBLE);


    }

    public void chest(View view) {


        int chanse = (int) (Math.random() * 4);
        if (chanse <= 2) {
            chestClosed.animate().alpha(0).setDuration(1);
            chestEmpty.animate().alpha(100).setDuration(500);
            tryAgain.setVisibility(Button.VISIBLE);

        }
        else if (chanse > 2){
            chestClosed.animate().alpha(0).setDuration(1);
            chestGold.animate().alpha(100).setDuration(500);
            youVinView.animate().alpha(100).setDuration(500);
            tryAgain.setVisibility(Button.INVISIBLE);
        }
    }

    public void tryAgain(View view) {
        Intent goToMainIntent = new Intent(FreeGameActivity.this, ShopMainActivity.class);
        startActivity(goToMainIntent);
    }

    public void goToPictureEffectsActivity(View view) {
        Intent goToPictureEffectsActivity = new Intent(FreeGameActivity.this, PictureEffectsActivity.class);
        startActivity(goToPictureEffectsActivity);
    }

    public void goToMenuActivity(View view) {

        Intent goToMenuActivity = new Intent (FreeGameActivity.this, MenuActivity.class);
        startActivity(goToMenuActivity);
    }
}
