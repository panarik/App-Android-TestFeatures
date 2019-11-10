package com.github.panarik.mobile.app.shop.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.github.panarik.mobile.app.shop.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewViewHolder> {


    public static class RecyclerViewViewHolder extends RecyclerView.ViewHolder { //содержит элементы, которые находятся в RecyclerView

        public ImageView imageView;
        public TextView textView1;
        public TextView textView2;

        public RecyclerViewViewHolder(@NonNull View itemView) { //конструктор с параметром itemView
            super(itemView);
            imageView = itemView.findViewById(R.id.RecyclerImageView);
            textView1 = itemView.findViewById(R.id.RecyclerTextView1);
            textView2 = itemView.findViewById(R.id.RecyclerTextView2);
        }
    }


    @NonNull
    @Override
    public RecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {  //передаём разметку в адаптер из recycler_view_item
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_item, viewGroup, false);
        RecyclerViewViewHolder recyclerViewViewHolder = new RecyclerViewViewHolder(view);
        return recyclerViewViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
