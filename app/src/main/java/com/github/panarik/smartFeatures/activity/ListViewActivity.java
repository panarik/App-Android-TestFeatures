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

import com.github.panarik.smartFeatures.R;
import com.github.panarik.smartFeatures.activity.mainMenu.MainActivity;

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

        arrayAdapter = new ArrayAdapter(this, R.layout.listview_item, arrayList);
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

    public void goToMainActivity(View view) {
        Intent goToMainActivity = new Intent(this, MainActivity.class);
        startActivity(goToMainActivity);
    }

}
