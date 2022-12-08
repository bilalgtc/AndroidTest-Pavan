package com.example.android_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {
    TextView textView;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        textView =findViewById(R.id.dash_textView);
        recyclerView =findViewById(R.id.dash_recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String text="What are you\nlooking for, Maria?";
        SpannableString s=new SpannableString(text);
        ForegroundColorSpan fc=new ForegroundColorSpan(Color.parseColor("#ffcf6f"));

        s.setSpan(fc, 25, 32, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(s);
    }
}