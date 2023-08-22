package com.github.panarik.smartFeatures.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.panarik.smartFeatures.R;
import com.github.panarik.smartFeatures.activity.mainMenu.MainActivity;

public class FreeGameActivity extends AppCompatActivity {

    private ImageView chestClosed;
    private ImageView chestEmpty;
    private ImageView chestGold;
    private Button tryAgain;
    private ImageView youVinView;
    private TextView hint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_game);

        chestClosed = findViewById(R.id.chestClosed);
        chestEmpty = findViewById(R.id.chestEmpty);
        chestGold = findViewById(R.id.chestGold);
        tryAgain = findViewById(R.id.tryAgain);
        youVinView = findViewById(R.id.youVinView);
        hint = findViewById(R.id.freeGame_hintTextView);

        tryAgain.setVisibility(Button.INVISIBLE);


    }

    public void chest(View view) {

        hint.setVisibility(TextView.INVISIBLE);


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
        Intent goToMainIntent = new Intent(FreeGameActivity.this, MainActivity.class);
        startActivity(goToMainIntent);
    }


    public void goToMainActivity(View view) {
        Intent goToMainActivity = new Intent(this, MainActivity.class);
        startActivity(goToMainActivity);
    }

    public void goToMenuActivity(View view) {
        Intent goToMenuActivity = new Intent (FreeGameActivity.this, MenuActivity.class);
        startActivity(goToMenuActivity);
    }
}
