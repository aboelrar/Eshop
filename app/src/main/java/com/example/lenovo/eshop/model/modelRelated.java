package com.example.lenovo.eshop.model;

import com.example.lenovo.eshop.R;
import com.example.lenovo.eshop.interfaces.contract;
import com.example.lenovo.eshop.presenter.productList;

import java.util.ArrayList;

public class modelRelated implements contract.interfaces.Model{
        @Override
        public ArrayList getdata() {
            ArrayList<productList>arrayList=new ArrayList<productList>();
            arrayList.add(new productList("1","white shoes discount 20% hurry white shoes discount 20% hurry white shoes discount 20% hurry ","1000 LE", R.drawable.pravo,"20%"));
            arrayList.add(new productList("2","white shoes","1000 LE", R.drawable.addidos,"30%"));
            arrayList.add(new productList("3","white shoes","1000 LE", R.drawable.smart,""));
            arrayList.add(new productList("4","white shoes","1000 LE", R.drawable.nike,"40%"));
            return arrayList;
        }
    }

