package com.example.lenovo.eshop.view;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.eshop.R;
import com.example.lenovo.eshop.expand.expandAdapter;
import com.example.lenovo.eshop.expand.expandlist;
import com.example.lenovo.eshop.expand.itemList;
import com.example.lenovo.eshop.interfaces.contract;
import com.example.lenovo.eshop.presenter.presenterProduct;
import com.example.lenovo.eshop.presenter.productAdapter;
import com.example.lenovo.eshop.sqllite.favouritData;
import com.example.lenovo.eshop.viewimage;
import java.util.ArrayList;

public class Home extends AppCompatActivity implements contract.interfaces.View {
    ViewPager viewPager;
    com.example.lenovo.eshop.viewimage viewimage;
    RecyclerView.Adapter productAdapter;
    RecyclerView.LayoutManager productLayoutManager;
    RecyclerView productlist,latestlist;
    presenterProduct presenterProduct;
    favouritData favouritData;
    ImageView menu,favourite;
    TextView name,price;
    LinearLayout linearLayout,Login;
    CardView search;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        viewPager();
        presenterProduct=new presenterProduct(Home.this);
        favourite=(ImageView)findViewById(R.id.favourite);
        favouritData=new favouritData(Home.this);
        linearLayout=(LinearLayout)findViewById(R.id.favoritenav);

        presenterProduct.getData();
        setOnClick();
        getexpandableData();
        setOnItemListner();
        goToLogin();
        GoToCart();
        getCartSize();
    }

    public void viewPager() {
        String[] image = {"https://beddingstock.com/Blog/wp-content/uploads/2015/10/OL-Shopping-Cover-Photo-1024x431.jpg", "http://fb-timeline-cover.com/covers-images/download/let's%20go%20shopping.jpg"
                ,"https://www.contactcare.nl/wp-content/uploads/2017/08/Online-shoppen-en-groeien.jpg", "https://cdn5.f-cdn.com/contestentries/1282340/22888381/5aafeb035f249_thumb900.jpg"};
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewimage = new viewimage(Home.this, image);
        viewPager.setAdapter(viewimage);
        final Handler handler = new Handler();

        final Runnable runnable = new Runnable() {
            public void run() {

                if (count++ <3){
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+ 1);
                }

                handler.postDelayed(this, 5000);

            }
        };

        // trigger first time
        handler.post(runnable);
    }

    @Override
    public void element() {
        productlist=(RecyclerView)findViewById(R.id.dealslist);
        latestlist=(RecyclerView)findViewById(R.id.latestlist);
    }

    @Override
    public void setviewdata(ArrayList data) {
        productLayoutManager=new LinearLayoutManager(Home.this,LinearLayoutManager.HORIZONTAL,false);
        productlist.setLayoutManager(productLayoutManager);
        productlist.setHasFixedSize(true);
        productAdapter=new productAdapter(Home.this,data);
        productlist.setAdapter(productAdapter);
        latestlist.setAdapter(productAdapter);
    }
    public void setOnClick()
    {
        menu=(ImageView)findViewById(R.id.menu);
        final DrawerLayout   drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
                    drawerLayout.closeDrawer(Gravity.LEFT);

                } else {
                    drawerLayout.openDrawer(Gravity.LEFT);
                    }
            }
        });

        }

    public void getexpandableData()
    {
        RecyclerView recyclerViewexpand=(RecyclerView)findViewById(R.id.categorieslist);
        ArrayList<itemList>about=new ArrayList(4);
        ArrayList<expandlist>mylsits=new ArrayList(1);



        mylsits.add(new expandlist("Man",about,R.drawable.shoes));
        about.add(new itemList(1,"SHOES"));
        about.add(new itemList(2,"Clothing "));
        about.add(new itemList(3, "ACCESSORIES & EQUIPMENTS"));
        about.add(new itemList(4, "BRANDS"));

        mylsits.add(new expandlist("Women",about,R.drawable.shoes));
        about.add(new itemList(1,"SHOES"));
        about.add(new itemList(2,"Clothing "));
        about.add(new itemList(3, "ACCESSORIES & EQUIPMENTS"));
        about.add(new itemList(4, "BRANDS"));

        mylsits.add(new expandlist("Women",about,R.drawable.shoes));
        about.add(new itemList(1,"SHOES"));
        about.add(new itemList(2,"Clothing "));
        about.add(new itemList(3, "ACCESSORIES & EQUIPMENTS"));
        about.add(new itemList(4, "BRANDS"));

        RecyclerView.LayoutManager layoutManagerr=new LinearLayoutManager(this);
        recyclerViewexpand.setLayoutManager(layoutManagerr);
        RecyclerView.Adapter adapterr=new expandAdapter(mylsits,Home.this);

        recyclerViewexpand.setAdapter(adapterr);
    }
public void setOnItemListner()
{
    linearLayout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(Home.this, com.example.lenovo.eshop.view.favourite.class);
            startActivity(intent);        }
    });
    search=(CardView) findViewById(R.id.search);
    search.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(Home.this,com.example.lenovo.eshop.view.search.class));
        }
    });
}
public void goToLogin()
{
    Login=(LinearLayout)findViewById(R.id.login);
    Login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(Home.this,Login.class));
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
                startActivity(new Intent(Home.this,myCart.class));
            }
        });
    }
    }

