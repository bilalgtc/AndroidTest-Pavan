package com.example.android_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.android_test.Adapters.Recycle_adapter;
import com.example.android_test.Fragments.AppoinmentFragment;
import com.example.android_test.Fragments.ExploreFragment;
import com.example.android_test.Fragments.HomeFragment;
import com.example.android_test.Fragments.ProfileFragment;
import com.example.android_test.Models.Recycle_model;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {



    FrameLayout frameLayout;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        bottomNavigationView =findViewById(R.id.bottom_navigation);
        frameLayout =findViewById(R.id.fragment_container);

        setFragment(new HomeFragment());
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.home_icon:
                        setFragment(new HomeFragment());
                            return  true;

                    case R.id.clock_icon:
                        setFragment(new AppoinmentFragment());
                        return true;

                    case R.id.explore_icon:
                        setFragment(new ExploreFragment());
                        return  true;

                    case R.id.profile_icon:

                        setFragment(new ProfileFragment());
                        return  true;


                    default:
                        return false;
                }
            }
        });





     }

     private void setFragment(Fragment fragment){
         FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
         fragmentTransaction.replace(R.id.fragment_container,fragment);
         fragmentTransaction.commit();
     }

    @Override
    public void onBackPressed() {
    }
}