package com.example.android_test.Fragments;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_test.Adapters.Recycle_adapter;
import com.example.android_test.AddDetails;
import com.example.android_test.Models.Recycle_model;
import com.example.android_test.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    RecyclerView recyclerView;
    ArrayList<Recycle_model> details = new ArrayList<>();
    ImageView imageView;
    TextView textView;
    Recycle_adapter adapter;
    FirebaseDatabase firebaseDatabase;
    FirebaseStorage firebaseStorage;
    DatabaseReference databaseReference;

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


        View v = inflater.inflate(R.layout.fragment_home, container, false);


        imageView = v.findViewById(R.id.plus_btn);
        recyclerView = v.findViewById(R.id.dash_recyclerView);
        textView = v.findViewById(R.id.dash_textView);


        String text = "What are you\nlooking for, Maria?";
        SpannableString s = new SpannableString(text);
        ForegroundColorSpan fc = new ForegroundColorSpan(Color.parseColor("#ffcf6f"));

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("UserData");
        firebaseStorage = FirebaseStorage.getInstance();
        adapter = new Recycle_adapter(getContext(), details);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.v("Snappy", snapshot.toString());

                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
//                        String naame = postSnapshot.child("name").getValue(String.class);
//                        Log.v("TAG", naame);
                    Recycle_model recycle_model = postSnapshot.getValue(Recycle_model.class);
                    details.add(recycle_model);


                }

                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                error.getDetails();
                Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
            }
        });

//        databaseReference.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                Recycle_model recycle_model = snapshot.getValue(Recycle_model.class);
//                details.add(recycle_model);
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                Recycle_model recycle_model = snapshot.getValue(Recycle_model.class);
//                details.add(recycle_model);
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        s.setSpan(fc, 25, 32, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(s);

        imageView.setOnClickListener(this);


        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.plus_btn:

                Intent i = new Intent(getContext(), AddDetails.class);
                startActivity(i);
                getActivity().finish();
                break;

        }
    }
}