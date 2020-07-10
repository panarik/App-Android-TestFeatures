package com.github.panarik.smartFeatures.data.products;

public class RecyclerProductItem {

    private int productImageResource;
    private String productNameTextView;
    private String productDescriptionTextView;
    private String productTechnologyTextView;


    public RecyclerProductItem(int productImageResource, String productNameTextView, String productDescriptionTextView, String productTechnologyTextView) {
        this.productImageResource = productImageResource;
        this.productNameTextView = productNameTextView;
        this.productDescriptionTextView = productDescriptionTextView;
    }

    public int getProductImageResource() {
        return productImageResource;
    }

    public String getProductNameTextView() {
        return productNameTextView;
    }

    public String getProductDescriptionTextView() {
        return productDescriptionTextView;
    }

    public String getProductTechnologyTextView() {
        return productTechnologyTextView;
    }
}
