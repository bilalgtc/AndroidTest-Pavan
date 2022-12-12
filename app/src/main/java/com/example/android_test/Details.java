package com.example.android_test;

import static android.graphics.Color.TRANSPARENT;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends AppCompatActivity implements View.OnClickListener {
        CardView cardView1,cardView2;
        ImageView imageView;
        TextView textView;
        int temp=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        cardView1=findViewById(R.id.cardView);
        cardView2=findViewById(R.id.cardView2);
        textView=findViewById(R.id.textView15);

        imageView=findViewById(R.id.details_back_btn);

        cardView1.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));
        cardView2.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));



        cardView1.setOnClickListener(this);
        cardView2.setOnClickListener(this);

//        cardView1.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                cardView1.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.blue));
////                cardView2.setEnabled(false);
//
//
//            }
//        });
//
//
//        cardView2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                cardView2.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.blue));
////                cardView1.setEnabled(false);
//
//            }
//        });


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i=new Intent(getApplicationContext(),Dashboard.class);
                        startActivity(i);
                    }
                });
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.cardView:
                    if (cardView1.isEnabled()){
                        cardView2.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));
                    }
                cardView1.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.blue));
                break;


            case  R.id.cardView2:

                if (cardView2.isEnabled()){
                    cardView1.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));
                }
                cardView2.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.blue));
                break;


        }
    }
}