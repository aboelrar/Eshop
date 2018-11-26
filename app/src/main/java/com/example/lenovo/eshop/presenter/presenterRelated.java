package com.example.lenovo.eshop.presenter;

import com.example.lenovo.eshop.interfaces.contract;
import com.example.lenovo.eshop.model.modelProduct;

import java.util.ArrayList;

public class presenterRelated implements contract.interfaces.presenter {
    private contract.interfaces.Model model;
    private contract.interfaces.View views;

    public presenterRelated(contract.interfaces.View view) {
        this.views = view;
        initPresenter();
    }
    private void initPresenter() {
        model = new modelProduct();
        views.element();
    }
    @Override
    public void getData() {
        ArrayList data=model.getdata();
        views.setviewdata(data);

    }


}