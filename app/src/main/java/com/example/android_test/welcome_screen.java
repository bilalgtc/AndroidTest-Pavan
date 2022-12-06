package com.example.android_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

public class welcome_screen extends AppCompatActivity {
    ViewPager viewPager;
    DotsIndicator dotsIndicator;
    ViewAdapter viewAdapter;
    AppCompatButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        viewPager=findViewById(R.id.viewpager);

        button =findViewById(R.id.next_btn);
        dotsIndicator=findViewById(R.id.dots);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (getItem(0)<3) {
                viewPager.setCurrentItem(getItem(1), true);

            }else{
                    Intent i=new Intent(welcome_screen.this,MainActivity.class);
                    startActivity(i);

            }

            }
        });
        viewAdapter =new ViewAdapter(this);
        viewPager.setAdapter(viewAdapter);
        dotsIndicator.attachTo(viewPager);





    }

    private int getItem(int i){
        return viewPager.getCurrentItem()+i;
    }
}