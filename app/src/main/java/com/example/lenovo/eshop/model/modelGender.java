package com.example.lenovo.eshop.model;

import com.example.lenovo.eshop.interfaces.contract;

import java.util.ArrayList;

public class modelGender implements contract.interfaces.Model {
    @Override
    public ArrayList getdata() {
        ArrayList<String>arrayList=new ArrayList<String>();
        arrayList.add("Male");
        arrayList.add("Female");
        return arrayList;
    }
}
