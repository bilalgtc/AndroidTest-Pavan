package com.example.android_test.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.android_test.R;

public class ViewAdapter extends PagerAdapter {
        Context context;
        LayoutInflater layoutInflater;
        Integer[] images= {R.drawable.illustration,R.drawable.illustration2,R.drawable.dog_illustration};


        int[] headings={
                R.string.silde_heading1,
                R.string.silde_heading2,
                R.string.silde_heading3
        };

        int[] descriptions={
                R.string.slide_description1,
                R.string.slide_description2,
                R.string.slide_description3
        };

        public ViewAdapter(Context context){
            this.context=context;
        }
    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.item,container, false);
        ImageView img=view.findViewById(R.id.item_imgview);
        TextView slideheading =view.findViewById(R.id.textView2);
        TextView slidedescription =view.findViewById(R.id.textView3);


        img.setImageResource(images[position]);
        slideheading.setText(headings[position]);
        slidedescription.setText(descriptions[position]);

        container.addView(view,0);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager=(ViewPager) container;
        View view=(View) object;
        viewPager.removeView(view);
    }
}
