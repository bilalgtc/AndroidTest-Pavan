package com.example.android_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_test.Helper.DBHelper;
import com.google.android.material.textfield.TextInputLayout;

public class Registration extends AppCompatActivity {

    TextView textView,textView1,textView2;
    TextView edt1,edt2,edt3,edt4;
    AppCompatButton button;
    EditText name,email,mobile,password;
    View v,v2,v3,v4;
//    TextInputLayout name,email,mobile,password;
    ImageView imageView,imageView2,imageView3;
    int temp=0;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        textView = findViewById(R.id.checkbox_txt1);
        String text = "I agree with the rules";
        SpannableString s1 = new SpannableString(text);


        ForegroundColorSpan fc = new ForegroundColorSpan(Color.parseColor("#4552CB"));
        UnderlineSpan ss2 = new UnderlineSpan();

        s1.setSpan(ss2, 13, 22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        s1.setSpan(fc, 13, 22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(s1);

        v=findViewById(R.id.ed1_line1);
        v2=findViewById(R.id.ed1_line2);
        v3=findViewById(R.id.ed1_line3);
        v4=findViewById(R.id.ed1_line4);

        edt1=findViewById(R.id.ed1_txt1);
        edt2=findViewById(R.id.ed1_txt2);
        edt3=findViewById(R.id.ed1_txt3);
        edt4=findViewById(R.id.ed1_txt4);

        button = findViewById(R.id.signup_btn);


        email = findViewById(R.id.email_ed);
        password = findViewById(R.id.pass_ed);
        name = findViewById(R.id.name_ed);
        mobile = findViewById(R.id.mobile_ed);


        textView1=findViewById(R.id.goto_signin1);
        textView2=findViewById(R.id.goto_signin2);
        imageView=findViewById(R.id.reg_backbtn);
        imageView2=findViewById(R.id.checkbox_img1);
        imageView3=findViewById(R.id.checkbox_img2);

        dbHelper = new DBHelper(this);


        name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    v.setBackgroundColor(Color.parseColor("#4552CB"));
                    edt1.setTextColor(Color.parseColor("#4552CB"));
                }else {
                    v.setBackgroundColor(Color.parseColor("#BBC3CE"));
                    edt1.setTextColor(Color.parseColor("#CCCCCC"));
                }
            }
        });



        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    v2.setBackgroundColor(Color.parseColor("#4552CB"));
                    edt2.setTextColor(Color.parseColor("#4552CB"));
                }else {
                    v2.setBackgroundColor(Color.parseColor("#BBC3CE"));
                    edt2.setTextColor(Color.parseColor("#CCCCCC"));
                }
            }
        });

        mobile.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    v3.setBackgroundColor(Color.parseColor("#4552CB"));
                    edt3.setTextColor(Color.parseColor("#4552CB"));
                }else {
                    v3.setBackgroundColor(Color.parseColor("#BBC3CE"));
                    edt3.setTextColor(Color.parseColor("#CCCCCC"));
                }
            }
        });


        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    v4.setBackgroundColor(Color.parseColor("#4552CB"));
                    edt4.setTextColor(Color.parseColor("#4552CB"));
                }else {
                    v4.setBackgroundColor(Color.parseColor("#BBC3CE"));
                    edt4.setTextColor(Color.parseColor("#CCCCCC"));
                }
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (temp==0){
                    imageView2.setImageResource(R.drawable.activeted);
                    temp++;
                }else if (temp==1){
                    imageView2.setImageResource(R.drawable.disabled);
                    temp--;
                }

            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (temp==0){
                    imageView3.setImageResource(R.drawable.activeted);
                    temp++;

                }else if (temp==1){
                    imageView3.setImageResource(R.drawable.disabled);
                    temp--;
                }

            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Registration.this, Registration_fb_google.class);
                startActivity(i);
                finish();
            }
        });

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Registration.this,Sign_In.class);
                startActivity(i);
                finish();
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Registration.this,Sign_In.class);
                startActivity(i);
                finish();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailvalue=email.getText().toString();
                String passwordvalue=password.getText().toString();
                String uname = name.getText().toString();
                String umobile = mobile.getText().toString();

                    if (uname.equals("") || emailvalue.equals("") || umobile.equals("") || passwordvalue.equals("")){
                        name.setError("Field is empty");
                        email.setError("Field is empty");
                        mobile.setError("Field is empty");
                        password.setError("Field is empty");
                    }else{
                        if (uname.length()>1) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("email", emailvalue);
                            contentValues.put("password", passwordvalue);
                            contentValues.put("username", uname);
                            contentValues.put("mobile", umobile);
                            dbHelper.addUser(contentValues);

                            Toast.makeText(Registration.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(getApplicationContext(),Sign_In.class);
                            startActivity(i);

                        }else{
                            Toast.makeText(Registration.this, "Failed", Toast.LENGTH_SHORT).show();
                        }

//                        Boolean usercheckresult =dbHelper.checkuser(emailvalue);
//                        if (usercheckresult == false){
//
//                            Boolean regresult = dbHelper.insertData(emailvalue, passwordvalue, uname, umobile);
//                                if (regresult == true){
//                                    Toast.makeText(Registration.this, "Registration Successful", Toast.LENGTH_SHORT).show();
//                                }else{
//                                    Toast.makeText(Registration.this, "Failed", Toast.LENGTH_SHORT).show();
//                                }
//
//                        }else {
//                            Toast.makeText(Registration.this, "User already exists", Toast.LENGTH_SHORT).show();
//                        }
                    }




            }
        });
    }
//
//    private boolean check(){
//        String n=name.getEditText().getText().toString().trim();
//
//        if (n.isEmpty()){
//            name.setError("Field is Empty");
//            return  false;
//        }else{
//            name.setError(null);
//            return true;
//        }
//    }

}