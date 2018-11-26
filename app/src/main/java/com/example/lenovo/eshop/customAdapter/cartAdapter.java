package com.example.lenovo.eshop.customAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.eshop.R;
import com.example.lenovo.eshop.list.cartList;

import java.util.ArrayList;

public class cartAdapter extends RecyclerView.Adapter<cartAdapter.cartHolder>{

    Context context;
    ArrayList<cartList>mylist;

    public cartAdapter(Context context, ArrayList<cartList> mylist) {
        this.context = context;
        this.mylist = mylist;
    }

    @NonNull
    @Override
    public cartHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.cartitem,viewGroup,false);
        cartHolder cartHolder=new cartHolder(view);
        return cartHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final cartHolder viewHolder,final int i) {
        viewHolder.title.setText(mylist.get(i).getTitle().toString());
        viewHolder.totalNum.setText(mylist.get(i).getNum().toString());
        viewHolder.imgCart.setImageResource(mylist.get(i).getCartImage());
        viewHolder.increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             int num=Integer.parseInt(viewHolder.totalNum.getText().toString());
             num++;
             String s=Integer.toString(num);
             viewHolder.totalNum.setText(s);

            }
        });
        viewHolder.decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num=Integer.parseInt(viewHolder.totalNum.getText().toString());
                num--;
                String s=Integer.toString(num);
                viewHolder.totalNum.setText(s);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    public class cartHolder extends RecyclerView.ViewHolder {
        ImageView imgCart;
        TextView increase,decrease,title,totalNum;

        public cartHolder(@NonNull View itemView) {
            super(itemView);
            imgCart=(ImageView)itemView.findViewById(R.id.cartImg);
            title=(TextView)itemView.findViewById(R.id.carttitle);
            increase=(TextView)itemView.findViewById(R.id.add);
            decrease=(TextView)itemView.findViewById(R.id.decrease);
            totalNum=(TextView)itemView.findViewById(R.id.numberome);

        }
    }
}
