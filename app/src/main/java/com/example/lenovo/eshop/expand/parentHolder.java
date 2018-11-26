package com.example.lenovo.eshop.expand;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.eshop.R;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

public class parentHolder extends GroupViewHolder {
    TextView title;
    ImageView kind;

    public parentHolder(View itemView) {
        super(itemView);
        title=(TextView)itemView.findViewById(R.id.contactuss);
        kind=(ImageView)itemView.findViewById(R.id.kind);

    }

    public void setGenreName(String name){
        title.setText(name);
    }
    public void setArtistName(int img){
         kind.setImageResource(img);

    }}
