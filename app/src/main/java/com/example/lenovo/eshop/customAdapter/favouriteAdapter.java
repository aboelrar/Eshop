package com.example.lenovo.eshop.customAdapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.eshop.R;
import com.example.lenovo.eshop.sqllite.favouritelist;
import com.example.lenovo.eshop.view.productDetails;

import java.util.ArrayList;

public class favouriteAdapter extends RecyclerView.Adapter<favouriteAdapter.favouriteHolder> {
    Context context;
    ArrayList<favouritelist>mylist;


    public favouriteAdapter(Context context, ArrayList<favouritelist> mylist) {
        this.context = context;
        this.mylist = mylist;
    }

    @Override
    public favouriteHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.favouriteitem,viewGroup,false);
        favouriteHolder favouriteHolder=new favouriteHolder(view);
        return favouriteHolder;
    }

    @Override
    public void onBindViewHolder(favouriteHolder viewHolder, int i) {

        viewHolder.title.setText(mylist.get(i).getTitle().toString());
        viewHolder.price.setText(mylist.get(i).getPrice().toString());
        viewHolder.productImage.setImageBitmap(convertToBitmap(mylist.get(i).getImage()));
        viewHolder.GoToDeatils.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(context,productDetails.class));
            }
        });
}

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    public class favouriteHolder extends RecyclerView.ViewHolder {
        TextView title,price;
        ImageView productImage;
        LinearLayout GoToDeatils;
        public favouriteHolder(@NonNull View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.productname);
            price=(TextView)itemView.findViewById(R.id.price);
            productImage=(ImageView)itemView.findViewById(R.id.productimage);
            GoToDeatils=(LinearLayout)itemView.findViewById(R.id.GoToDetails);
        }
    }
    private Bitmap convertToBitmap(byte[] b){

        return BitmapFactory.decodeByteArray(b, 0, b.length);

    }
}
