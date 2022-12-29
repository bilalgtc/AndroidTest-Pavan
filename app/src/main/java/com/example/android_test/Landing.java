package com.example.android_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class Landing extends AppCompatActivity implements View.OnClickListener {
    TextView textView, textView2, textView3, textView4, textView5;
    AppCompatButton button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        getWindow().setNavigationBarColor(getResources().getColor(R.color.blue));

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

        init();
        clicks();
        txtEdits();


    }

    private void init() {

        textView = findViewById(R.id.reg_txt1);
        textView2 = findViewById(R.id.reg_txt2);
        textView3 = findViewById(R.id.reg_txt3);
        button1 = findViewById(R.id.registerEmailbtn);
        textView4 = findViewById(R.id.regfb_txt1);
        textView5 = findViewById(R.id.regfb_txt2);
    }

    private void clicks() {
        button1.setOnClickListener(this);
        textView4.setOnClickListener(this);
        textView5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.regfb_txt1:
            case R.id.regfb_txt2:
                Intent i = new Intent(Landing.this, SignIn.class);
                startActivity(i);
                finish();
                break;

            case R.id.registerEmailbtn:

                Intent i2 = new Intent(Landing.this, SignUp.class);
                startActivity(i2);
                finish();


        }
    }


    private void txtEdits() {
        String text = "Welcome\t\t\t\nto Pet Care";

        SpannableString s = new SpannableString(text);

        ForegroundColorSpan fc = new ForegroundColorSpan(Color.parseColor("#FFCF6F"));

        s.setSpan(fc, 13, 22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(s);
    }
}