package com.example.android_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_test.Models.Recycle_model;

public class Details extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView, img2, img3, img4, img5, img6, img7, img8;
    String id, name, species, breed, size, gender, neutered, vaccinated, Friendlywithdogs, Friendlywithcats, Friendlywithkids10, Friendlywithkids10G;
    TextView txt1, txt2, txt3, txt4, txt5;
    byte[] image;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(1);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

        setContentView(R.layout.activity_details);

        init();
        clicks();


        Intent i = getIntent();
        name = i.getStringExtra("name");
        species = i.getStringExtra("species");
        breed = i.getStringExtra("breed");
        size = i.getStringExtra("size");
        gender = i.getStringExtra("gender");
        neutered = i.getStringExtra("neutered");
        vaccinated = i.getStringExtra("vaccinated");
        Friendlywithdogs = i.getStringExtra("Friendlywithdogs");
        Friendlywithcats = i.getStringExtra("Friendlywithcats");
        Friendlywithkids10 = i.getStringExtra("Friendlywithkids10");
        Friendlywithkids10G = i.getStringExtra("Friendlywithkids10G");

        image = i.getByteArrayExtra("image");
        bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);


        if (image == null) {
            Toast.makeText(this, "No Image", Toast.LENGTH_SHORT).show();
        } else {
            img2.setImageBitmap(bitmap);
        }


        txt1.setText(name);
        txt2.setText(species);
        txt3.setText(breed);
        txt4.setText(size);
        txt5.setText(gender);

        if (neutered.equals("1")) {
            img3.setImageResource(R.drawable.success);
        } else {
            img3.setImageResource(R.drawable.cross_cicle);
        }

        if (vaccinated.equals("1")) {
            img4.setImageResource(R.drawable.success);
        } else {
            img4.setImageResource(R.drawable.cross_cicle);
        }

        if (Friendlywithdogs.equals("1")) {
            img5.setImageResource(R.drawable.success);
        } else {
            img5.setImageResource(R.drawable.cross_cicle);
        }

        if (Friendlywithcats.equals("1")) {
            img6.setImageResource(R.drawable.success);
        } else {
            img6.setImageResource(R.drawable.cross_cicle);
        }

        if (Friendlywithkids10.equals("1")) {
            img7.setImageResource(R.drawable.success);
        } else {
            img7.setImageResource(R.drawable.cross_cicle);
        }

        if (Friendlywithkids10G.equals("1")) {
            img8.setImageResource(R.drawable.success);
        } else {
            img8.setImageResource(R.drawable.cross_cicle);
        }


    }


    private void init() {
        imageView = findViewById(R.id.info_back_btn);
        txt1 = findViewById(R.id.dogname_txt);
        txt2 = findViewById(R.id.breed_txt);
        txt3 = findViewById(R.id.breed_name_txt);
        txt4 = findViewById(R.id.gender2_txt);
        txt5 = findViewById(R.id.size_txt);

        img2 = findViewById(R.id.imageView10);
        img3 = findViewById(R.id.s1);
        img4 = findViewById(R.id.s2);
        img5 = findViewById(R.id.s3);
        img6 = findViewById(R.id.s4);
        img7 = findViewById(R.id.s5);
        img8 = findViewById(R.id.s6);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.info_back_btn:
                Intent i = new Intent(getApplicationContext(), Dashboard.class);
                startActivity(i);
                break;
        }
    }

    private void clicks() {
        imageView.setOnClickListener(this);
    }
}