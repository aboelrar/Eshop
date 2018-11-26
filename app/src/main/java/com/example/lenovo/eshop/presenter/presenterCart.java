package com.example.lenovo.eshop.presenter;

import com.example.lenovo.eshop.interfaces.contract;
import com.example.lenovo.eshop.model.modelCart;
import com.example.lenovo.eshop.model.modelcatproduct;

import java.util.ArrayList;

public class presenterCart implements contract.interfaces.presenter {

    private contract.interfaces.Model model;
    private contract.interfaces.View views;


    public presenterCart(contract.interfaces.View view) {
        this.views = view;
        initPresenter();
    }
    private void initPresenter() {
        model = new modelCart();
        views.element();
    }
    @Override
    public void getData() {
        ArrayList data=model.getdata();
        views.setviewdata(data);
    }
}
