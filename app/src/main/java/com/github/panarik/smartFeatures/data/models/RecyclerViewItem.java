package com.github.panarik.smartFeatures.data.models;

public class RecyclerViewItem {

    private int imageResource; //доступ к изображениям в папке drawable
    private String text1;
    private String text2;

    public RecyclerViewItem(int imageResource, String text1, String text2) { //создаём конструктор с полями
        this.imageResource = imageResource;
        this.text1 = text1;
        this.text2 = text2;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getText1(){
        return text1;
    }

    public String getText2(){
        return text2;
    }




}
