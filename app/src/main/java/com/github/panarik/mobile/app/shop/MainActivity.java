package com.github.panarik.mobile.app.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener { /*имплиментируем возможность данного метода сушать действя (клики) пользователей и реагировать на них
        далее IDEA сама предложит добавить два метода
*/
    int quantity = 0;
    Spinner spinner; //переменная класса Spinner и названием spinner
    ArrayList spinnerArrayList; //переменная класса ArrayList
    ArrayAdapter spinnerAdapter; //создаём переменную класса ArrayAdapter
    HashMap goodsMap; // создаём переменную класа HashMap для обозначения...
    String goodsName; //создаём переменную класса String с наименованием Товара
    double price; // переменная типа дабл, которая будет отображать цену Товара


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this); /*реакция на действия пользоваитея в спиннере.
        Имплементировали интерфейс котороый позволяет прослушивать событие выбора пользователем значения в спиннере.
        Мы открываем такую возможность в описании текущего класса и также привязываем его к определённому методу в классе.
        */
        spinnerArrayList = new ArrayList();
        spinnerArrayList.add("Интерьер - 3мм");
        spinnerArrayList.add("Интерьер - 4мм");
        spinnerArrayList.add("Фасад - 10мм");
        spinnerArrayList.add("Фасад - 20мм");

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
            /*создаём объект этой перемменой и присваиваем ей параметры:
                context - этот класс,
                android.R.layout.simple_spinner_item - передаём предопределённый в андроид элемент спиннера
                spinnerArrayList - передаём array лист
            */
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // создаём выпадающий список для спиннера
        spinner.setAdapter(spinnerAdapter);//устанавливаем данный адаптер для текущего спиннера

        goodsMap = new HashMap();
        goodsMap.put("Интерьер - 3мм", 700.00); // все значения пишим в формате дабл, поскольку выходное извлекаемое по ключу значение тоже нужно нам в формате дабл
        goodsMap.put("Интерьер - 4мм", 500.00);
        goodsMap.put("Фасад - 10мм", 400.00);
        goodsMap.put("Фасад - 20мм", 300.00);

    }


    public void increaseQuantity(View view) {
        TextView setTextView1 = findViewById(R.id.textView5);
        quantity = quantity + 1;
        if (quantity > 9) {
            quantity = 9;
        }
        setTextView1.setText("" + quantity);
        TextView priceTexView = findViewById(R.id.textView4); //объявляем переменную типа TextView привязываем её к ID блока разметки на экране.
        priceTexView.setText("" + quantity * price);// устанавливаем содержимое переменной с помощью метода setText. При изменении количества товара будет сразу обновляться его цена.
    }

    public void decreaseQuantity(View view) {
        TextView setTextView1 = findViewById(R.id.textView5);
        quantity = quantity - 1;
        if (quantity < 0) {
            quantity = 0;
        }
        setTextView1.setText("" + quantity);
        TextView priceTexView = findViewById(R.id.textView4); //объявляем переменную типа TextView привязываем её к ID блока разметки на экране.
        priceTexView.setText("" + quantity * price);// устанавливаем содержимое переменной с помощью метода setText. При изменении количества товара будет сразу обновляться его цена.

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) { // метод. Код в методе будет выполняться, когда какой-то эелемент выбран.
        goodsName = spinner.getSelectedItem().toString(); // значение переменной goodsName которое выбранно в спиннере в данный момент
        price = (double) goodsMap.get(goodsName); // переменная с ценой будет получать текущее значение переменной с ценой товара в массиве исходя из выбраного в спиннере товара)
        TextView priceTexView = findViewById(R.id.textView4); //объявляем переменную типа TextView привязываем её к ID блока разметки на экране
        priceTexView.setText("" + quantity * price);// устанавливаем содержимое переменной с помощью метода setText

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
