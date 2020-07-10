package com.github.panarik.smartFeatures.data.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.panarik.smartFeatures.app.shop.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewViewHolder> {

    private ArrayList<RecyclerViewItem> arrayList;
    //добавили в рамках интеграции RecyclerItemListener
    private RecyclerItemListener mRecyclerItemListener;

    public static class RecyclerViewViewHolder extends RecyclerView.ViewHolder //содержит элементы, которые находятся в RecyclerView
            implements View.OnClickListener { //также добавляем OnClickListener для прослушивания RecyclerView

        public ImageView imageView;
        public TextView textView1;
        public TextView textView2;

        //добавляем объект существующего OnClickListener
        RecyclerItemListener recyclerItemListener;

        public RecyclerViewViewHolder(@NonNull View itemView, //конструктор с параметром itemView
                                      RecyclerItemListener recyclerItemListener) { //добавляем recyclerItemListener
            super(itemView);
            imageView = itemView.findViewById(R.id.RecyclerImageView);
            textView1 = itemView.findViewById(R.id.RecyclerTextView1);
            textView2 = itemView.findViewById(R.id.RecyclerTextView2);
            //инициализируем recyclerItemListener
            this.recyclerItemListener = recyclerItemListener;

            //прикрепляем OnClickListener
            itemView.setOnClickListener(this);

        }

        //
        @Override
        public void onClick(View v) {
            recyclerItemListener.recycler_onItemClick(getAdapterPosition());
        }
    }

    // инициализируем поле arrayList и передаем в него данные из ArrayList в RecyclerViewAdapter
    public RecyclerViewAdapter(ArrayList<RecyclerViewItem> arrayList,
                               RecyclerItemListener recyclerItemListener //добавили recyclerItemListener
    ) {
        this.arrayList = arrayList;
        this.mRecyclerItemListener = recyclerItemListener;

    }


    @NonNull
    @Override
    public RecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {  //передаём разметку в адаптер из recycler_view_item
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_item, viewGroup, false);
        RecyclerViewViewHolder recyclerViewViewHolder = new RecyclerViewViewHolder(view, mRecyclerItemListener);
        return recyclerViewViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewViewHolder recyclerViewViewHolder, int i) { //передаем из поля arrayList все его значения
        RecyclerViewItem recyclerViewItem = arrayList.get(i); //при помощи параметра i связываем каждый элемент поля arrayList с каждым элементом RecyclerView
        recyclerViewViewHolder.imageView.setImageResource(recyclerViewItem.getImageResource()); //путь к данным извлекаем из recyclerViewItem с помощью геттера getImageResource
        recyclerViewViewHolder.textView1.setText(recyclerViewItem.getText1());
        recyclerViewViewHolder.textView2.setText(recyclerViewItem.getText2());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public interface RecyclerItemListener {
        void recycler_onItemClick(int position);
    }


}
