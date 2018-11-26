package com.example.lenovo.eshop.presenter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.eshop.R;
import com.example.lenovo.eshop.sqllite.favouritData;
import com.example.lenovo.eshop.view.productDetails;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class productAdapter extends RecyclerView.Adapter<productAdapter.productHolder> implements Filterable {
    Context  context;
    ArrayList<productList>mylist;
    favouritData favouritData;
    Boolean favouriteColor=false;
    ArrayList<productList>myliste;
    public productAdapter(Context context, ArrayList<productList> mylist) {
        this.context = context;
        this.mylist = mylist;
        this.myliste=mylist;
    }

    @NonNull
    @Override
    public productHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.itemlastest,viewGroup,false);
        productHolder productHolder=new productHolder(view);
        return productHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final productHolder viewHolder, final int i) {
        viewHolder.title.setText(mylist.get(i).getTitle().toString());
        viewHolder.discount.setText(mylist.get(i).getDiscount().toString());
        viewHolder.price.setText(mylist.get(i).getPrice().toString());
        viewHolder.imageProduct.setImageResource(mylist.get(i).getImage());
        favouritData=new favouritData(context);
        viewHolder.productpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                Intent intent=new Intent(context,productDetails.class);
                String productName = viewHolder.title.getText().toString();
                b.putString("productName", productName);
                intent.putExtras(b);
                v.getContext().startActivity(intent);
            }
        });
        viewHolder.favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String productName = viewHolder.title.getText().toString();
                String productPrice = viewHolder.price.getText().toString();
                viewHolder.imageProduct.buildDrawingCache();
                Bitmap bmap = viewHolder.imageProduct.getDrawingCache();
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                bmap.compress(Bitmap.CompressFormat.PNG, 100, bos);
                byte[] image = bos.toByteArray();

                if (mylist.get(i).isFavourite==false) {
                    if (favouritData.addToFavourite(productName, productPrice, image)) {
                        viewHolder.favourite.setImageResource(R.drawable.ic_favorite_red_24dp);
                        Toast.makeText(context, "Added Successfully", Toast.LENGTH_SHORT).show();
                        mylist.get(i).setFavourite(true);

                    } else {
                        Toast.makeText(context, "SomeThing Went Wrong", Toast.LENGTH_SHORT).show();

                    }

                }else {

                    viewHolder.favourite.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                    Toast.makeText(context, "Item Deleted", Toast.LENGTH_SHORT).show();
                      mylist.get(i).setFavourite(false);


                }
            }});

         viewHolder.shoppingcart.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if(mylist.get(i).isFavourite==false){
                     viewHolder.shoppingcart.setImageResource(R.drawable.ic_shopping_cart_green_24dp);
                     mylist.get(i).setFavourite(true);
                 }
                 else {
                     viewHolder.shoppingcart.setImageResource(R.drawable.ic_add_shopping_cart_black_24dp);
                     mylist.get(i).setFavourite(false);

                 }
             }
         });


         viewHolder.share.setOnClickListener(new View.OnClickListener() {
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
        return myliste.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override//charsequance حروف مسلسله
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString=charSequence.toString();
                if(charString.isEmpty())
                {
                    myliste=mylist;
                }else {
                    ArrayList<productList>filteredlist=new ArrayList<>();
                    for(productList filtername:mylist)
                    {
                        if(filtername.getTitle().toLowerCase().contains(charString.toLowerCase()))
                        {
                            filteredlist.add(filtername);
                        }
                    }
                    myliste=filteredlist;
                }
                FilterResults filterResults=new FilterResults();// بيجيب نتيجه عمليه الفلتره
                filterResults.values=myliste;
                filterResults.count =myliste.size();
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                myliste=(ArrayList<productList>)filterResults.values;
                notifyDataSetChanged();

            }
        };
    }

    public class productHolder extends RecyclerView.ViewHolder {
     TextView title,price,discount;
     ImageView imageProduct,favourite,shoppingcart,share;
     LinearLayout productpass;
        public productHolder(@NonNull View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.title);
            price=(TextView)itemView.findViewById(R.id.price);
            discount=(TextView)itemView.findViewById(R.id.discount);
            imageProduct=(ImageView) itemView.findViewById(R.id.productimage);
            productpass=(LinearLayout)itemView.findViewById(R.id.productitem);
            favourite=(ImageView)itemView.findViewById(R.id.favourite);
            shoppingcart=(ImageView)itemView.findViewById(R.id.shoppingcart);
            share=(ImageView)itemView.findViewById(R.id.share);

        }
    }
}
