package com.example.lenovo.eshop.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.example.lenovo.eshop.R;
import com.example.lenovo.eshop.customAdapter.cartAdapter;
import com.example.lenovo.eshop.interfaces.contract;
import com.example.lenovo.eshop.presenter.presenterCart;

import java.util.ArrayList;

public class myCart extends AppCompatActivity  implements contract.interfaces.View{
RecyclerView CartList;
TextView Title;
RecyclerView.Adapter adapter;
RecyclerView.LayoutManager layoutManager;
    presenterCart presenterCart;
    EditText coupon;
    Button apply;
    TextView textView;
    ArrayList CaretNum;
    ImageView back,search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);
        presenterCart=new presenterCart(myCart.this);
        presenterCart.getData();
        addText();
        setOnClick();
        SharedPrefrences();
        getCartSize();
        Tiltle();
        back();
        search();
        Payment();
    }

    @Override
    public void element() {
        CartList=(RecyclerView)findViewById(R.id.cartlist);
    }

    @Override
    public void setviewdata(ArrayList data) {

        layoutManager=new LinearLayoutManager(myCart.this);
        CartList.setLayoutManager(layoutManager);
        adapter=new cartAdapter(myCart.this,data);
        CartList.setAdapter(adapter);
        CaretNum=data;

    }
    public void addText()
    {
        coupon=(EditText)findViewById(R.id.editcoupon) ;
        apply=(Button)findViewById(R.id.btntwo) ;
        textView=(TextView)findViewById(R.id.coupontext);
        coupon.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                ViewSwitcher switcher1 = (ViewSwitcher) findViewById(R.id.my_switcher_btn);
                if(coupon.length()>0){
                    switcher1.setDisplayedChild(1); //or switcher.showPrevious()
                }else if(coupon.getText().toString().isEmpty())
                {
                    switcher1.setDisplayedChild(0);//or switcher.showPrevious()

                }


            }


        });
    }

    public void setOnClick()
    {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewSwitcher switcher = (ViewSwitcher) findViewById(R.id.my_switcher);
                switcher.showNext(); //or switcher.showPrevious();


            }
        });
    }
    public void SharedPrefrences()
    {
        SharedPreferences sharedPreferences=getSharedPreferences("tok",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("size", String.valueOf(CaretNum.size()));
        editor.commit();
    }

    public void getCartSize()
    {
        SharedPreferences sharedPreferences=getSharedPreferences("tok",MODE_PRIVATE);
        String numbercart=sharedPreferences.getString("size","");
        TextView number=(TextView)findViewById(R.id.cartNum);
        number.setText(numbercart);
    }
    public void Tiltle()
    {
        Title=(TextView)findViewById(R.id.titlebar);
        Title.setText("MY CART");
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
    public void search()
    {
        ImageView search=(ImageView)findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(myCart.this,search.class));
            }
        });
    }

    public void Payment()
    {
        Button proceed=(Button)findViewById(R.id.proceed);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(myCart.this,shippingAddress.class));
            }
        });
    }

}
