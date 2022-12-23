package com.example.android_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_test.Helper.DbManager;

public class Sign_In extends AppCompatActivity {
        ImageView img,successimg;
        TextView txt1,txt2;
        AppCompatButton button;
    TextView edt1,edt2;
    EditText emailed,passworded;
    View v,v2;
    DbManager dbManager;
    String email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
//
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);


        img=findViewById(R.id.signin_backbtn);
        txt1=findViewById(R.id.s_in_txt1);
        txt2=findViewById(R.id.s_in_txt2);
        button=findViewById(R.id.sign_in);

        successimg =findViewById(R.id.validimg4);
        v=findViewById(R.id.ed1_line4);
        v2=findViewById(R.id.ed1_line5);

        edt1=findViewById(R.id.ed1_txt4);
        edt2=findViewById(R.id.ed1_txt5);


        emailed = findViewById(R.id.email2_ed);
        passworded = findViewById(R.id.pass2_ed);

        dbManager =new  DbManager(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               email =emailed.getText().toString();
                password =passworded.getText().toString();

                if (!email.isEmpty() && !password.isEmpty()) {


                if(dbManager.checkusermailpass(email,password)) {
                    emailed.setText("");
                    passworded.setText("");
                    Toast.makeText(Sign_In.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), Dashboard.class);
                    startActivity(i);

                }else {
                    Toast.makeText(Sign_In.this, "Invalid User", Toast.LENGTH_SHORT).show();
                }
                }else{
                    Toast.makeText(Sign_In.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

        emailed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                email =emailed.getText().toString();
                if ( Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    emailed.setError(null);
                    successimg.setImageResource(R.drawable.success);
                    successimg.setVisibility(View.VISIBLE);

                }else {
                    successimg.setVisibility(View.INVISIBLE);
                    emailed.setError("Invalid input");

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


//        passworded.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                password =passworded.getText().toString();
//                if (passworded.length()!=8){
//                    Toast.makeText(Sign_In.this, "Password must be 8 character long", Toast.LENGTH_SHORT).show();
//                }else {
//
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Sign_In.this, Landing.class);
                startActivity(i);
                finish();
            }
        });
//
        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Sign_In.this, Sign_Up.class);
                startActivity(i);
                finish();
            }
        });

        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Sign_In.this, Sign_Up.class);
                startActivity(i);
                finish();
            }
        });





        emailed.setOnFocusChangeListener(new View.OnFocusChangeListener() {
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

        passworded.setOnFocusChangeListener((view, b) -> {
            if(b){
                v2.setBackgroundColor(Color.parseColor("#4552CB"));
                edt2.setTextColor(Color.parseColor("#4552CB"));
            }else {
                v2.setBackgroundColor(Color.parseColor("#BBC3CE"));
                edt2.setTextColor(Color.parseColor("#CCCCCC"));
            }
        });


    }
}