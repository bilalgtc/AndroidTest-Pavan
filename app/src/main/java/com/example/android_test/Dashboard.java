package com.example.android_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android_test.Adapters.Recycle_adapter;
import com.example.android_test.Models.Recycle_model;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {
    TextView textView;
    RecyclerView recyclerView;
    ArrayList<Recycle_model> details=new ArrayList<>();

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

        details.add(new Recycle_model(R.drawable.dogimg, "Troy", "German Shepherd"));
        details.add(new Recycle_model(R.drawable.dogimg2, "Oscar", "Labrador Retriever"));
        details.add(new Recycle_model(R.drawable.dogimg3, "Light", "Poodle"));
        details.add(new Recycle_model(R.drawable.dogimg4, "Bosco", "Rottweiler"));
        details.add(new Recycle_model(R.drawable.dogimg4, "Night", "Rottweiler"));
        details.add(new Recycle_model(R.drawable.dogimg4, "Sky", "Rottweiler"));

        Recycle_adapter adapter=new Recycle_adapter(this,details);
        recyclerView.setAdapter(adapter);
     }
}