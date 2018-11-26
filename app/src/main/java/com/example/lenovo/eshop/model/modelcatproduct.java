package com.example.lenovo.eshop.model;

import com.example.lenovo.eshop.R;
import com.example.lenovo.eshop.interfaces.contract;
import com.example.lenovo.eshop.list.catproductlist;

import java.util.ArrayList;

public class modelcatproduct implements contract.interfaces.Model {
    @Override
    public ArrayList getdata() {
        ArrayList<catproductlist>arraylist=new ArrayList<catproductlist>();
        arraylist.add(new catproductlist("orange tshirt from addidas for all sizes","20$", R.drawable.tshirt));
        arraylist.add(new catproductlist("white tshirt from addidas for all sizes","30$", R.drawable.whitetshirt));
        arraylist.add(new catproductlist("blue tshirt from addidas for all sizes","20$", R.drawable.blietshirt));
        arraylist.add(new catproductlist("superman tshirt from addidas for all sizes","20$", R.drawable.superman));
        return arraylist;
    }
}
