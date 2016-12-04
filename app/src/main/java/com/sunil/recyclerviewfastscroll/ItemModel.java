package com.sunil.recyclerviewfastscroll;

/**
 * Created by kuliza-195 on 12/3/16.
 */

public class ItemModel {

    private String name;
    private String imagePath;

    public ItemModel(){

    }

    public ItemModel(String name, String imagePath) {
        this.name = name;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}