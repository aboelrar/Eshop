package com.example.lenovo.eshop.model;

import com.example.lenovo.eshop.R;
import com.example.lenovo.eshop.interfaces.contract;
import com.example.lenovo.eshop.list.categoryList;

import java.util.ArrayList;

public class modelCategory implements contract.interfaces.Model {
    @Override
    public ArrayList getdata() {
        ArrayList<categoryList>arraylist=new ArrayList<categoryList>();
        arraylist.add(new categoryList(R.drawable.shoescover,"sneekers"));
        arraylist.add(new categoryList(R.drawable.basketball,"BasketBall Shoes"));
        arraylist.add(new categoryList(R.drawable.runningshoes,"Running Shoes"));
        arraylist.add(new categoryList(R.drawable.footballshoes,"Football Shoes"));
        return arraylist;
    }
}
