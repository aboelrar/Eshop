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
import com.example.lenovo.eshop.customAdapter.favouriteAdapter;
import com.example.lenovo.eshop.sqllite.favouritData;

public class favourite extends AppCompatActivity {
favouritData favouritData;
RecyclerView recyclerList;
RecyclerView.Adapter favouriteAdapter;
RecyclerView.LayoutManager layoutManager;
TextView favouriteTitle;
ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
        favouritData=new favouritData(favourite.this);
        recyclerList=(RecyclerView)findViewById(R.id.favlist);
        GetAllData();
        setTitleBar();
        getCartSize();
        GoToCart();
        back();
    }
    public void GetAllData()
    {
     layoutManager=new LinearLayoutManager(favourite.this);
     recyclerList.setLayoutManager(layoutManager);
     favouriteAdapter=new favouriteAdapter(favourite.this,favouritData.RetreiveAllData());
     recyclerList.setAdapter(favouriteAdapter);

    }
    public void setTitleBar()
    {
        favouriteTitle=(TextView)findViewById(R.id.titlebar);
        favouriteTitle.setText("Favourite");
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
                startActivity(new Intent(favourite.this,myCart.class));
            }
        });
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
}
