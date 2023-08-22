package com.github.panarik.smartFeatures.activity.mainMenu.model;

public class RecyclerViewItem {

    private int imageResource; //доступ к изображениям в папке drawable
    private String name;
    private String desc;

    public RecyclerViewItem(String name, String desc, int imageResource) { //создаём конструктор с полями
        this.name = name;
        this.desc = desc;
        this.imageResource = imageResource;
    }

    public String getName(){
        return name;
    }

    public String getDesc(){
        return desc;
    }

    public int getImageResource() {
        return imageResource;
    }




}
