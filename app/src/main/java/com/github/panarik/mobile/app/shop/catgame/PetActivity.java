package com.github.panarik.mobile.app.shop.catgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.panarik.mobile.app.shop.R;

public class PetActivity extends AppCompatActivity {

    Pet myPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet);

        myPet = new Pet();
        myPet.name = "Vaska";
        myPet.age = 2;
        myPet.talk();

        // Вариант №1
        Pet mursik = new Pet();
        mursik.name = "Mursik";
        mursik.age = 5;
        mursik.talk();
        // конец №1

        //Вариант №2
        Pet mashka = new Pet();
        mashka.initFields(8, "Mashka");
        mashka.talk();
        // Конец №2

        // Вариант №3
        Pet murka = new Pet();
        murka.talk();
        // Конец №3

        // Вариант №4
        Pet barsik = new Pet(12, "Barsik");
        barsik.talk();
        // Конец №4
    }
}
