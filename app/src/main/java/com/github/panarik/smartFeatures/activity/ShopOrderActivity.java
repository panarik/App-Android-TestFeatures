package com.github.panarik.smartFeatures.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.panarik.smartFeatures.app.shop.R;

public class ShopOrderActivity extends AppCompatActivity {

    String[] addresses = {"panarik@yandex.ru"};
    String subject = "Order from my BEST App";
    String emailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent receiveOrderIntent = getIntent(); // создаём receiveIntent и присваиваем его к Intent
        String userName = receiveOrderIntent.getStringExtra("userNameForIntent");  //извлекаем значение userName из Intent по ключу userNameForIntent и присваеваем значение переменной userName
        String goodsName = receiveOrderIntent.getStringExtra("goodsNameForIntent");
        int quantity = receiveOrderIntent.getIntExtra("quantityForIntent", 0);
        double orderPrice = receiveOrderIntent.getDoubleExtra("orderPriceForIntent",0.00);
        emailText = "Лучший покупатель - "+userName+"\n"+
                    "Выбранный товар - "+goodsName+"\n"+
                    "Количество - "+quantity+"\n"+
                    "Стоимость - "+orderPrice+"0 $";
        TextView orderTextView = findViewById(R.id.orderTextView); // создаём новый TextView и привязываем его к разметке activity_order
        orderTextView.setText(emailText); // выводим итог в orderTextView

    }

    public void addToCart(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, emailText);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}