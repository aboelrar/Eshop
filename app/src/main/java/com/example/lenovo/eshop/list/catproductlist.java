package com.example.lenovo.eshop.list;

public class catproductlist {
    String name,price;
    int image;
    boolean isFavourite=false;
    boolean AddToCart=false;

    public catproductlist(boolean isFavourite, boolean addToCart) {
        this.isFavourite = isFavourite;
        AddToCart = addToCart;
    }

    public catproductlist(String name, String price, int image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public boolean isAddToCart() {
        return AddToCart;
    }

    public void setAddToCart(boolean addToCart) {
        AddToCart = addToCart;
    }
}
