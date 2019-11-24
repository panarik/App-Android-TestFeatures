package com.github.panarik.mobile.app.shop.menu.createinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.print.PrintAttributes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
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

/*
        TextView textInterfaceView1 = findViewById(R.id.textInterfaceView1);
        textInterfaceView1.setText("Пример №2 - Вывод текста силами Java c версткой в XML");
*/

        RelativeLayout relativeLayout = new RelativeLayout(this);
        TextView interfaceTextView3 = new TextView(this);
        TextView interfaceTextView4 = new TextView(this);
        Button interfaceButton1 = new Button(this);

        interfaceTextView3.setText("Пример №3 - Вывод текста в контейнере RelativeLayout силами Java класса");
        interfaceTextView3.setBackgroundColor(Color.GRAY);
        interfaceTextView3.setTextColor(Color.BLACK);
        interfaceTextView3.setTextSize(16);

        interfaceTextView4.setText("Пример №4 - Вывод текста в контейнере RelativeLayout силами Java класса");
        interfaceTextView4.setBackgroundColor(Color.GREEN);
        interfaceTextView4.setTextColor(Color.BLACK);
        interfaceTextView4.setTextSize(16);

        //создаём объекты с параметами
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200);
        layoutParams3.setMargins(30, 30, 30, 30);

        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200);
        layoutParams4.setMargins(30, 250, 30, 30);

        RelativeLayout.LayoutParams layoutParamsButton1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 150);
        layoutParamsButton1.setMargins(30, 1500, 30, 30);


        //применяем параметры ко всем View
        interfaceTextView3.setLayoutParams(layoutParams3);
        interfaceTextView3.setPadding(30, 30, 30, 30);
        interfaceTextView4.setLayoutParams(layoutParams4);
        interfaceTextView3.setPadding(30, 30, 30, 30);
        interfaceButton1.setLayoutParams(layoutParamsButton1);
        interfaceButton1.setBackgroundColor(Color.GRAY);
        interfaceButton1.setText("go To Another ViewGroups");

        interfaceButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoLinearLayoutActivity = new Intent(CreateInterfaceActivity.this, LinearLayoutActivity.class);
                startActivity(gotoLinearLayoutActivity);
            }
        });

        relativeLayout.addView(interfaceTextView3);
        relativeLayout.addView(interfaceTextView4);
        relativeLayout.addView(interfaceButton1);
        relativeLayout.setBackgroundColor(Color.LTGRAY);

        setContentView(relativeLayout);
    }


}
