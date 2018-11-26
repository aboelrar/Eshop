package com.example.lenovo.eshop.model;

import com.example.lenovo.eshop.R;
import com.example.lenovo.eshop.interfaces.contract;
import com.example.lenovo.eshop.list.cartList;

import java.util.ArrayList;

public class modelCart implements contract.interfaces.Model {
    @Override
    public ArrayList getdata() {
        ArrayList<cartList>arrayList=new ArrayList<cartList>();
        arrayList.add(new cartList(R.drawable.addidos,"Addidas Shoes","1"));
        arrayList.add(new cartList(R.drawable.nike,"Nike Shoes","1"));
        return arrayList;
    }
}
