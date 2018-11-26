package com.example.lenovo.eshop.model;

import com.example.lenovo.eshop.interfaces.contract;
import com.example.lenovo.eshop.interfaces.signupinterface;

import java.util.ArrayList;

public class modelcountry implements signupinterface.interfaces.Model {


    @Override
    public ArrayList getCountrydata() {
        ArrayList<String>arrayList=new ArrayList<String>();
        arrayList.add("Egypt");
        arrayList.add("Qatar");
        arrayList.add("Suadi Arabia");
        arrayList.add("Italy");
        arrayList.add("Egypt");

        return arrayList;
    }

    @Override
    public ArrayList getGenderdata() {
        ArrayList<String>arrayList=new ArrayList<String>();
        arrayList.add("Male");
        arrayList.add("Female");
        return arrayList;
    }
}
