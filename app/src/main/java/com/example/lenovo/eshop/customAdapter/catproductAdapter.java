package com.example.lenovo.eshop.customAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.eshop.R;
import com.example.lenovo.eshop.list.categoryList;
import com.example.lenovo.eshop.list.catproductlist;
import com.example.lenovo.eshop.view.productDetails;

import java.util.ArrayList;

public class catproductAdapter extends RecyclerView.Adapter <catproductAdapter.catproductHolder>{
    Context context;
    ArrayList<catproductlist>mylist;

    public catproductAdapter(Context context, ArrayList<catproductlist> mylist) {
        this.context = context;
        this.mylist = mylist;
    }

    @NonNull
    @Override
    public catproductHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.categoryitemproduct,viewGroup,false);
        catproductHolder catproductHolder=new catproductHolder(view);
        return catproductHolder;
    }

    @Override
    public void onBindViewHolder(final catproductHolder viewHolder, final int i) {
        viewHolder.title.setText(mylist.get(i).getName().toString());
        viewHolder.productImage.setImageResource(mylist.get(i).getImage());
        viewHolder.price.setText(mylist.get(i).getPrice().toString());
        viewHolder.GoToDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(context,productDetails.class));
            }
        });
        viewHolder.fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
      if(mylist.get(i).isFavourite()==false){
            viewHolder.fav.setImageResource(R.drawable.ic_favorite_red_24dp);
          Toast.makeText(context, "Added Successfully", Toast.LENGTH_SHORT).show();
          mylist.get(i).setFavourite(true);
        }else{
          viewHolder.fav.setImageResource(R.drawable.ic_favorite_border_black_24dp);
          Toast.makeText(context, "Item Deleted", Toast.LENGTH_SHORT).show();
          mylist.get(i).setFavourite(false);
      }
            }
        });
        viewHolder.addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mylist.get(i).isAddToCart()==false)
                {
                    viewHolder.addToCart.setImageResource(R.drawable.ic_shopping_cart_green_24dp);
                    mylist.get(i).setFavourite(true);
                }
                else {
                    viewHolder.addToCart.setImageResource(R.drawable.whitecart_24dp);
                    viewHolder.addToCart.setBackground(ContextCompat.getDrawable(context, R.drawable.ovalblue));
                    Toast.makeText(context, "Item Deleted", Toast.LENGTH_SHORT).show();
                    mylist.get(i).setFavourite(false);
                }
            }
        });

        viewHolder.Share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String body="body";
                String sub="sub";
                intent.putExtra(Intent.EXTRA_SUBJECT,sub);
                intent.putExtra(Intent.EXTRA_TEXT,body);
                v.getContext().startActivity(Intent.createChooser(intent,"share"));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }
    public class catproductHolder extends RecyclerView.ViewHolder {
        TextView title,price;
        ImageView productImage,fav,addToCart,Share;
        LinearLayout GoToDetails;
        public catproductHolder(@NonNull View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.producttitlecat);
            price=(TextView)itemView.findViewById(R.id.priceproductitem);
            productImage=(ImageView)itemView.findViewById(R.id.productimagecat);
            fav=(ImageView)itemView.findViewById(R.id.favicon);
            addToCart=(ImageView)itemView.findViewById(R.id.addtocarticon);
            Share=(ImageView)itemView.findViewById(R.id.share);
            GoToDetails=(LinearLayout)itemView.findViewById(R.id.GoToDetails);

        }
    }
}
