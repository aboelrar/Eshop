package com.example.lenovo.eshop.expand;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.eshop.R;
import com.example.lenovo.eshop.view.categories;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.ArrayList;
import java.util.List;

public class expandAdapter extends ExpandableRecyclerViewAdapter<parentHolder,childHolder> {

    ArrayList<expandlist>mylist;
    Context context;
    public expandAdapter(List<? extends ExpandableGroup> groups, Context context) {
        super(groups);
        this.context=context;
    }

    @Override
    public parentHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.parent,parent,false);
        return new parentHolder(view);
    }

    @Override
    public childHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.child,parent,false);
        return new childHolder(view);    }

    @Override
    public void onBindChildViewHolder(childHolder holder, int flatPosition, ExpandableGroup group, final int childIndex) {
        itemList datas=(itemList)group.getItems().get(childIndex);
        holder.setArtistName(datas.getName());
        final int id=datas.getId();

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id==1)
                {
                    Intent intent = new Intent(context,categories.class);
                    context.startActivity(intent);                 }

                else if(id==2)
                {
                    Intent intent = new Intent(context,categories.class);
                    context.startActivity(intent);
                }
                else if(id==3)
                {
                    Intent intent = new Intent(context,categories.class);
                    context.startActivity(intent);
                }

            }
        });
    }

    @Override
    public void onBindGroupViewHolder(parentHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setGenreName(group.getTitle());
        holder.setArtistName(R.drawable.man);




    }


}
