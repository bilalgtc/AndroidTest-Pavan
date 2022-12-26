package com.example.android_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_test.Helper.DbManager;

public class Sign_In extends AppCompatActivity implements View.OnClickListener {
    ImageView img, successimg, password_eye;
    TextView txt1, txt2;
    AppCompatButton button;
    TextView edt1, edt2;
    EditText emailed, passworded;
    View v, v2;
    DbManager dbManager;
    String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

        init();

        dbManager = new DbManager(this);
        img.setOnClickListener(this);
        txt1.setOnClickListener(this);
        txt2.setOnClickListener(this);
        button.setOnClickListener(this);
        password_eye.setOnClickListener(this);


        emailed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                email = emailed.getText().toString();
                if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    successimg.setImageResource(R.drawable.success);
                    successimg.setVisibility(View.VISIBLE);

                } else {
                    successimg.setVisibility(View.INVISIBLE);

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        emailed.setOnFocusChangeListener((view, b) -> {
            if (b) {
                v.setBackgroundColor(Color.parseColor("#4552CB"));
                edt1.setTextColor(Color.parseColor("#4552CB"));
            } else {
                v.setBackgroundColor(Color.parseColor("#BBC3CE"));
                edt1.setTextColor(Color.parseColor("#CCCCCC"));
            }
        });

        passworded.setOnFocusChangeListener((view, b) -> {
            if (b) {
                v2.setBackgroundColor(Color.parseColor("#4552CB"));
                edt2.setTextColor(Color.parseColor("#4552CB"));
            } else {
                v2.setBackgroundColor(Color.parseColor("#BBC3CE"));
                edt2.setTextColor(Color.parseColor("#CCCCCC"));
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signin_backbtn:
                Intent i = new Intent(Sign_In.this, Landing.class);
                startActivity(i);
                finish();
                break;

            case R.id.s_in_txt1:

            case R.id.s_in_txt2:
                Intent i2 = new Intent(Sign_In.this, Sign_Up.class);
                startActivity(i2);
                finish();
                break;

            case R.id.in_password_toggle:

                if (passworded.getTransformationMethod().getClass().getSimpleName().equals("PasswordTransformationMethod")) {
                    passworded.setTransformationMethod(new SingleLineTransformationMethod());
                    password_eye.setImageResource(R.drawable.remove_red_eye_24);
                } else {
                    passworded.setTransformationMethod(new PasswordTransformationMethod());
                    password_eye.setImageResource(R.drawable.invisible_eye);
                }

                passworded.setSelection(passworded.getText().length());
                break;


            case R.id.sign_in:
                email = emailed.getText().toString();
                password = passworded.getText().toString();

                if (!email.isEmpty() && !password.isEmpty()) {


                    if (dbManager.checkusermailpass(email, password)) {
                        emailed.setText("");
                        passworded.setText("");
                        Toast.makeText(Sign_In.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent i3 = new Intent(getApplicationContext(), Dashboard.class);
                        startActivity(i3);

                    } else {
                        Toast.makeText(Sign_In.this, "Invalid User", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Sign_In.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }

    private void init() {


        img = findViewById(R.id.signin_backbtn);
        successimg = findViewById(R.id.up_password_toggle);
        password_eye = findViewById(R.id.in_password_toggle);

        v = findViewById(R.id.ed1_line4);
        v2 = findViewById(R.id.ed1_line5);

        button = findViewById(R.id.sign_in);

        txt2 = findViewById(R.id.s_in_txt2);
        txt1 = findViewById(R.id.s_in_txt1);

        edt1 = findViewById(R.id.ed1_txt4);
        edt2 = findViewById(R.id.ed1_txt5);


        emailed = findViewById(R.id.email2_ed);
        passworded = findViewById(R.id.pass2_ed);

    }
}
