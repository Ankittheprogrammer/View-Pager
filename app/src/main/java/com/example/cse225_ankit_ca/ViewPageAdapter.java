package com.example.cse225_ankit_ca;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

class ViewPageAdapter extends PagerAdapter {

    // int[] img;
    LayoutInflater inflater;
    Context context;
    int position = 3;
    private int[] flag;

    public ViewPageAdapter(MainActivity mainActivity, int[] img) {

        this.context = mainActivity;
        this.flag = img;
    }

    @Override
    public int getCount() {
        return flag.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((RelativeLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        ImageView img;

        inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemview = inflater.inflate(R.layout.item, container, false);
        img = (ImageView) itemview.findViewById(R.id.ima1);

        img.setImageResource(flag[position]);

        ((ViewPager) container).addView(itemview);
        return itemview;    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);

    }

    @Override
    public float getPageWidth(int position) {
        return 1f;
    }
}
