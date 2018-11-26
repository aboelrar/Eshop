package com.example.lenovo.eshop.expand;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by admin on 02/05/2018.
 */

public class expandlist extends ExpandableGroup {
    int id;
    String title;
    int img;

    public expandlist(String title, List items,int img) {
        super(title, items);
        this.img=img;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
