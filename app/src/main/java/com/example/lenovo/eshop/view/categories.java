package com.example.lenovo.eshop.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.eshop.R;
import com.example.lenovo.eshop.customAdapter.categoryAdapter;
import com.example.lenovo.eshop.interfaces.contract;
import com.example.lenovo.eshop.presenter.presnterCategory;

import java.util.ArrayList;

public class categories extends AppCompatActivity  implements contract.interfaces.View {
RecyclerView CategoryList;
RecyclerView.Adapter adapter;
AppBarLayout appBarLayout;
TextView number;
RecyclerView.LayoutManager layoutManager;
    presnterCategory presnterCategoryy;
    ImageView arrowBack;
CardView search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        presnterCategoryy=new presnterCategory(categories.this);
        presnterCategoryy.getData();
        setArrowBack();
        getCartSize();
        GoToCart();
    }

    @Override
    public void element() {
        CategoryList=(RecyclerView)findViewById(R.id.categotylist);
    }

    @Override
    public void setviewdata(ArrayList data) {
        layoutManager=new LinearLayoutManager(categories.this);
        CategoryList.setLayoutManager(layoutManager);
        CategoryList.setHasFixedSize(true);
        adapter=new categoryAdapter(categories.this,data);
        CategoryList.setAdapter(adapter);

 }
 public void setArrowBack()
 {
     arrowBack=(ImageView)findViewById(R.id.menu);
     arrowBack.setImageResource(R.drawable.ic_arrow_back_black_24dp);
     arrowBack.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             finish();
         }
     });

     search=(CardView) findViewById(R.id.search);
     search.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             startActivity(new Intent(categories.this,com.example.lenovo.eshop.view.search.class));
         }
     });
 }
    public void getCartSize()
    {
        SharedPreferences sharedPreferences=getSharedPreferences("tok",MODE_PRIVATE);
        String numbercart=sharedPreferences.getString("size","");
        TextView number=(TextView)findViewById(R.id.cartNum);
        number.setText(numbercart);
    }
public void GoToCart()
{
    RelativeLayout GotoCart=(RelativeLayout)findViewById(R.id.GoToCart);
    GotoCart.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(categories.this,myCart.class));
        }
    });
}
}
