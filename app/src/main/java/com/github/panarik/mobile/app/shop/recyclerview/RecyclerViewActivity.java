package com.github.panarik.mobile.app.shop.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.panarik.mobile.app.shop.R;

import android.os.Bundle;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView; //переменная для связывания разметки с java кодом
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager; //управление расположением элементов recyclerView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        ArrayList<RecyclerViewItem> recyclerViewItems = new ArrayList<>();
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_satisfied_black_24dp, "Happy", "Life is fun"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_neutral_black_24dp, "Normal", "Life is life"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_dissatisfied_black_24dp, "Sad", "Life is sad"));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);     //для улучшения производительности задаем количество строк
        adapter = new RecyclerViewAdapter(recyclerViewItems);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

    }
}
