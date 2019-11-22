package com.github.panarik.mobile.app.shop.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.github.panarik.mobile.app.shop.R;

public class MenuActivity extends AppCompatActivity {

    String[] themes = {"№1 - Создание интерфейса", "№2 - Основные элементы управления", "№3 - Ресурсы"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ListView themesList = (ListView) findViewById(R.id.themesListView);
        ArrayAdapter themesAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, themes);
        themesList.setAdapter(themesAdapter);
    }
}
