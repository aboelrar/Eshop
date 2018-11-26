package com.example.lenovo.eshop.expand;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.eshop.R;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class childHolder extends ChildViewHolder {
    TextView title;
    LinearLayout linearLayout;

    public childHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.child);
        linearLayout=(LinearLayout)itemView.findViewById(R.id.clickon);

    }


    public void setArtistName(String name) {
        title.setText(name);
    }
}

