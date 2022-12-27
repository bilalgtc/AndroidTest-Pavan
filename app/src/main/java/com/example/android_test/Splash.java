package com.example.android_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class Splash extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().setNavigationBarColor(getResources().getColor(R.color.blue));

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);


        new Handler().postDelayed(() -> {
            sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);

            if (sharedPreferences.contains("email")){
                Intent i=new Intent(getApplicationContext(),Dashboard.class);
                startActivity(i);
                finish();
            }else {
                Intent i = new Intent(Splash.this, Introduction.class);
                startActivity(i);
                finish();
            }
        }, 2000);



    }
}