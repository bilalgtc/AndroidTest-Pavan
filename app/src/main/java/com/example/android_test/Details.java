package com.example.android_test;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class Details extends AppCompatActivity implements View.OnClickListener {
        CardView cardView1,cardView2;
        ImageView imageView,imageView2;
        CircleImageView img;
    TextView textView;
    int temp=0;
    EditText ed1,ed2,ed3,ed4;
    Button button;
    Switch sw1,sw2,sw3,sw4,sw5,sw6;
    Bitmap imageDB;
    Bitmap imgToStore;

    private static final int CAMERA_REQUEST_CODE = 100;
    private static final int STORAGE_REQUEST_CODE = 101;
    //IMAGE PICK
    private static final int IMAGE_PICK_CAMERA_CODE = 102;
    private static final int IMAGE_PICK_GALLERY_CODE = 103;

    String[] cameraPermissions;
    String[] storagePermissions;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        cameraPermissions = new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE};
        storagePermissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};

        cardView1=findViewById(R.id.cardView);
        cardView2=findViewById(R.id.cardView2);
        textView=findViewById(R.id.textView15);

        imageView=findViewById(R.id.details_back_btn);
        imageView2=findViewById(R.id.add_image);
        img =findViewById(R.id.circleImageView);


        ed1=findViewById(R.id.name_ed);
        ed2=findViewById(R.id.species_ed);
        ed3=findViewById(R.id.breed_ed);
        ed4=findViewById(R.id.size_ed);


//        sw1=findViewById(R.id.s1);
//        sw2=findViewById(R.id.s2);
//        sw3=findViewById(R.id.s3);
//        sw4=findViewById(R.id.s4);
//        sw5=findViewById(R.id.s5);
//        sw6=findViewById(R.id.s6);

        button=findViewById(R.id.submit_btn);
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
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imagePickDialog();
            }
        });


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
        private void imagePickDialog(){

        String[] options = {"Camera","Gallery"};

            AlertDialog.Builder builder =new AlertDialog.Builder(this);
            builder.setTitle("Pick image from");

            builder.setItems(options, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (i==0){
                        if (!checkCameraPermission()){
                            requestCameraPermission();
                        }else{
                                pickFromCamera();
                        }
                    }else if(i==1){
                            if (!checkStoragePermission()){
                                requestStoragePermission();
                            }else{
                                pickFromGallery();
                            }
                    }
                }
            });
            builder.create().show();
        }



    private void pickFromGallery() {
        Intent i=new Intent(Intent.ACTION_PICK);
        i.setType("image/*");
        startActivityIfNeeded(i,IMAGE_PICK_GALLERY_CODE);
    }

    private void pickFromCamera() {
        ContentValues values=new ContentValues();
        values.put(MediaStore.Images.Media.TITLE,"Image Title" );
        values.put(MediaStore.Images.Media.DESCRIPTION,"Image Title" );

        imageUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(cameraIntent, IMAGE_PICK_CAMERA_CODE);
    }

    private boolean checkStoragePermission(){
        boolean result = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) ==(PackageManager.PERMISSION_GRANTED);
        return result;
    }

    private void requestStoragePermission(){
        ActivityCompat.requestPermissions(this, storagePermissions, STORAGE_REQUEST_CODE);
    }

    private boolean checkCameraPermission(){
        boolean result =ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == (PackageManager.PERMISSION_GRANTED);
        boolean result1 =ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == (PackageManager.PERMISSION_GRANTED);
        return result & result1;
    }

    private  void requestCameraPermission(){
        ActivityCompat.requestPermissions(this, cameraPermissions, CAMERA_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){

            case CAMERA_REQUEST_CODE:{
                if (grantResults.length>0){

                    boolean cameraAccepted =grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean storageAccepted =grantResults[1] == PackageManager.PERMISSION_GRANTED;

                    if (cameraAccepted && storageAccepted){
                        pickFromCamera();
                    }else{
                        Toast.makeText(this, "Camera & Storage Permission Required", Toast.LENGTH_SHORT).show();
                    }
                }

            }
            break;

            case STORAGE_REQUEST_CODE:{
                if (grantResults.length>0){
                    boolean storageAccepted =grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    if (storageAccepted){
                        pickFromGallery();
                    }else {
                        Toast.makeText(this, "Storage Permission Required...", Toast.LENGTH_SHORT).show();
                    }
                }

            }
            break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            if (requestCode == IMAGE_PICK_GALLERY_CODE){
                imageUri= data.getData();
//                img.setImageURI(data.getData());
                 imgToStore = null;
                try {
                    imgToStore = MediaStore.Images.Media.getBitmap(getContentResolver(),imageUri);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                img.setImageBitmap(imgToStore);
            }

        }
    }
}