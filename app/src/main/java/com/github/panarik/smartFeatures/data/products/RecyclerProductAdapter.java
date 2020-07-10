package com.github.panarik.smartFeatures.data.products;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.panarik.smartFeatures.app.shop.R;

public class RecyclerProductAdapter extends RecyclerView.Adapter {


    public static class ProductViewHolder extends RecyclerView.ViewHolder {

        public ImageView productImageView;
        public TextView productNameTextView;
        public TextView productDescriptionTextView;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_product_item, viewGroup, false);
    ProductViewHolder productViewHolder = new ProductViewHolder(view);
    return productViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
