package com.example.android_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_test.Helper.DBHelper;

public class Sign_In extends AppCompatActivity {
        ImageView img;
        TextView txt1,txt2;
        AppCompatButton button;
    TextView edt1,edt2;
    EditText email,password;
    View v,v2;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        img=findViewById(R.id.signin_backbtn);
        txt1=findViewById(R.id.s_in_txt1);
        txt2=findViewById(R.id.s_in_txt2);
        button=findViewById(R.id.sign_in);

        v=findViewById(R.id.ed1_line4);
        v2=findViewById(R.id.ed1_line5);

        edt1=findViewById(R.id.ed1_txt4);
        edt2=findViewById(R.id.ed1_txt5);


        email = findViewById(R.id.email2_ed);
        password = findViewById(R.id.pass2_ed);

        dbHelper=new DBHelper(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             String emailvalue =email.getText().toString();
                String passwordvalue =password.getText().toString();

                if (!emailvalue.isEmpty() && !passwordvalue.isEmpty()) {


                if(dbHelper.checkusermailpass(emailvalue,passwordvalue)) {
                    email.setText("");
                    password.setText("");
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

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Sign_In.this, Registration_fb_google.class);
                startActivity(i);
                finish();
            }
        });
//
        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Sign_In.this,Registration.class);
                startActivity(i);
                finish();
            }
        });

        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Sign_In.this,Registration.class);
                startActivity(i);
                finish();
            }
        });





        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
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

        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
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


    }
}