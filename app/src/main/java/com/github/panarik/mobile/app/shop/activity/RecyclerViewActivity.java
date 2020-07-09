package com.github.panarik.mobile.app.shop.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.panarik.mobile.app.shop.R;
import com.github.panarik.mobile.app.shop.data.products.RecyclerProductViewActivity;
import com.github.panarik.mobile.app.shop.data.recyclerview.RecyclerViewAdapter;
import com.github.panarik.mobile.app.shop.data.recyclerview.RecyclerViewItem;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity implements RecyclerViewAdapter.RecyclerItemListener {

    private RecyclerView recyclerView; //переменная для связывания разметки с java кодом
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager; //управление расположением элементов recyclerView
    ArrayList<RecyclerViewItem> recyclerViewItems;

    private final String TAG = "onItemClick";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerViewItems = new ArrayList<>();
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_satisfied_black_24dp, "Happy", "Life is fun"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_neutral_black_24dp, "Normal", "Life is life"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_dissatisfied_black_24dp, "Sad", "Life is sad"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_satisfied_black_24dp, "Happy", "Life is fun"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_neutral_black_24dp, "Normal", "Life is life"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_dissatisfied_black_24dp, "Sad", "Life is sad"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_satisfied_black_24dp, "Happy", "Life is fun"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_neutral_black_24dp, "Normal", "Life is life"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_dissatisfied_black_24dp, "Sad", "Life is sad"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_satisfied_black_24dp, "Happy", "Life is fun"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_neutral_black_24dp, "Normal", "Life is life"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_dissatisfied_black_24dp, "Sad", "Life is sad"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_satisfied_black_24dp, "Happy", "Life is fun"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_neutral_black_24dp, "Normal", "Life is life"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_dissatisfied_black_24dp, "Sad", "Life is sad"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_satisfied_black_24dp, "Happy", "Life is fun"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_neutral_black_24dp, "Normal", "Life is life"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_dissatisfied_black_24dp, "Sad", "Life is sad"));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);     //для улучшения производительности задаем количество строк
        adapter = new RecyclerViewAdapter(recyclerViewItems,
                this //добавили listener
        );
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

    }

    public void goToChat(View view) {
        Intent goToChatActivity = new Intent(RecyclerViewActivity.this, SignInActivity.class);
        startActivity(goToChatActivity);
    }


    //метод для клика по recyclerview item
    @Override
    public void recycler_onItemClick(int position) {

        Log.d(TAG, "onNoteClick: clicked");

        //переход в активити по клику
        Intent intent = new Intent(this, SomeActivity.class);
        intent.putExtra("some_object", "something else");
        startActivity(intent);

        /*
        //используем текущий ArrayList
        recyclerViewItems.get(position);
        //при вызове переход на новое активити
        Intent intent = new Intent(this, NewActivity.class);
        startActivity(intent);

         */
    }


}
