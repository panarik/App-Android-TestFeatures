package com.github.panarik.smartFeatures.data.products;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.github.panarik.smartFeatures.R;

import java.util.ArrayList;

import static com.github.panarik.smartFeatures.data.products.Utils.ProductDescription_digital_totem;
import static com.github.panarik.smartFeatures.data.products.Utils.ProductDescription_ipoint;
import static com.github.panarik.smartFeatures.data.products.Utils.ProductDescription_iwall;
import static com.github.panarik.smartFeatures.data.products.Utils.ProductDescription_navigation;
import static com.github.panarik.smartFeatures.data.products.Utils.ProductDescription_navigation_totem;
import static com.github.panarik.smartFeatures.data.products.Utils.ProductDescription_navigation_totem_2;
import static com.github.panarik.smartFeatures.data.products.Utils.ProductName_digital_totem;
import static com.github.panarik.smartFeatures.data.products.Utils.ProductName_ipoint;
import static com.github.panarik.smartFeatures.data.products.Utils.ProductName_iwall;
import static com.github.panarik.smartFeatures.data.products.Utils.ProductName_navigation;
import static com.github.panarik.smartFeatures.data.products.Utils.ProductName_navigation_totem;
import static com.github.panarik.smartFeatures.data.products.Utils.ProductName_navigation_totem_2;
import static com.github.panarik.smartFeatures.data.products.Utils.ProductTechnology_digital_totem;
import static com.github.panarik.smartFeatures.data.products.Utils.ProductTechnology_ipoint;
import static com.github.panarik.smartFeatures.data.products.Utils.ProductTechnology_iwall;
import static com.github.panarik.smartFeatures.data.products.Utils.ProductTechnology_navigation;
import static com.github.panarik.smartFeatures.data.products.Utils.ProductTechnology_navigation_totem;
import static com.github.panarik.smartFeatures.data.products.Utils.ProductTechnology_navigation_totem_2;

public class RecyclerProductViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_product_view);

        /*
        ArrayList<RecyclerProductItem> productItems = new ArrayList<>();
        productItems.add(new RecyclerProductItem(R.drawable.product_digital_totem, ProductName_digital_totem, ProductDescription_digital_totem, ProductTechnology_digital_totem));
        productItems.add(new RecyclerProductItem(R.drawable.product_navigation_totem, ProductName_navigation_totem, ProductDescription_navigation_totem, ProductTechnology_navigation_totem));
        productItems.add(new RecyclerProductItem(R.drawable.product_navigation_totem_2, ProductName_navigation_totem_2, ProductDescription_navigation_totem_2, ProductTechnology_navigation_totem_2));
        productItems.add(new RecyclerProductItem(R.drawable.product_ipoint, ProductName_ipoint, ProductDescription_ipoint, ProductTechnology_ipoint));
        productItems.add(new RecyclerProductItem(R.drawable.product_navigation, ProductName_navigation, ProductDescription_navigation, ProductTechnology_navigation));
        productItems.add(new RecyclerProductItem(R.drawable.product_iwall, ProductName_iwall, ProductDescription_iwall, ProductTechnology_iwall));
    */
    }

}
