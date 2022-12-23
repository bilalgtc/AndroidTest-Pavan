package com.example.android_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

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

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

        init();


        String text = "Welcome\t\t\t\nto Pet Care";
        String text2 = "Continue with Facebook";
        String text3 = "Continue with Google";

        SpannableString s = new SpannableString(text);
        SpannableString s2 = new SpannableString(text2);
        SpannableString s3 = new SpannableString(text3);

        StyleSpan ss = new StyleSpan(Typeface.BOLD);
        StyleSpan ss2 = new StyleSpan(Typeface.BOLD);

        ForegroundColorSpan fc = new ForegroundColorSpan(Color.parseColor("#FFCF6F"));

        s.setSpan(fc, 13, 22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        s2.setSpan(ss, 13, 22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        s3.setSpan(ss2, 13, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(s);
        textView2.setText(s2);
        textView3.setText(s3);

        button1.setOnClickListener(this);
        textView4.setOnClickListener(this);
        textView5.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.regfb_txt1:
            case R.id.regfb_txt2:
                Intent i = new Intent(Landing.this, Sign_In.class);
                startActivity(i);
                finish();
                break;

            case R.id.registerEmailbtn:

                Intent i2 = new Intent(Landing.this, Sign_Up.class);
                startActivity(i2);
                finish();


        }
    }

    private void init() {

        textView = findViewById(R.id.reg_txt1);
        textView2 = findViewById(R.id.reg_txt2);
        textView3 = findViewById(R.id.reg_txt3);
        button1 = findViewById(R.id.registerEmailbtn);
        textView4 = findViewById(R.id.regfb_txt1);
        textView5 = findViewById(R.id.regfb_txt2);
    }
}