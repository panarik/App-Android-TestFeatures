package com.github.panarik.smartFeatures.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.github.panarik.smartFeatures.app.shop.R;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> arrayList;
    int listSize;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = findViewById(R.id.listView);

        arrayList = new ArrayList();
        arrayList.add("Первый");
        arrayList.add("Второй");
        arrayList.add("Третий");

        listSize = arrayList.size();
        Log.d("listSize", "" + listSize);

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /* parent.setVisibility(View.GONE); */  // действие к всему листу
                /* view.setVisibility(View.GONE); */  // действие к конкретному view в листе

                int indexListView = position;
                int numberOfPosition = indexListView + 1;
                String nameObjectList = arrayList.get(indexListView);
                Toast.makeText(ListViewActivity.this, "номер " + numberOfPosition + " - " + nameObjectList, Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void GoToRecycler(View view) {
        Intent RecyclerViewActivity = new Intent(ListViewActivity.this, com.github.panarik.smartFeatures.activity.RecyclerViewActivity.class);
        startActivity(RecyclerViewActivity);
    }
}
