package com.example.android_test;

import static android.graphics.Color.TRANSPARENT;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Details extends AppCompatActivity {
        CardView cardView1,cardView2;

        TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        cardView1=findViewById(R.id.cardView);
        cardView1=findViewById(R.id.cardView);
        textView=findViewById(R.id.textView15);


        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             cardView1.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.blue));

            }
        });
    }
}