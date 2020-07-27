package com.github.panarik.smartFeatures.activity;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.view.View;

import com.github.panarik.smartFeatures.R;
import com.github.panarik.smartFeatures.data.landscape.LandscapeOneFragment;
import com.github.panarik.smartFeatures.data.landscape.LandscapeTwoFragment;

public class LandscapeActivity extends FragmentActivity {

    //создаём фрагменты
    private LandscapeOneFragment oneFragment;
    private LandscapeTwoFragment twoFragment;

    //для подгрузки фрагментов
    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landscape);

        //инициализируем фрагменты
        oneFragment = new LandscapeOneFragment();
        twoFragment = new LandscapeTwoFragment();

        //инициализируем manager
        manager = getSupportFragmentManager();
    }


    //по нажатию кнопки "Добавить"
    public void addFragment(View view) {
        //получаем транзакции с manager, который предоставляет транзакции
        transaction = manager.beginTransaction();

        //выбираем из нескольких кнопок
        switch (view.getId()) //получаем на вход id кнопки
        {
            case R.id.landscape_addButton :
                //добавляем фрагмент
                transaction.add(R.id.landscape_containerLayout, //контейнер, куда будем добавлять фрагменты
                        oneFragment); //передаём фрагмент
                break;
        }

        //транзакции -> manager -> в контейнер -> в layout
        transaction.commit();
    }
}