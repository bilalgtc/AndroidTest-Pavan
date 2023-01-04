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
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class AddDetails extends AppCompatActivity implements View.OnClickListener {

    CardView cardView01, cardView02;
    ImageView imageView, imageView2, male_img, female_img;
    CircleImageView img;
    TextView textView, male1_txt, female1_txt;
    EditText ed1, ed2, ed3, ed4;
    Button button;
    SwitchCompat sw1;
    SwitchCompat sw2;
    SwitchCompat sw3;
    SwitchCompat sw4;
    SwitchCompat sw5;
    SwitchCompat sw6;
    Bitmap imgToStore;
    String[] state = {"true", "false"};
    public boolean isEditMode = false;

    private static final int CAMERA_REQUEST_CODE = 100;
    private static final int STORAGE_REQUEST_CODE = 101;
    //IMAGE PICK
    private static final int IMAGE_PICK_CAMERA_CODE = 102;
    private static final int IMAGE_PICK_GALLERY_CODE = 103;
    String id, image, name, species, breed, size, gender, neutered, vaccinated, Friendlywithdogs, Friendlywithcats, Friendlywithkids10, Friendlywithkids10G;
    String[] cameraPermissions;
    String[] storagePermissions;
    private Uri imageUri;
    Bitmap bitmap;
    int temp;
    DatabaseReference databaseReference;
    StorageReference storageReference;

    String[] value = {"false", "false", "false", "false", "false", "false"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_details);

        getWindow().setStatusBarColor(Color.TRANSPARENT);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.white));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        cameraPermissions = new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        storagePermissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};
        init();
        clicks();
        isEdit();

    }

    private void init() {

        databaseReference = FirebaseDatabase.getInstance().getReference().child("UserData");
        storageReference = FirebaseStorage.getInstance().getReference();

        male1_txt = findViewById(R.id.male_txt);
        female1_txt = findViewById(R.id.female_txt);

        male_img = findViewById(R.id.male_img);
        female_img = findViewById(R.id.female_img);

        female1_txt.setTextColor(Color.BLACK);
        male1_txt.setTextColor(Color.BLACK);

        male_img.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.black));
        female_img.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.black));

        cardView01 = findViewById(R.id.cardView);
        cardView02 = findViewById(R.id.cardView2);


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
        cardView01.setBackground(getDrawable(R.drawable.card_border));
        cardView01.setCardElevation(0);
        cardView02.setBackground(getDrawable(R.drawable.card_border));
        cardView02.setCardElevation(0);


    }

    private void clicks() {


        cardView01.setOnClickListener(this);
        cardView02.setOnClickListener(this);
        button.setOnClickListener(this);
        imageView.setOnClickListener(this);
        imageView2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.cardView:

                temp = 1;

                state[0] = String.valueOf(cardView01.isEnabled());
//                gender = String.valueOf(cardView01.isEnabled());
                cardView01.setBackground(getDrawable(R.drawable.card_blue_back));
                cardView01.setCardElevation(8);

                cardView02.setBackground(getDrawable(R.drawable.card_border));
                cardView02.setCardElevation(0);

                male1_txt.setTextColor(Color.WHITE);
                female1_txt.setTextColor(Color.BLACK);
                male_img.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white));
                female_img.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.black));
                break;

            case R.id.cardView2:

                temp = 1;

                state[1] = String.valueOf(cardView02.isEnabled());
