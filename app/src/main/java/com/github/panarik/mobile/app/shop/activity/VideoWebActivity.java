package com.github.panarik.mobile.app.shop.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.github.panarik.mobile.app.shop.R;
import com.github.panarik.mobile.app.shop.data.videoweb.data.MovieAdapter;
import com.github.panarik.mobile.app.shop.data.videoweb.model.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class VideoWebActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;
    private ArrayList<Movie> movies;
    private RequestQueue requestQueue;

    EditText editNameMovie;
    String textNameMovie;
    Button buttonSearchMovie;


    //переопределяем кнопку "Назад"
    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        openQuitDialog();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setUp recycler view
        setContentView(R.layout.activity_video_web);
        recyclerView = findViewById(R.id.videoWebView);
        recyclerView.hasFixedSize();

        //search movie
        editNameMovie = (EditText) findViewById(R.id.editNameMovie);


    }


    private void getMovies() {

        String url = "http://www.omdbapi.com/?apikey=e44ad19e&s=" + textNameMovie;

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET, //выбираем тип запроса
                url, //URL запроса
                null,

                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) { //распознаем JSON объекты
                        try {
                            JSONArray jsonArray = response.getJSONArray("Search"); //находим массив Search из бека
                            for (int i = 0; i < jsonArray.length(); i++) {   //итерация для всех объектов в массиве
                                JSONObject jsonObject = jsonArray.getJSONObject(i); //получаем JSON объекты из массива

                                //получаем свойства каждого объекта из массива
                                String title = jsonObject.getString("Title");
                                String year = jsonObject.getString("Year");
                                String posterUrl = jsonObject.getString("Poster");

                                Movie movie = new Movie();
                                movie.setTitle(title);
                                movie.setYear(year);
                                movie.setPosterUrl(posterUrl);

                                //Добавляем полученные объекты в ArrayList recyclerView
                                movies.add(movie);
                            }

                            //инициализируем адаптер
                            movieAdapter = new MovieAdapter(VideoWebActivity.this, movies);
                            recyclerView.setAdapter(movieAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace(); //если придет ошибка из бека
                    }
                });
        requestQueue.add(request);
    }


    public void toPlayingAudio(View view) {
        Intent PlayingAudioActivity = new Intent(VideoWebActivity.this, PlayingAudioActivity.class);
        startActivity(PlayingAudioActivity);
    }

    public void toSearchMovie(View view) {
        //new objects
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        movies = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(this);

        textNameMovie = editNameMovie.getText().toString();
        Toast.makeText(getApplicationContext(), editNameMovie.getText(), Toast.LENGTH_SHORT)
                .show();

        getMovies();
    }




    private void openQuitDialog() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(
                VideoWebActivity.this);
        quitDialog.setTitle("Уже уходишь?");

        quitDialog.setPositiveButton("Таки да!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                finish();
            }
        });

        quitDialog.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
            }
        });

        quitDialog.show();
    }
}
