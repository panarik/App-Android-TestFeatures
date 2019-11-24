package com.github.panarik.mobile.app.shop.menu.createinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.github.panarik.mobile.app.shop.R;

public class CreateInterfaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_interface);
/*

        TextView textView = new TextView(this);
        textView.setText("Пример №1 - Вывод текста силами Java без верстки в XML");
        textView.setTextSize(16);
        setContentView(textView);
*/

        TextView textInterfaceView1 = findViewById(R.id.textInterfaceView1);
        textInterfaceView1.setText("Пример №2 - Вывод текста силами Java c версткой в XML");
    }
}
