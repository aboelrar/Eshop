package com.example.lenovo.eshop.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.eshop.R;
import com.example.lenovo.eshop.interfaces.contract;
import com.example.lenovo.eshop.presenter.presenterProduct;
import com.example.lenovo.eshop.presenter.productAdapter;

import java.util.ArrayList;

public class search extends AppCompatActivity implements contract.interfaces.View{
 RecyclerView searchList;
 productAdapter adapter;
 RecyclerView.LayoutManager layoutManager;
 com.example.lenovo.eshop.presenter.presenterProduct presenterProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        search();
        presenterProduct=new presenterProduct(search.this);
        presenterProduct.getData();
        GoToCart();

    }

    @Override
    public void element() {
        searchList=(RecyclerView)findViewById(R.id.searclist);
    }

    @Override
    public void setviewdata(ArrayList data) {
        layoutManager=new GridLayoutManager(search.this,2);
        searchList.setLayoutManager(layoutManager);
        adapter=new productAdapter(search.this,data);
        searchList.setAdapter(adapter);

    }
    public void search()
    {
        final EditText searchview=(EditText)findViewById(R.id.searchview);


        searchview.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                    return true;
                }
                return false;
            }
        });
        searchview.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                adapter.getFilter().filter(s);

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                adapter.getFilter().filter(s);

            }
        });
    }
    public void GoToCart()
    {
        RelativeLayout GotoCart=(RelativeLayout)findViewById(R.id.GoToCart);
        GotoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(search.this,myCart.class));
            }
        });
    }
}
