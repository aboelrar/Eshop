package com.example.lenovo.eshop.list;

public class cartList {
    int cartImage;
    String Title,num;

    public cartList(int cartImage, String title,String num) {
        this.cartImage = cartImage;
        Title = title;
        this.num=num;
    }

    public int getCartImage() {
        return cartImage;
    }

    public void setCartImage(int cartImage) {
        this.cartImage = cartImage;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
