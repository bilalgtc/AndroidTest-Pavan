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

public class Introduction extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    ViewPager viewPager;
    DotsIndicator dotsIndicator;
    ViewAdapter viewAdapter;
    AppCompatButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

        init();

        button.setOnClickListener(this);
        textView.setOnClickListener(this);

        viewAdapter = new ViewAdapter(this);
        viewPager.setAdapter(viewAdapter);
        dotsIndicator.attachTo(viewPager);
        viewPager.addOnPageChangeListener(v);
    }

    ViewPager.OnPageChangeListener v = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (position == 2) {
                button.setText("Get Started");
            } else {
                button.setText("Next");

            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public int getitem(int position) {
        return viewPager.getCurrentItem() + position;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.s_txt1:
                Intent i = new Intent(Introduction.this, Sign_In.class);
                startActivity(i);
                finish();
                break;

            case R.id.next_btn:
                if (getitem(0) < 2)
                    viewPager.setCurrentItem(getitem(1), true);
                else {
                    Intent i2 = new Intent(Introduction.this, Landing.class);
                    startActivity(i2);
                    finish();
                }
                break;
        }
    }

    private void init() {
        viewPager = findViewById(R.id.viewpager);
        textView = findViewById(R.id.s_txt1);
        button = findViewById(R.id.next_btn);
        dotsIndicator = findViewById(R.id.dots);
    }
}