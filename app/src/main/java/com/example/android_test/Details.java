package com.example.android_test;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.android_test.Helper.DatabaseHelper;

import java.io.ByteArrayOutputStream;

import de.hdodenhof.circleimageview.CircleImageView;

//implements View.OnClickListener
public class Details extends AppCompatActivity implements View.OnClickListener {

    CardView cardView01, cardView02;
    ImageView imageView, imageView2;
    CircleImageView img;
    TextView textView;
    EditText ed1, ed2, ed3, ed4;
    Button button;
    SwitchCompat sw1;
    SwitchCompat sw2;
    SwitchCompat sw3;
    SwitchCompat sw4;
    SwitchCompat sw5;
    SwitchCompat sw6;
    Bitmap imageDB;
    Bitmap imgToStore;
    byte[] image;
    boolean[] state = {true, false};
    public boolean isEditMode = false;
    DatabaseHelper dbhelper;

    private static final int CAMERA_REQUEST_CODE = 100;
    private static final int STORAGE_REQUEST_CODE = 101;
    //IMAGE PICK
    private static final int IMAGE_PICK_CAMERA_CODE = 102;
    private static final int IMAGE_PICK_GALLERY_CODE = 103;
    String id, name, species, breed, size, gender, neutered, vaccinated, Friendlywithdogs, Friendlywithcats, Friendlywithkids10, Friendlywithkids10G;
    String[] cameraPermissions;
    String[] storagePermissions;
    private Uri imageUri;
    Bitmap bitmap;

    boolean[] value = {false, false, false, false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        cameraPermissions = new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        storagePermissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};

        init();


        dbhelper = new DatabaseHelper(this);

        Intent i = getIntent();
        isEditMode = i.getBooleanExtra("isEditMode", false);

        cardView01.setOnClickListener(this);
        cardView02.setOnClickListener(this);
        button.setOnClickListener(this);
        imageView.setOnClickListener(this);
        imageView2.setOnClickListener(this);

