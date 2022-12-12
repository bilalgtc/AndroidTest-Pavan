package com.example.android_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Sign_In extends AppCompatActivity {
        ImageView img;
        TextView txt1,txt2;
        AppCompatButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        img=findViewById(R.id.signin_backbtn);
        txt1=findViewById(R.id.s_in_txt1);
        txt2=findViewById(R.id.s_in_txt2);
        button=findViewById(R.id.sign_in);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Dashboard.class);
                startActivity(i);
            }
        });

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Sign_In.this, Registration_fb_google.class);
                startActivity(i);
                finish();
            }
        });
//
        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Sign_In.this,Registration.class);
                startActivity(i);
                finish();
            }
        });

        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Sign_In.this,Registration.class);
                startActivity(i);
                finish();
            }
        });

    }
}