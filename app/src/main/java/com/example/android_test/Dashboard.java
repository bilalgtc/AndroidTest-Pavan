package com.example.android_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.android_test.Fragments.AppoinmentFragment;
import com.example.android_test.Fragments.ExploreFragment;
import com.example.android_test.Fragments.HomeFragment;
import com.example.android_test.Fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class Dashboard extends AppCompatActivity {


    FrameLayout frameLayout;
    BottomNavigationView bottomNavigationView;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(getResources().getColor(R.color.grey2));
        getWindow().setNavigationBarColor(getResources().getColor(R.color.white));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        init();


        setFragment(new HomeFragment());
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {

                case R.id.home_icon:
                    setFragment(new HomeFragment());
                    return true;

                case R.id.clock_icon:
                    setFragment(new AppoinmentFragment());
                    return true;

                case R.id.explore_icon:
                    setFragment(new ExploreFragment());
                    return true;

                case R.id.profile_icon:

                    setFragment(new ProfileFragment());
                    return true;


                default:
                    return false;
            }
        });


    }

    private void init() {
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        frameLayout = findViewById(R.id.fragment_container);
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}