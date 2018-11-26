package com.example.lenovo.eshop.interfaces;

import java.util.ArrayList;

public interface contract {
    public interface interfaces {
        interface  View
        {
            void element();
            void setviewdata(ArrayList data);
        }
        interface Model{
            ArrayList getdata();
        }
        interface presenter{
            void getData();
        }

    }

}
