package com.example.lenovo.eshop.presenter;

import com.example.lenovo.eshop.interfaces.contract;
import com.example.lenovo.eshop.model.modelGender;
import com.example.lenovo.eshop.model.modelcountry;

import java.util.ArrayList;

public class presenterGender implements contract.interfaces.presenter {
    private contract.interfaces.Model model;
    private contract.interfaces.View views;


    public presenterGender(contract.interfaces.View view) {
        this.views = view;
        initPresenter();
    }
    private void initPresenter() {
        model = new modelGender();
        views.element();
    }
    @Override
    public void getData() {
        ArrayList data=model.getdata();
        views.setviewdata(data);
    }
}
