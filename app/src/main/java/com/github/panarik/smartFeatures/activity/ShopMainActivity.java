package com.github.panarik.smartFeatures.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.github.panarik.smartFeatures.data.Order;
import com.github.panarik.smartFeatures.app.shop.R;

import java.util.ArrayList;
import java.util.HashMap;

public class ShopMainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener { /*имплиментируем возможность данного метода сушать действя (клики) пользователей и реагировать на них
        далее IDEA сама предложит добавить два метода
*/
    int quantity = 0; //количество товара
    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;
    HashMap goodsMap; //БД доваров
    String goodsName; //наименование Товара
    double price; // цена Товара
    EditText userNameEditText; //ввод данных об имене пользователя.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createSpinner();
        createGoodsMap();

        userNameEditText = findViewById(R.id.editText); //привязываем переменную ввода имени с соотв полем разметки
    }


    void createGoodsMap() {
        goodsMap = new HashMap();
        goodsMap.put("Интерьер - 3мм", 700.00); // все значения пишим в формате дабл, поскольку выходное извлекаемое по ключу значение тоже нужно нам в формате дабл
        goodsMap.put("Интерьер - 4мм", 500.00);
        goodsMap.put("Фасад - 10мм", 400.00);
        goodsMap.put("Фасад - 20мм", 300.00);
    }


    void createSpinner() {  //создаём отдельный метод для всех операций со спинером
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
    }


    public void increaseQuantity(View view) {
        TextView setTextView1 = findViewById(R.id.textView5);
        quantity = quantity + 1;
        if (quantity > 9) {
            quantity = 9;
        }
        setTextView1.setText("" + quantity);
        TextView priceTexView = findViewById(R.id.textView4); //объявляем переменную типа TextView привязываем её к ID блока разметки на экране.
        priceTexView.setText("" + quantity * price + " $");// устанавливаем содержимое переменной с помощью метода setText. При изменении количества товара будет сразу обновляться его цена.
    }


    public void decreaseQuantity(View view) {
        TextView setTextView1 = findViewById(R.id.textView5);
        quantity = quantity - 1;
        if (quantity < 0) {
            quantity = 0;
        }
        setTextView1.setText("" + quantity);
        TextView priceTexView = findViewById(R.id.textView4); //объявляем переменную типа TextView привязываем её к ID блока разметки на экране.
        priceTexView.setText("" + quantity * price + " $");// устанавливаем содержимое переменной с помощью метода setText. При изменении количества товара будет сразу обновляться его цена.
    }



    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) { // метод. Код в методе будет выполняться, когда какой-то эелемент выбран.
        goodsName = spinner.getSelectedItem().toString(); // значение переменной goodsName которое выбранно в спиннере в данный момент
        price = (double) goodsMap.get(goodsName); // переменная с ценой будет получать текущее значение переменной с ценой товара в массиве исходя из выбраного в спиннере товара)
        TextView priceTexView = findViewById(R.id.textView4); //объявляем переменную типа TextView привязываем её к ID блока разметки на экране
        priceTexView.setText("" + quantity * price + " $");// устанавливаем содержимое переменной с помощью метода setText
        ImageView goodsImageView = findViewById(R.id.goodsImageView); //объявляем переменную изображения Товара и привязываем её к соотв полю в разметке.
        switch (goodsName) {
            case "Интерьер - 3мм":
                goodsImageView.setImageResource(R.drawable.led_3mm);
                break;
            case "Интерьер - 4мм":
                goodsImageView.setImageResource(R.drawable.led_4mm);
                break;
            case "Фасад - 10мм":
                goodsImageView.setImageResource(R.drawable.mediafacade_10mm);
                break;
            case "Фасад - 20мм":
                goodsImageView.setImageResource(R.drawable.mediafacade_20mm);
                break;
            default:
                goodsImageView.setImageResource(R.drawable.led_3mm);
                break;
        }
    }


    public void onNothingSelected(AdapterView<?> parent) {
    }


    public void addToCart(View view) {

        Order order = new Order(); // создаём объект order класса Order
        order.userName = userNameEditText.getText().toString(); // присваиваем свойству объекта order значение выбранное пользователем в переменной userNameEditText
        Log.d("Order " + order.userName, order.userName); //выводим в лог название товара выбранное пользователем
        order.goodsName = goodsName;
        Log.d("Order " + order.userName, order.goodsName);
        order.quantity = quantity;
        Log.d("Order " + order.userName, "" + order.quantity);
        order.orderPrice = quantity * price;
        Log.d("Order " + order.userName, "" + order.orderPrice);

        Intent orderIntent = new Intent(ShopMainActivity.this, ShopOrderActivity.class); //Интент переносит данные отсюда (из класса MainActivity) в класс OrderActivity
        orderIntent.putExtra("userNameForIntent",order.userName); // записываем в значение order.userName в интент переменную orderIntent и задаём ключ userNameForIntent для записанного значения
        orderIntent.putExtra("goodsNameForIntent",order.goodsName);
        orderIntent.putExtra("quantityForIntent",order.quantity);
        orderIntent.putExtra("orderPriceForIntent",order.orderPrice);
        startActivity(orderIntent);

    }

    public void freeGame(View view) {
        Order order = new Order();
        order.userName = userNameEditText.getText().toString();
        order.goodsName = goodsName;
        order.quantity = quantity;
        order.orderPrice = quantity * price;

        Intent freeGameIntent = new Intent(ShopMainActivity.this, FreeGameActivity.class);
        freeGameIntent.putExtra("userNameForIntent",order.userName);
        freeGameIntent.putExtra("goodsNameForIntent",order.goodsName);
        freeGameIntent.putExtra("quantityForIntent",order.quantity);
        freeGameIntent.putExtra("orderPriceForIntent",order.orderPrice);
        startActivity(freeGameIntent);
    }
}
