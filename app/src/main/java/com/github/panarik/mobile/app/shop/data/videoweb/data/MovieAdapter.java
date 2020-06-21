package com.github.panarik.mobile.app.shop.data.videoweb.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.panarik.mobile.app.shop.R;
import com.github.panarik.mobile.app.shop.data.videoweb.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private Context context;
    private ArrayList<Movie> movies;


    public MovieAdapter(Context context, ArrayList<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }


    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.
                from(context).
                inflate(R.layout.video_web_movie_item, viewGroup, false);

        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieVewHolder, int i) {

        Movie currentMovie = movies.
                get(i);

        String title = currentMovie.getTitle();
        String year = currentMovie.getYear();
        String posterUrl = currentMovie.getPosterUrl();

        movieVewHolder.titleWebMovieTextView.setText(title);
        movieVewHolder.yearWebMovieTextView.setText(year);
        Picasso.get()
                .load(posterUrl) //закружаем постер по URL posterUrl
                .fit().centerInside() //располагаем по центру загруженное изображение
                .into(movieVewHolder.posterWebMovieImageView); //куда загружаем
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


    public class MovieViewHolder extends RecyclerView.ViewHolder {

        ImageView posterWebMovieImageView;
        TextView titleWebMovieTextView;
        TextView yearWebMovieTextView;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            posterWebMovieImageView = itemView.findViewById(R.id.posterWebMovieImageView);
            titleWebMovieTextView = itemView.findViewById(R.id.titleWebMovieTextView);
            yearWebMovieTextView = itemView.findViewById(R.id.yearWebMovieTextView);
        }
    }

}
