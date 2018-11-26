package com.example.lenovo.eshop.presenter;

import com.example.lenovo.eshop.interfaces.contract;
import com.example.lenovo.eshop.interfaces.signupinterface;
import com.example.lenovo.eshop.model.modelGender;
import com.example.lenovo.eshop.model.modelProduct;
import com.example.lenovo.eshop.model.modelcountry;

import java.util.ArrayList;

public class presenterCountry implements signupinterface.interfaces.presenter {
    private signupinterface.interfaces.Model model;
    private signupinterface.interfaces.View views;


    public presenterCountry(signupinterface.interfaces.View view) {
        this.views = view;
        initPresenter();
    }

    private void initPresenter() {
        model = new modelcountry();
        views.element();
    }
    @Override
    public void getCountryData() {
        ArrayList data=model.getCountrydata();
        views.setviewCountrydata(data);
    }

    @Override
    public void getGenderData() {
        ArrayList data=model.getGenderdata();
        views.setviewGenderdata(data);
    }
}
