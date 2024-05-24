package com.example.ch8_viewpager;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.Objects;

public class MyViewPager extends PagerAdapter {
    Context context;
    int[] images;
    LayoutInflater layoutInflater;
    public MyViewPager(Context context, int[] images) {
        this.context = context;
        this.images = images;
        layoutInflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return images.length;
    }
    @Override
    public boolean isViewFromObject(@NonNull View view,@NonNull Object object) {
        Log.i("MyViewPager", "isViewFromObject");
        return view == ((LinearLayout) object);
    }
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        View itemView = layoutInflater.inflate(R.layout.item, container, false);
        ImageView imageView = itemView.findViewById(R.id.imageView);
        imageView.setImageResource(images[position]);
        Objects.requireNonNull(container).addView(itemView);
        return itemView;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
