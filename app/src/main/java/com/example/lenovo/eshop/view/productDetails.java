package com.example.lenovo.eshop.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.eshop.R;
import com.example.lenovo.eshop.interfaces.contract;
import com.example.lenovo.eshop.presenter.presenterRelated;
import com.example.lenovo.eshop.presenter.productAdapter;
import com.example.lenovo.eshop.viewimage;
import com.example.lenovo.eshop.viewimagedetails;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class productDetails extends AppCompatActivity implements contract.interfaces.View {
    ViewPager viewPager;
    int number,TotalPriceInt;
    viewimagedetails viewimage;
    ImageView search,share;
    ImageView back;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView relatedList;
    int count=0;
    TextView productName,productNum,TotalPrice;
    CircleIndicator circleIndicator;
    ImageView increase,decrease,favourite,addToCart;
    boolean isfav=false;
    boolean isaddedtoCart=false;
    presenterRelated presenterRelated;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        presenterRelated=new presenterRelated(this);
        presenterRelated.getData();

        viewPager();
        setProductName();
        getTotalPrice();
        setOnClick();
        checkIcon();
        getCartSize();
        search();
    }
    public void viewPager() {
        String[] image = {"https://rukminim1.flixcart.com/image/832/832/jao8uq80/shoe/3/r/q/sm323-9-sparx-white-original-imaezvxwmp6qz6tg.jpeg?q=70", "https://www.shoecarnival.com/dw/image/v2/BBSZ_PRD/on/demandware.static/-/Sites-scvl-master-catalog/default/dwdf2cc380/93421_180047_1.jpg?sw=1694&sh=1999&sm=fit"
                ,"https://images-na.ssl-images-amazon.com/images/I/61cbAQatNlL._UL1024_.jpg", "https://i1.adis.ws/i/hibbett/S0177B_0001_right2?w=580&h=580&fmt=jpg&bg=rgb(255,255,255)&img404=404&v=0"};
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewimage = new viewimagedetails(productDetails.this, image);
        viewPager.setAdapter(viewimage);
        circleIndicator=(CircleIndicator)findViewById(R.id.indicator);
        circleIndicator.setViewPager(viewPager);

        GoToCart();

    }
    public void setProductName()
    {
        Bundle b = getIntent().getExtras();
        final String receivingdata = b.getString("productName");
        productName=(TextView)findViewById(R.id.title);
        productName.setText(receivingdata);
    }
    public void getTotalPrice()
    {
        increase=(ImageView)findViewById(R.id.increase);
        decrease=(ImageView)findViewById(R.id.decrease);
        productNum=(TextView)findViewById(R.id.productnum);
        TotalPrice=(TextView)findViewById(R.id.totalprice);
         number =  Integer.parseInt(productNum.getText().toString());
        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                String numberAsString = Integer.toString(number);
                productNum.setText(numberAsString);

            }
        });
        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number--;
                String numberAsString = Integer.toString(number);
                productNum.setText(numberAsString);

            }
        });
    }
    public void setOnClick()
    {
        back=(ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        search=(ImageView)findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(productDetails.this,com.example.lenovo.eshop.view.search.class));
            }
        });
        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.lolo);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(productDetails.this,Rating.class));
            }
        });

    }

    private void checkIcon()
    {
        favourite=(ImageView)findViewById(R.id.favicon);
        addToCart=(ImageView)findViewById(R.id.addtocarticon);
        share=(ImageView)findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String body="body";
                String sub="sub";
                intent.putExtra(Intent.EXTRA_SUBJECT,sub);
                intent.putExtra(Intent.EXTRA_TEXT,body);
                startActivity(Intent.createChooser(intent,"share"));
            }
        });

        favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isfav==false){
                favourite.setImageResource(R.drawable.ic_favorite_red_24dp);
                Toast.makeText(productDetails.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                isfav=true;
            }
            else {
                favourite.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                    Toast.makeText(productDetails.this, "item Deleted", Toast.LENGTH_SHORT).show();
                    isfav=false;
                }
            }
        });
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isaddedtoCart==false)
                {
                    addToCart.setImageResource(R.drawable.whiteshoppingcart);
                    addToCart.setBackground(ContextCompat.getDrawable(productDetails.this, R.drawable.ovalgreen));
                    Toast.makeText(productDetails.this, "Added To Cart", Toast.LENGTH_SHORT).show();
                    isaddedtoCart=true;
                }else {
                    addToCart.setImageResource(R.drawable.whitecart_24dp);
                    addToCart.setBackground(ContextCompat.getDrawable(productDetails.this, R.drawable.ovalblue));
                    Toast.makeText(productDetails.this, "Item Deleted", Toast.LENGTH_SHORT).show();
                    isaddedtoCart=false;
                }
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
                startActivity(new Intent(productDetails.this,myCart.class));
            }
        });
    }
    public void search()
    {
        ImageView search=(ImageView)findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(productDetails.this,search.class));
            }
        });
    }

    @Override
    public void element() {
        relatedList=(RecyclerView)findViewById(R.id.relatedlist);

    }

    @Override
    public void setviewdata(ArrayList data) {
        layoutManager=new LinearLayoutManager(productDetails.this,LinearLayoutManager.HORIZONTAL,false);
        relatedList.setLayoutManager(layoutManager);
        adapter=new productAdapter(productDetails.this,data);
        relatedList.setAdapter(adapter);
    }
}
