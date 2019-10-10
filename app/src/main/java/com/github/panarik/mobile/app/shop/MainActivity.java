package com.github.panarik.mobile.app.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increaseQuantity(View view) {
        TextView setTextView1 = findViewById(R.id.textView5);
        quantity = quantity + 1;
        if (quantity >9){
            quantity=9;
        }
        setTextView1.setText("" + quantity);
    }

    public void decreaseQuantity(View view) {
        TextView setTextView1 = findViewById(R.id.textView5);
        quantity = quantity - 1;
        if (quantity < 0) {
            quantity = 0;
        }
        setTextView1.setText("" + quantity);
    }
}
