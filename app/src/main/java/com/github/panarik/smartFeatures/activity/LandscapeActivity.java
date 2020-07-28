package com.github.panarik.smartFeatures.activity;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

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

    //свитчер переключения кнопки "Back"
    private Switch toPreviousFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landscape);

        //инициализируем фрагменты
        oneFragment = new LandscapeOneFragment();
        twoFragment = new LandscapeTwoFragment();

        //инициализируем manager
        manager = getSupportFragmentManager();

        toPreviousFragment = findViewById(R.id.toPreviousFragment);

    }


    //по нажатию кнопок
    public void onClickOperateFragment(View view) {
        //получаем транзакции с manager, который предоставляет транзакции
        transaction = manager.beginTransaction();

        //выбираем из нескольких кнопок
        switch (view.getId()) //получаем на вход id кнопки
        {
            //добавляем фрагмент
            case R.id.landscape_addButton:

                //если нет первого фрагмента
                if (manager.findFragmentByTag //проверка повторного добавления фрагмента
                        (LandscapeOneFragment.landscapeFragmentTAG) == null) //если == null, то фрагмент ранее не добавлялся
                {
                    transaction.add(R.id.landscape_containerLayout, //контейнер, куда будем добавлять фрагменты
                            oneFragment, //передаём фрагмент
                            LandscapeOneFragment.landscapeFragmentTAG); //передаем тег каждого фрагмента для их различия
                }

            //удаляем фрагмент
            case R.id.landscape_removeButton:
                //если есть первый фрагмент
                if (manager.findFragmentByTag(LandscapeOneFragment.landscapeFragmentTAG) != null) {
                    transaction.remove(oneFragment);
                }
                //если есть второй фрагмент
                if (manager.findFragmentByTag(LandscapeTwoFragment.landscapeFragmentTAG) != null) {
                    transaction.remove(twoFragment);
                }
                break;

            //заменаяем фрагмент
            case R.id.landscape_replaceButton: {
                //если есть первый фрагмент
                if (manager.findFragmentByTag(LandscapeOneFragment.landscapeFragmentTAG) != null) {
                    transaction.replace(R.id.landscape_containerLayout,
                            twoFragment, //меняем на второй фрагмент
                            LandscapeTwoFragment.landscapeFragmentTAG);
                }
                //если есть второй фрагмент
                if (manager.findFragmentByTag(LandscapeTwoFragment.landscapeFragmentTAG) != null) {
                    transaction.replace(R.id.landscape_containerLayout,
                            oneFragment, //меняем на первый фрагмент
                            LandscapeOneFragment.landscapeFragmentTAG);
                }
            }

        }


        //свитчер возвращает предыдущий Fragment
        if (toPreviousFragment.isChecked()) {
            transaction.addToBackStack(null);
        }


        //транзакции -> manager -> в контейнер -> в layout
        transaction.commit();
    }
}