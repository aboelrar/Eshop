package com.example.lenovo.eshop.presenter;

public class productList {
    String title,price,discount,id;
    int image;
    boolean isFavourite=false;
    boolean AddToCart=false;



    public productList(boolean isFavourite,boolean AddToCart) {
        this.isFavourite = isFavourite;
        this.AddToCart=AddToCart;
    }

    public productList(String id, String title, String price, int image, String discount) {
        this.title = title;
        this.price = price;
        this.image = image;
        this.discount=discount;
        this.id=id;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
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
