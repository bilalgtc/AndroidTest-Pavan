package com.example.android_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.android_test.Adapters.ViewAdapter;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

public class Welcome_screen extends AppCompatActivity {
    TextView textView;
    ViewPager viewPager;
    DotsIndicator dotsIndicator;
    ViewAdapter viewAdapter;
    AppCompatButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);


        viewPager=findViewById(R.id.viewpager);
        textView=findViewById(R.id.s_txt1);
        button =findViewById(R.id.next_btn);
        dotsIndicator=findViewById(R.id.dots);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (getitem(0)<2)
                viewPager.setCurrentItem(getitem(1), true);
            else{
                Intent i=new Intent(Welcome_screen.this, Registration_fb_google.class);
                startActivity(i);
                finish();
            }

            }
        });
        viewAdapter =new ViewAdapter(this);
        viewPager.setAdapter(viewAdapter);
        dotsIndicator.attachTo(viewPager);
        viewPager.addOnPageChangeListener(v);


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Welcome_screen.this,Sign_In.class);
                startActivity(i);
                finish();
            }
        });


    }
    ViewPager.OnPageChangeListener v = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if(position==2){
                button.setText("Get Started");
            }else{
                button.setText("Next");

            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public int getitem(int position){
        return viewPager.getCurrentItem()+position;
    }
}