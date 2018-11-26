package com.example.lenovo.eshop.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.eshop.R;
import com.example.lenovo.eshop.customAdapter.categoryAdapter;
import com.example.lenovo.eshop.customAdapter.catproductAdapter;
import com.example.lenovo.eshop.interfaces.contract;
import com.example.lenovo.eshop.presenter.presentercatproduct;
import com.example.lenovo.eshop.presenter.presnterCategory;

import java.util.ArrayList;

public class productofcategory extends AppCompatActivity implements contract.interfaces.View{
RecyclerView catProductList;
RecyclerView.Adapter adapter;
RecyclerView.LayoutManager layoutManager;
    presentercatproduct presentercatproduct;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productofcategory);
        presentercatproduct=new presentercatproduct(productofcategory.this);
        presentercatproduct.getData();
        getCartSize();
        back();
        GoToCart();
        search();

    }

    @Override
    public void element() {
        catProductList=(RecyclerView)findViewById(R.id.catproductlist);
    }

    @Override
    public void setviewdata(ArrayList data) {
        layoutManager=new LinearLayoutManager(productofcategory.this);
        catProductList.setLayoutManager(layoutManager);
        catProductList.setHasFixedSize(true);
        adapter=new catproductAdapter(productofcategory.this,data);
        catProductList.setAdapter(adapter);

    }
    public void getCartSize()
    {
        SharedPreferences sharedPreferences=getSharedPreferences("tok",MODE_PRIVATE);
        String numbercart=sharedPreferences.getString("size","");
        TextView number=(TextView)findViewById(R.id.cartNum);
        number.setText(numbercart);
    }
    public void back()
    {
        back=(ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void GoToCart()
    {
        RelativeLayout GotoCart=(RelativeLayout)findViewById(R.id.GoToCart);
        GotoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(productofcategory.this,myCart.class));
            }
        });
    }
    public void search()
    {
        ImageView search=(ImageView)findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(productofcategory.this,search.class));
            }
        });
    }
}
