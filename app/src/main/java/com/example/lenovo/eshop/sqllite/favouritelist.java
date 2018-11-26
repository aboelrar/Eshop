package com.example.lenovo.eshop.sqllite;

public class favouritelist {
    private int id;
    private byte[] image;
    private String title;
    private String price;

    public favouritelist(int id, byte[] image, String title, String price) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

