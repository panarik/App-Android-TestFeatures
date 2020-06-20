package com.github.panarik.mobile.app.shop.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.github.panarik.mobile.app.shop.R;
import com.github.panarik.mobile.app.shop.data.menu.createinterface.CreateInterfaceActivity;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    ListView listMenuView;
    ArrayList<String> arrayMenuList;
    ArrayAdapter arrayMenuAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        listMenuView = findViewById(R.id.themesListView);
        arrayMenuList = new ArrayList<>();
        arrayMenuList.add("Создание интерфейса"); // №0
        arrayMenuList.add("Элементы управления"); // №1
        arrayMenuList.add("Ресурсы"); // №2

        arrayMenuAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayMenuList);
        listMenuView.setAdapter(arrayMenuAdapter);

        listMenuView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        Intent goToCreateInterface = new Intent(MenuActivity.this, CreateInterfaceActivity.class);
                        startActivity(goToCreateInterface);
                        break;
                }
            }
        });
    }
}