//                gender = String.valueOf(cardView02.isEnabled());

                cardView02.setBackground(getDrawable(R.drawable.card_blue_back));
                cardView02.setCardElevation(8);

                cardView01.setBackground(getDrawable(R.drawable.card_border));
                cardView01.setCardElevation(0);

                female1_txt.setTextColor(Color.WHITE);
                male1_txt.setTextColor(Color.BLACK);
                female_img.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white));
                male_img.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.black));
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


    private void isEdit() {
        Intent i = getIntent();
        isEditMode = i.getBooleanExtra("isEditMode", false);
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

            image = i.getStringExtra("image");


            if (image == null) {
                Toast.makeText(this, "No Image", Toast.LENGTH_SHORT).show();
            } else {
                Picasso.get().load(image).into(img);
            }


            ed1.setText(name);
            ed2.setText(species);
            ed3.setText(breed);
            ed4.setText(size);


            if (gender.equals("true")) {

                cardView02.setBackground(getDrawable(R.drawable.card_blue_back));
                cardView02.setCardElevation(8);

                cardView01.setBackground(getDrawable(R.drawable.card_border));
                cardView01.setCardElevation(0);

                female1_txt.setTextColor(Color.WHITE);
                male1_txt.setTextColor(Color.BLACK);

                female_img.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white));
                male_img.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.black));

            } else if (gender.equals("false")) {

                cardView01.setBackground(getDrawable(R.drawable.card_blue_back));
                cardView01.setCardElevation(8);

                cardView02.setBackground(getDrawable(R.drawable.card_border));
                cardView02.setCardElevation(0);

                female1_txt.setTextColor(Color.BLACK);
                male1_txt.setTextColor(Color.WHITE);
                male_img.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white));
                female_img.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.black));

            } else {
                cardView01.setBackground(getDrawable(R.drawable.card_border));
                cardView01.setCardElevation(0);

                cardView02.setBackground(getDrawable(R.drawable.card_border));
                cardView02.setCardElevation(0);

                male1_txt.setTextColor(Color.BLACK);
                female1_txt.setTextColor(Color.BLACK);
            }

            if (neutered.equals("true")) {
                sw1.setChecked(true);
            } else if (neutered.equals("false")) {
                sw1.setChecked(false);
            } else {
                sw1.setChecked(false);
            }

            if (vaccinated.equals("true")) {
                sw2.setChecked(true);
            } else if (vaccinated.equals("false")) {
                sw2.setChecked(false);
            } else {
                sw2.setChecked(false);
            }

            if (Friendlywithdogs.equals("true")) {
                sw3.setChecked(true);
            } else if (Friendlywithdogs.equals("false")) {
                sw3.setChecked(false);
            } else {
                sw3.setChecked(false);
            }

            if (Friendlywithcats.equals("true")) {
                sw4.setChecked(true);
            } else if (Friendlywithcats.equals("false")) {
                sw4.setChecked(false);
            } else {
                sw4.setChecked(false);
            }

            if (Friendlywithkids10.equals("true")) {
                sw5.setChecked(true);
            } else if (Friendlywithkids10.equals("false")) {
                sw5.setChecked(false);
            } else {
                sw5.setChecked(false);
            }

            if (Friendlywithkids10G.equals("true")) {
                sw6.setChecked(true);
            } else if (Friendlywithkids10G.equals("false")) {
                sw6.setChecked(false);
            } else {
                sw6.setChecked(false);
            }
        }
    }


    public void details() {
        name = ed1.getText().toString();
        species = ed2.getText().toString();
        breed = ed3.getText().toString();
        size = ed4.getText().toString();


        value[0] = String.valueOf(sw1.isChecked());
        value[1] = String.valueOf(sw2.isChecked());
        value[2] = String.valueOf(sw3.isChecked());
        value[3] = String.valueOf(sw4.isChecked());
        value[4] = String.valueOf(sw5.isChecked());
        value[5] = String.valueOf(sw6.isChecked());


        if (isEditMode) {           //for true

            HashMap<String, Object> map = new HashMap<>();


            if (imageUri == null) {
                Picasso.get().load(image).into(img);
//                Toast.makeText(this, "Null", Toast.LENGTH_SHORT).show();
            } else {
                StorageReference file = storageReference.child(System.currentTimeMillis() + "." + getFileExtension(imageUri));
                file.putFile(imageUri);
                map.put("image", imageUri.toString());
//                StorageReference file = storageReference.child(System.currentTimeMillis() + "." + getFileExtension(imageUri));
//                file.putFile(imageUri);

            }

            map.put("name", name);
            map.put("species", species);
            map.put("breed", breed);
            map.put("size", size);
            map.put("gender", state[0]);
            map.put("gender", state[1]);
            map.put("neutered", value[0]);
            map.put("vaccinated", value[1]);
            map.put("Friendlywithdogs", value[2]);
            map.put("Friendlywithcats", value[3]);
            map.put("Friendlywithkids10", value[4]);
            map.put("Friendlywithkids10G", value[5]);

            String id = getIntent().getStringExtra("id");

            databaseReference.child(id).updateChildren(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    ed1.setText("");
                    ed2.setText("");
                    ed3.setText("");
                    ed4.setText("");
                    button.setEnabled(false);
                    Toast.makeText(AddDetails.this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), Dashboard.class));
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(AddDetails.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            });


        } else if (name.isEmpty() || species.isEmpty() || breed.isEmpty()) {
            Toast.makeText(AddDetails.this, "Fields are empty", Toast.LENGTH_SHORT).show();


        } else if (imgToStore == null) {

            Toast.makeText(this, "Add Image", Toast.LENGTH_SHORT).show();

        } else if (temp != 1) {
            Toast.makeText(this, "Select Gender", Toast.LENGTH_SHORT).show();
        } else {

            String id = databaseReference.push().getKey();

            StorageReference file = storageReference.child(System.currentTimeMillis() + "." + getFileExtension(imageUri));
            file.putFile(imageUri);

            HashMap<String, Object> map = new HashMap<>();
            map.put("id", id);
            map.put("image", imageUri.toString());
            map.put("name", name);
            map.put("species", species);
            map.put("breed", breed);
            map.put("size", size);
            map.put("gender", state[0]);
            map.put("gender", state[1]);
            map.put("neutered", value[0]);
            map.put("vaccinated", value[1]);
            map.put("Friendlywithdogs", value[2]);
            map.put("Friendlywithcats", value[3]);
            map.put("Friendlywithkids10", value[4]);
            map.put("Friendlywithkids10G", value[5]);


            databaseReference.child(id).setValue(map).addOnSuccessListener(new OnSuccessListener<Void>() {

                @Override
                public void onSuccess(Void unused) {
                    ed1.setText("");
                    ed2.setText("");
                    ed3.setText("");
                    ed4.setText("");
                    button.setEnabled(false);
                    Toast.makeText(AddDetails.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), Dashboard.class));
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(AddDetails.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private String getFileExtension(Uri muri) {

        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(muri));
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
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), Dashboard.class);
        startActivity(intent);
    }
}

