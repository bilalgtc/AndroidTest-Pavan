package com.example.android_test;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

public class registration_fb_google extends AppCompatActivity {
        TextView textView,textView2,textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_fb_google);

        textView =findViewById(R.id.reg_txt1);
        textView2 =findViewById(R.id.reg_txt2);

        String text3="I agree with the rules";
        String text = "Welcome\t\t\t\nto Pet Care";
        String text2 ="Continue with Facebook";
        SpannableString s= new SpannableString(text);
        SpannableString s2= new SpannableString(text2);
        SpannableString s3 =new SpannableString(text3);

        StyleSpan ss= new StyleSpan(Typeface.BOLD);
        ForegroundColorSpan fc=new ForegroundColorSpan(Color.parseColor("#FFCF6F"));
        ForegroundColorSpan fc2=new ForegroundColorSpan(Color.parseColor("#070821"));

       UnderlineSpan ss2 =new UnderlineSpan();

        s3.setSpan(fc2,11,19, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        s2.setSpan(ss, 13, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        s.setSpan(fc, 13, 22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

       s3.setSpan(ss2, 11, 19, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView3.setText(s3);
        textView.setText(s);
        textView2.setText(s2);
    }
}