        if (isEditMode) {
            id = i.getStringExtra("id");
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

            byte[] image3 = i.getByteArrayExtra("image");

//            if (image3!=null) {
//                 bitmap = BitmapFactory.decodeByteArray(image3, 0, image3.length);
//                img.setImageBitmap(bitmap);
//            }else {
//                img.setImageResource(R.drawable.dogimg);
//            }

            if (image3 == null) {
                img.setImageResource(R.drawable.dogimg);
            } else if (image3.equals(image3)) {
                img.setImageBitmap(bitmap);
            } else {
                bitmap = BitmapFactory.decodeByteArray(image3, 0, image3.length);
                img.setImageBitmap(bitmap);
            }

            ed1.setText(name);
            ed2.setText(species);
            ed3.setText(breed);
            ed4.setText(size);


            if (gender.equals("1")) {
                cardView02.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.blue));
                cardView01.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));
            } else if (gender.equals("0")) {
                cardView01.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.blue));
                cardView02.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));
            } else {
                cardView01.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));
                cardView02.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));
            }

            if (neutered.equals("1")) {
                sw1.setChecked(true);
            } else if (neutered.equals("0")) {
                sw1.setChecked(false);
            } else {
                sw1.setChecked(false);
            }

            if (vaccinated.equals("1")) {
                sw2.setChecked(true);
            } else if (vaccinated.equals("0")) {
                sw2.setChecked(false);
            } else {
                sw2.setChecked(false);
            }

            if (Friendlywithdogs.equals("1")) {
                sw3.setChecked(true);
            } else if (Friendlywithdogs.equals("0")) {
                sw3.setChecked(false);
            } else {
                sw3.setChecked(false);
            }

            if (Friendlywithcats.equals("1")) {
                sw4.setChecked(true);
            } else if (Friendlywithcats.equals("0")) {
                sw4.setChecked(false);
            } else {
                sw4.setChecked(false);
            }

            if (Friendlywithkids10.equals("1")) {
                sw5.setChecked(true);
            } else if (Friendlywithkids10.equals("0")) {
                sw5.setChecked(false);
            } else {
                sw5.setChecked(false);
            }

            if (Friendlywithkids10G.equals("1")) {
                sw6.setChecked(true);
            } else if (Friendlywithkids10G.equals("0")) {
                sw6.setChecked(false);
            } else {
                sw6.setChecked(false);
            }
        }
    }

    private void imagePickDialog() {

        String[] options = {"Camera", "Gallery"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Pick image from");

        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    if (!checkCameraPermission()) {
                        requestCameraPermission();
                    } else {
                        pickFromCamera();
                    }
                } else if (i == 1) {
                    if (!checkStoragePermission()) {
                        requestStoragePermission();
                    } else {
                        pickFromGallery();
                    }
                }
            }
        });
        builder.create().show();
    }


    private void pickFromGallery() {
        Intent i = new Intent(Intent.ACTION_PICK);
        i.setType("image/*");
        startActivityIfNeeded(i, IMAGE_PICK_GALLERY_CODE);
    }

    private void pickFromCamera() {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "Image Title");
        values.put(MediaStore.Images.Media.DESCRIPTION, "Image Title");

        imageUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(cameraIntent, IMAGE_PICK_CAMERA_CODE);
    }

    private boolean checkStoragePermission() {
        boolean result = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == (PackageManager.PERMISSION_GRANTED);
        return result;
    }

    private void requestStoragePermission() {
        ActivityCompat.requestPermissions(this, storagePermissions, STORAGE_REQUEST_CODE);
    }

    private boolean checkCameraPermission() {
        boolean result = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == (PackageManager.PERMISSION_GRANTED);
        boolean result1 = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == (PackageManager.PERMISSION_GRANTED);
        return result & result1;
    }

    private void requestCameraPermission() {
        ActivityCompat.requestPermissions(this, cameraPermissions, CAMERA_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {

            case CAMERA_REQUEST_CODE: {
                if (grantResults.length > 0) {

                    boolean cameraAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean storageAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                    if (cameraAccepted && storageAccepted) {
                        pickFromCamera();
                    } else {
                        Toast.makeText(this, "Camera & Storage Permission Required", Toast.LENGTH_SHORT).show();
                    }
                }

            }
            break;

            case STORAGE_REQUEST_CODE: {
                if (grantResults.length > 0) {
                    boolean storageAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    if (storageAccepted) {
                        pickFromGallery();
                    } else {
                        Toast.makeText(this, "Storage Permission Required...", Toast.LENGTH_SHORT).show();
                    }
                }

            }
            break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        try {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == IMAGE_PICK_GALLERY_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {
                imageUri = data.getData();
                imgToStore = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                img.setImageBitmap(imgToStore);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.cardView:

                state[0] = cardView01.isEnabled();
                cardView01.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.blue));
                cardView02.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));
                break;

            case R.id.cardView2:

                state[1] = cardView02.isEnabled();
                cardView02.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.blue));
                cardView01.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));
                break;

            case R.id.details_back_btn:

                Intent i = new Intent(getApplicationContext(), Dashboard.class);
                startActivity(i);
                finish();
                break;

            case R.id.add_image:

                imagePickDialog();
                break;

                case R.id.submit_btn:

                    details();
                    break;


        }
    }

    private void init(){

        cardView01 = findViewById(R.id.cardView);
        cardView02 = findViewById(R.id.cardView2);

        cardView01.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));
        cardView02.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));



        textView = findViewById(R.id.textView15);

        imageView = findViewById(R.id.details_back_btn);
        imageView2 = findViewById(R.id.add_image);
        img = findViewById(R.id.circleImageView);


        ed1 = findViewById(R.id.name_ed);
        ed2 = findViewById(R.id.species_ed);
        ed3 = findViewById(R.id.breed_ed);
        ed4 = findViewById(R.id.size_ed);


        sw1 = findViewById(R.id.s1);
        sw2 = findViewById(R.id.s2);
        sw3 = findViewById(R.id.s3);
        sw4 = findViewById(R.id.s4);
        sw5 = findViewById(R.id.s5);
        sw6 = findViewById(R.id.s6);


        button = findViewById(R.id.submit_btn);

    }

    public void details(){
        ContentValues contentValues = new ContentValues();
        name = ed1.getText().toString();
        species = ed2.getText().toString();
        breed = ed3.getText().toString();
        size = ed4.getText().toString();

        if (isEditMode) {

            value[0] = sw1.isChecked();
            value[1] = sw2.isChecked();
            value[2] = sw3.isChecked();
            value[3] = sw4.isChecked();
            value[4] = sw5.isChecked();
            value[5] = sw6.isChecked();

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//                     if (img!=null) {
//                         img.setImageBitmap(imgToStore);
//                     }else {
//                         image = outputStream.toByteArray();
//                         imgToStore.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
//                     }

            if (imgToStore == null) {
                img.setImageResource(R.drawable.dogimg);
            } else {
                imgToStore.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                image = outputStream.toByteArray();
            }

            contentValues.put("image", image);
            contentValues.put("name", name);
            contentValues.put("species", species);
            contentValues.put("breed", breed);
            contentValues.put("size", size);
            contentValues.put("gender", state[0]);
            contentValues.put("gender", state[1]);
            contentValues.put("neutered", value[0]);
            contentValues.put("vaccinated", value[1]);
            contentValues.put("Friendlywithdogs", value[2]);
            contentValues.put("Friendlywithcats", value[3]);
            contentValues.put("Friendlywithkids10", value[4]);
            contentValues.put("Friendlywithkids10G", value[5]);


            boolean i = dbhelper.updateRecord(contentValues, id);
            if (i == true) {
                Toast.makeText(Details.this, "Updated", Toast.LENGTH_SHORT).show();
//                            new Handler().postDelayed(new Runnable() {
//                                @Override
//                                public void run() {
//                                    Intent intent=new Intent(getApplicationContext(),HomeFragment.class);
//                                    startActivity(intent);
//                                }
//                            }, 1000);

            } else {
                Toast.makeText(Details.this, "Failed", Toast.LENGTH_SHORT).show();
            }


        } else {

            if (name.isEmpty() && species.isEmpty() && breed.isEmpty() && size.isEmpty()) {
                Toast.makeText(Details.this, "Fields are empty", Toast.LENGTH_SHORT).show();
            } else {

                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                if (imgToStore == null) {
                    img.setImageResource(R.drawable.dogimg);
                } else {
                    imgToStore.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                    image = outputStream.toByteArray();
                }

                contentValues.put("image", image);
                contentValues.put("name", name);
                contentValues.put("species", species);
                contentValues.put("breed", breed);
                contentValues.put("size", size);

                value[0] = sw1.isChecked();
                value[1] = sw2.isChecked();
                value[2] = sw3.isChecked();
                value[3] = sw4.isChecked();
                value[4] = sw5.isChecked();
                value[5] = sw6.isChecked();


                contentValues.put("neutered", value[0]);
                contentValues.put("vaccinated", value[1]);
                contentValues.put("Friendlywithdogs", value[2]);
                contentValues.put("Friendlywithcats", value[3]);
                contentValues.put("Friendlywithkids10", value[4]);
                contentValues.put("Friendlywithkids10G", value[5]);
                contentValues.put("gender", state[0]);
                contentValues.put("gender", state[1]);

                boolean i = dbhelper.insertData(contentValues);
                if (i == true) {
                    Toast.makeText(Details.this, "Added", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                            startActivity(intent);
                            finish();
                        }
                    }, 2000);


                } else {
                    Toast.makeText(Details.this, "Failed", Toast.LENGTH_SHORT).show();
                }


            }
        }


    }
}