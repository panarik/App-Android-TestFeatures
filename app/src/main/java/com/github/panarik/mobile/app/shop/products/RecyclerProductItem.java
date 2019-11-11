package com.github.panarik.mobile.app.shop.products;

public class RecyclerProductItem {

    private int productImageResource;
    private String productNameTextView;
    private String productDescriptionTextView;

    public RecyclerProductItem(int productImageResource, String productNameTextView, String productDescriptionTextView) {
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
}
