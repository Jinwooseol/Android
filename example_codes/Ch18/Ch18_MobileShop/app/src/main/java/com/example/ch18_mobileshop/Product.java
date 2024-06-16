package com.example.ch18_mobileshop;

import java.io.Serializable;

public class Product implements Serializable {
    private int id, price, imageResId;
    private String name, description;

    public Product(int id, String name, int price, String description, int imageResId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageResId = imageResId;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getImageResId() {
        return imageResId;
    }
    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }
}
