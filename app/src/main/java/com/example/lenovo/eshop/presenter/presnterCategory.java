package com.example.lenovo.eshop.presenter;

import com.example.lenovo.eshop.interfaces.contract;
import com.example.lenovo.eshop.model.modelCategory;
import com.example.lenovo.eshop.model.modelProduct;

import java.util.ArrayList;

public class presnterCategory implements contract.interfaces.presenter  {

    private contract.interfaces.Model model;
    private contract.interfaces.View views;

    public presnterCategory(contract.interfaces.View view) {
        this.views = view;
        initPresenter();
    }
    private void initPresenter() {
        model = new modelCategory();
        views.element();
    }
    @Override
    public void getData() {
        ArrayList data=model.getdata();
        views.setviewdata(data);

    }
}
