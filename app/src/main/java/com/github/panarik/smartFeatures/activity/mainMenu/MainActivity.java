package com.github.panarik.smartFeatures.activity.mainMenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.panarik.smartFeatures.R;
import com.github.panarik.smartFeatures.activity.SignInActivity;
import com.github.panarik.smartFeatures.activity.mainMenu.model.MenuHolder;
import com.github.panarik.smartFeatures.activity.mainMenu.model.RecyclerViewAdapter;
import com.google.firebase.auth.FirebaseAuth;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.RecyclerItemListener {

    private RecyclerView recyclerView; //переменная для связывания разметки с java кодом
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager; //управление расположением элементов recyclerView

    //поля для перехода данных из SignInActivity посредством интента и передачи в другие активити
    private String userName;

    private final String TAG = "onItemClick";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //получаем userName из SignInActivity
        Intent intent = getIntent();
        if (intent != null) {
            userName = intent.getStringExtra("userName");
            Log.d("goToMainActivity", "userName = " + userName);
        } else {
            userName = "Default User";
        }

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true); //для улучшения производительности задаем количество строк
        adapter = new RecyclerViewAdapter(MenuHolder.INSTANCE.getRecyclerViewItems(), this);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void recycler_onItemClick(int position) {
        Log.d(TAG, "onNoteClick: clicked");
        startActivity(new Intent(this, MenuHolder.INSTANCE.getMenu().get(position).getActivity().getClass()));
    }


    //активация меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    //пункты меню
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.main_sign_out:
                //выйти из учетной записи
                FirebaseAuth.getInstance().signOut();
                //переход на экран авторизации
                Intent goToSignInActivity = new Intent(this, SignInActivity.class);
                startActivity(goToSignInActivity);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
