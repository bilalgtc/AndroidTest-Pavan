package com.example.android_test;

import static android.graphics.Color.TRANSPARENT;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
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
        cardView2=findViewById(R.id.cardView2);
        textView=findViewById(R.id.textView15);

        cardView1.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));
        cardView2.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));


        cardView1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                cardView1.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.blue));
            }
        });


        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cardView2.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.blue));
            }
        });

        


    }
}