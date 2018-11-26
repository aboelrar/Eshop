package com.example.lenovo.eshop.customAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.eshop.R;
import com.example.lenovo.eshop.list.categoryList;
import com.example.lenovo.eshop.view.productofcategory;

import java.util.ArrayList;

public class categoryAdapter extends RecyclerView.Adapter<categoryAdapter.categoryHolder> {
    Context context;
    ArrayList<categoryList>mylist;

    public categoryAdapter(Context context, ArrayList<categoryList> mylist) {
        this.context = context;
        this.mylist = mylist;
    }

    @NonNull
    @Override
    public categoryHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.productitem,viewGroup,false);
        categoryHolder categoryHolder=new categoryHolder(view);
        return categoryHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull categoryHolder viewHolder, int i) {
        viewHolder.title.setText(mylist.get(i).getTitle().toString());
        viewHolder.productImage.setImageResource(mylist.get(i).getImage());
        viewHolder.relativelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            v.getContext().startActivity(new Intent(context,productofcategory.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }
    public class categoryHolder extends RecyclerView.ViewHolder {
        TextView title;
        RelativeLayout relativelayout;
        ImageView productImage;
        public categoryHolder(@NonNull View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.txtcat);
            productImage=(ImageView)itemView.findViewById(R.id.imagecat);
            relativelayout=(RelativeLayout)itemView.findViewById(R.id.goTocatproducts);
        }
    }
}
