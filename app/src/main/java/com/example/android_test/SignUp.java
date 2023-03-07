package com.example.android_test;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.android_test.Helper.DbManager;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    TextView textView, textView1, textView2;
    TextView edt1, edt2, edt3, edt4;
    AppCompatButton button;
    EditText nameed, emailed, mobileed, passworded;
    View v, v2, v3, v4;
    ImageView imageView, imageView2, imageView3, imageView4, imageView5, imageView6, password_img;
    int temp = 0;
    DbManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

        init();
        clicks();
        txtEdit();


        nameed.setOnFocusChangeListener((view, b) -> {
            if (b) {
                v.setBackgroundColor(Color.parseColor("#4552CB"));
                edt1.setTextColor(Color.parseColor("#4552CB"));
            } else {
                v.setBackgroundColor(Color.parseColor("#BBC3CE"));
                edt1.setTextColor(Color.parseColor("#CCCCCC"));
            }
        });


        emailed.setOnFocusChangeListener((view, b) -> {
            if (b) {
                v2.setBackgroundColor(Color.parseColor("#4552CB"));
                edt2.setTextColor(Color.parseColor("#4552CB"));
            } else {
                v2.setBackgroundColor(Color.parseColor("#BBC3CE"));
                edt2.setTextColor(Color.parseColor("#CCCCCC"));
            }
        });

        mobileed.setOnFocusChangeListener((view, b) -> {
            if (b) {
                v3.setBackgroundColor(Color.parseColor("#4552CB"));
                edt3.setTextColor(Color.parseColor("#4552CB"));
            } else {
                v3.setBackgroundColor(Color.parseColor("#BBC3CE"));
                edt3.setTextColor(Color.parseColor("#CCCCCC"));
            }
        });


        passworded.setOnFocusChangeListener((view, b) -> {
            if (b) {
                v4.setBackgroundColor(Color.parseColor("#4552CB"));
                edt4.setTextColor(Color.parseColor("#4552CB"));
            } else {
                v4.setBackgroundColor(Color.parseColor("#BBC3CE"));
                edt4.setTextColor(Color.parseColor("#CCCCCC"));
            }
        });


        emailed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String email = emailed.getText().toString();
                if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    imageView4.setImageResource(R.drawable.success);
                    imageView4.setVisibility(View.VISIBLE);
                } else {
                    imageView4.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        nameed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String name = nameed.getText().toString();
                if (!name.isEmpty()) {
                    imageView5.setImageResource(R.drawable.success);
                    imageView5.setVisibility(View.VISIBLE);
                } else {
                    imageView5.setVisibility(View.INVISIBLE);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mobileed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String mobile = mobileed.getText().toString();
                if (mobile.length() == 10) {
                    imageView6.setImageResource(R.drawable.success);
                    imageView6.setVisibility(View.VISIBLE);
                } else {
                    imageView6.setVisibility(View.INVISIBLE);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    private void init() {

        v = findViewById(R.id.ed1_line1);
        v2 = findViewById(R.id.ed1_line2);
        v3 = findViewById(R.id.ed1_line3);
        v4 = findViewById(R.id.ed1_line4);

        edt1 = findViewById(R.id.ed1_txt1);
        edt2 = findViewById(R.id.ed1_txt2);
        edt3 = findViewById(R.id.ed1_txt3);
        edt4 = findViewById(R.id.ed1_txt4);

        button = findViewById(R.id.signup_btn);


        emailed = findViewById(R.id.email_ed);
        passworded = findViewById(R.id.pass_ed);
        nameed = findViewById(R.id.name_ed);
        mobileed = findViewById(R.id.mobile_ed);


        textView1 = findViewById(R.id.goto_signin1);
        textView2 = findViewById(R.id.goto_signin2);

        imageView = findViewById(R.id.reg_backbtn);
        imageView2 = findViewById(R.id.checkbox_img1);
        imageView3 = findViewById(R.id.checkbox_img2);

        imageView4 = findViewById(R.id.validimg2);
        imageView5 = findViewById(R.id.validimg);
        imageView6 = findViewById(R.id.validimg3);
        password_img = findViewById(R.id.up_password_toggle);

    }

    private void clicks() {
        dbManager = new DbManager(this);
        button.setOnClickListener(this);
        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
        imageView.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        password_img.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.signup_btn:

                String email = emailed.getText().toString();
                String password = passworded.getText().toString();
                String name = nameed.getText().toString();
                String mobile = mobileed.getText().toString();


                if (name.equals("") || email.equals("") || mobile.equals("") || password.equals("")) {

                    Toast.makeText(this, "Field might be empty", Toast.LENGTH_SHORT).show();

                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(this, "Enter valid email", Toast.LENGTH_SHORT).show();
                } else if (!(mobile.length() == 10)) {
                    Toast.makeText(this, "Mobile number is not valid", Toast.LENGTH_SHORT).show();

                } else if (temp == 0) {
                    Toast.makeText(this, "Accept Policy", Toast.LENGTH_SHORT).show();
                } else {

                    Boolean usercheckresult = dbManager.checkuser(email);
                    if (!usercheckresult) {

                        boolean id = dbManager.addRecord(name, email, mobile, password);
                        if (id) {
                            nameed.setText("");
                            emailed.setText("");
                            passworded.setText("");
                            mobileed.setText("");
                            Toast.makeText(SignUp.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(), SignIn.class);
                            startActivity(i);
                            finish();

                        } else {
                            Toast.makeText(SignUp.this, "Failed", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(SignUp.this, "User already exists", Toast.LENGTH_SHORT).show();
                    }
                }
                break;

            case R.id.goto_signin1:

            case R.id.goto_signin2:

                Intent i = new Intent(SignUp.this, SignIn.class);
                startActivity(i);
                finish();
                break;

            case R.id.reg_backbtn:

                Intent i2 = new Intent(SignUp.this, Landing.class);
                startActivity(i2);
                finish();
                break;

            case R.id.up_password_toggle:
                if (passworded.getTransformationMethod().getClass().getSimpleName().equals("PasswordTransformationMethod")) {
                    passworded.setTransformationMethod(new SingleLineTransformationMethod());
                    password_img.setImageResource(R.drawable.remove_red_eye_24);
                } else {
                    passworded.setTransformationMethod(new PasswordTransformationMethod());
                    password_img.setImageResource(R.drawable.invisible_eye);
                }
                passworded.setSelection(passworded.getText().length());
                break;


            case R.id.checkbox_img1:

                if (temp == 0) {
                    imageView2.setImageResource(R.drawable.activeted);
                    temp++;
                } else if (temp == 1) {
                    imageView2.setImageResource(R.drawable.disabled);
                    temp--;
                }
                break;


            case R.id.checkbox_img2:

                if (temp == 0) {
                    imageView3.setImageResource(R.drawable.activeted);
                    temp++;

                } else if (temp == 1) {
                    imageView3.setImageResource(R.drawable.disabled);
                    temp--;
                }
                break;


        }

    }

    private void txtEdit() {
        textView = findViewById(R.id.checkbox_txt1);
        String text = "I agree with the rules";
        SpannableString s1 = new SpannableString(text);


        ForegroundColorSpan fc = new ForegroundColorSpan(Color.parseColor("#4552CB"));
        UnderlineSpan ss2 = new UnderlineSpan();

        s1.setSpan(ss2, 13, 22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        s1.setSpan(fc, 13, 22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(s1);

    }


}