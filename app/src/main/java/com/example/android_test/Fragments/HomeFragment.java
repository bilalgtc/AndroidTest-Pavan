package com.example.android_test.Fragments;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
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
import android.widget.Toast;

import com.example.android_test.Adapters.Recycle_adapter;
import com.example.android_test.Details;
import com.example.android_test.Helper.DetailsDBHelper;
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
    DetailsDBHelper dbHelper2;
    ArrayList<String> name,breed;

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

        dbHelper2 = new DetailsDBHelper(getContext());
        name =new ArrayList<>();
        breed = new ArrayList<>();

        imageView = v.findViewById(R.id.plus_btn);
        recyclerView = v.findViewById(R.id.dash_recyclerView);
        textView = v.findViewById(R.id.dash_textView);
        String text = "What are you\nlooking for, Maria?";
        SpannableString s = new SpannableString(text);
        ForegroundColorSpan fc = new ForegroundColorSpan(Color.parseColor("#ffcf6f"));
        Recycle_adapter adapter = new Recycle_adapter(getContext(),name,breed);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        s.setSpan(fc, 25, 32, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(s);



        adapter.notifyItemInserted(name.size());
        adapter.notifyItemInserted(breed.size());
        StoreData();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Details.class);
                startActivity(i);
            }
        });
        return v;


    }

    TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



//        details.add(new Recycle_model(R.drawable.dogimg, "Troy", "German Shepherd"));
//        details.add(new Recycle_model(R.drawable.dogimg2, "Oscar", "Labrador Retriever"));
//        details.add(new Recycle_model(R.drawable.dogimg3, "Light", "Poodle"));
//        details.add(new Recycle_model(R.drawable.dogimg4, "Bosco", "Rottweiler"));
//        details.add(new Recycle_model(R.drawable.dogimg4, "Night", "Rottweiler"));
//        details.add(new Recycle_model(R.drawable.dogimg4, "Sky", "Rottweiler"));

//        Cursor cursor =new DetailsDBHelper(getContext()).getUser();
//
//        while (cursor.moveToNext()){
//            Recycle_model obj=new Recycle_model(cursor.getString(0) );
//            details.add(obj);
//
//
//
//        }

    }

    void StoreData(){
        Cursor cursor = dbHelper2.getUser();
        if (cursor.getCount()==0){
            Toast.makeText(getContext(), "No Data", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                name.add(cursor.getString(0));
                breed.add(cursor.getString(1));
            }
        }
    }

}