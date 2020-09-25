package com.github.panarik.smartFeatures.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.panarik.smartFeatures.R;
import com.github.panarik.smartFeatures.data.models.RecyclerViewAdapter;
import com.github.panarik.smartFeatures.data.models.RecyclerViewItem;
import com.google.firebase.auth.FirebaseAuth;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.RecyclerItemListener {

    private RecyclerView recyclerView; //переменная для связывания разметки с java кодом
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager; //управление расположением элементов recyclerView
    ArrayList<RecyclerViewItem> recyclerViewItems;

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

        recyclerViewItems = new ArrayList<>();
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.mobile_shop_shoping, "Mobile shopping", "Insert text, spinner, quantity, sopping card, send order on email"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.chest_open_gold, "Free Game", "эффекты alpha и немного математики"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.picture_effects_plash_smoke, "Picture effects", "alpha, rotate, scale, slide effects"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.list_view_list, "List View", "пример простого списка значений"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.playing_audio_band, "Play music", "sound playing, play pause buttons, seekBar"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.video_local_video, "Local video", "video from APK, control panel, volume listener"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.video_web_movie, "Movies online", "Text and pictures from API, RecycleView, search function,"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.chat_chatlogo, "Messenger", "Firebase objects, GET Firebase realtime database data, POST messages into Firebase"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.landscape_logo, "Landscape Orientation", "Simple Fragments, orientation screen"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.web_logo, "Go To WEB!", "WebView, perform system Back button"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.taxi_logo, "You need Taxi!", "Mapping, GEO"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.bug_ui_example_logo, "UI bugs", "UI bug in View"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.recycle_logo_500x500, "RecycleView Kotlin", "Simple functional for benchmark testing"));


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);     //для улучшения производительности задаем количество строк
        adapter = new RecyclerViewAdapter(recyclerViewItems,
                this //добавили listener
        );
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

    }


    //метод для клика по models item
    @Override
    public void recycler_onItemClick(int position) {
        Log.d(TAG, "onNoteClick: clicked");

        //используем текущий ArrayList
        recyclerViewItems.get(position);

        switch (position) {
            case 0:
                //ShopMainActivity
                Intent gotoShopMainActivity = new Intent(this, ShopMainActivity.class);
                startActivity(gotoShopMainActivity);
                break;
            case 1:
                //FreeGameActivity
                Intent goToFreeGameActivity = new Intent(this, FreeGameActivity.class);
                startActivity(goToFreeGameActivity);
                break;
            case 2:
                //PictureEffectsActivity
                Intent goToPictureEffectsActivity = new Intent(this, PictureEffectsActivity.class);
                startActivity(goToPictureEffectsActivity);
                break;
            case 3:
                //ListViewActivity
                Intent goToListViewActivity = new Intent(this, ListViewActivity.class);
                startActivity(goToListViewActivity);
                break;
            case 4:
                //PlayingAudioActivity
                Intent goToPlayingAudioActivity = new Intent(this, PlayingAudioActivity.class);
                startActivity(goToPlayingAudioActivity);
                break;
            case 5:
                //VideoLocalActivity
                Intent goToVideoLocalActivity = new Intent(this, VideoLocalActivity.class);
                startActivity(goToVideoLocalActivity);
                break;
            case 6:
                //VideoWebActivity
                Intent goToVideoWebActivity = new Intent(this, VideoWebActivity.class);
                startActivity(goToVideoWebActivity);
                break;
            case 7:
                //ChatActivity
                Intent goToChatActivity = new Intent(this, UserListActivity.class);
                //забираем также текущий userName
                goToChatActivity.putExtra("userName", userName);
                startActivity(goToChatActivity);
                break;
            case 8:
                //ChatActivity
                Intent goToLandscapeActivity = new Intent(this, LandscapeActivity.class);
                goToLandscapeActivity.putExtra("userName", userName);
                startActivity(goToLandscapeActivity);
                break;
            case 9:
                //WebActivity
                Intent goToWebActivity = new Intent(this, WebActivity.class);
                goToWebActivity.putExtra("userName", userName);
                startActivity(goToWebActivity);
                break;
            case 10:
                //TaxiSplashScreenActivity
                Intent goToTaxiActivity = new Intent(this, TaxiSplashScreenActivity.class);
                goToTaxiActivity.putExtra("userName", userName);
                startActivity(goToTaxiActivity);
                break;
            case 11:
                //BugUiExampleActivity
                startActivity(new Intent(this, BugUiExampleActivity.class));
                break;
            case 12:
                //BlogKotlinActivity
                startActivity(new Intent(this, BlogKotlinActivity.class));
                break;
            default:
                Log.d(TAG, "Activity does not exist");
                Toast.makeText(this, "Activity does not exist", Toast.LENGTH_SHORT).show();
        }
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
