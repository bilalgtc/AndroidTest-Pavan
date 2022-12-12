package com.example.android_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class Registration extends AppCompatActivity {

    TextView textView,textView1,textView2;
    AppCompatButton button;
    TextInputLayout name,email,mobile,password;
    ImageView imageView,imageView2,imageView3;
    int temp=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        textView = findViewById(R.id.checkbox_txt1);
        String text = "I agree with the rules";
        SpannableString s1 = new SpannableString(text);


        ForegroundColorSpan fc = new ForegroundColorSpan(Color.parseColor("#4552CB"));
        UnderlineSpan ss2 = new UnderlineSpan();

        s1.setSpan(ss2, 13, 22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        s1.setSpan(fc, 13, 22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(s1);


        button = findViewById(R.id.signup_btn);
        name = findViewById(R.id.name_ed);
        email = findViewById(R.id.email_ed);
        mobile = findViewById(R.id.mobile_ed);
        password = findViewById(R.id.pass_ed);


        textView1=findViewById(R.id.goto_signin1);
        textView2=findViewById(R.id.goto_signin2);
        imageView=findViewById(R.id.reg_backbtn);
        imageView2=findViewById(R.id.checkbox_img1);
        imageView3=findViewById(R.id.checkbox_img2);


        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (temp==0){
                    imageView2.setImageResource(R.drawable.activeted);
                    temp++;
                }else if (temp==1){
                    imageView2.setImageResource(R.drawable.disabled);
                    temp--;
                }

            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (temp==0){
                    imageView3.setImageResource(R.drawable.activeted);
                    temp++;

                }else if (temp==1){
                    imageView3.setImageResource(R.drawable.disabled);
                    temp--;
                }

            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Registration.this, Registration_fb_google.class);
                startActivity(i);
                finish();
            }
        });

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Registration.this,Sign_In.class);
                startActivity(i);
                finish();
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Registration.this,Sign_In.class);
                startActivity(i);
                finish();
            }
        });

    }


}