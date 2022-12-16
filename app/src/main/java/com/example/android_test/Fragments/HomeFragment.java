package com.example.android_test.Fragments;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android_test.Adapters.Recycle_adapter;
import com.example.android_test.Details;
import com.example.android_test.Helper.DbManager2;
import com.example.android_test.Models.Recycle_model;
import com.example.android_test.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Recycle_model> details = new ArrayList<>();
    ImageView imageView;
    String id, name, breed;
    byte[] image;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment homeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v = inflater.inflate(R.layout.fragment_home, container, false);

//

        imageView = v.findViewById(R.id.plus_btn);
        recyclerView = v.findViewById(R.id.dash_recyclerView);
        TextView textView;
        textView = v.findViewById(R.id.dash_textView);
        String text = "What are you\nlooking for, Maria?";
        SpannableString s = new SpannableString(text);
        ForegroundColorSpan fc = new ForegroundColorSpan(Color.parseColor("#ffcf6f"));

        Cursor cursor = new DbManager2(getContext()).getData();

//        while (cursor.moveToNext()){
//            Recycle_model obj = new Recycle_model(cursor.getString(1), cursor.getString(2), cursor.getString(3));
//                    details.add(obj);
//        }
        if(cursor!=null && cursor.getCount() > 0)
        {
            if (cursor.moveToFirst())
            {
                do {
                    Recycle_model obj = new Recycle_model(cursor.getString(1), cursor.getString(2), cursor.getString(3));
                    details.add(obj);
                } while (cursor.moveToNext());
            }
        }


        Recycle_adapter adapter = new Recycle_adapter(getContext(), details);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        s.setSpan(fc, 25, 32, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(s);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Details.class);
                startActivity(i);
            }
        });

        return v;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        details.add(new Recycle_model("Troy","Dog","German",image));

    }
}