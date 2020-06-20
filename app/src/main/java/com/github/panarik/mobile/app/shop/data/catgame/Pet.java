package com.github.panarik.mobile.app.shop.data.catgame;

import android.util.Log;

public class Pet extends Animal {

    // Вариант №1
    int age;
    String name;
    //конец №1

    // Вариант №2
    public void initFields(int a, String n) {
        age = a;
        name = n;
    } //конец №2

    //Вариант №3 (конструктор)
    public Pet() {
        age = 10;
        name = "Murka";
    } //конец №3

    //Вариант №4 (конструктор)
    public Pet(int a, String n){
        age = a;
        name = n;
    } //конец №4

    //Вариант №5 (конструктор)
    public Pet(int age, String name, int skills){
        this.age = age;
        this.name = name;
    }
    //конец №5

    public void talk() {

        Log.d("talk()", "Meow! My name is " + name + ", and I'm " + age + " years old.");
    }

}
