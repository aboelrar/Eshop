package com.example.lenovo.eshop;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

public class viewimagedetails extends PagerAdapter {
    Context context;
    String [] image;
    public viewimagedetails(Context context, String[]image)
    {
        this.context=context;
        this.image=image;
    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==(LinearLayout)o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=LayoutInflater.from(context).inflate(R.layout.detailsslider,container,false);
        ImageView images=(ImageView)view.findViewById(R.id.slider);
        Picasso.with(context).load(image[position]).into(images);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
