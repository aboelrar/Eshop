package com.example.lenovo.eshop.interfaces;

import java.util.ArrayList;

public interface signupinterface {
    public interface interfaces {
        interface  View
        {
            void element();
            void setviewCountrydata(ArrayList data);
            void setviewGenderdata(ArrayList data);

        }
        interface Model{
            ArrayList getCountrydata();
            ArrayList getGenderdata();

        }
        interface presenter{
            void getCountryData();
            void getGenderData();
        }

    }

}
