package com.example.android_test.Adapters;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_test.AddDetails;
import com.example.android_test.Details;
import com.example.android_test.Models.Recycle_model;
import com.example.android_test.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Recycle_adapter extends RecyclerView.Adapter<Recycle_adapter.ViewHolder> {
    ArrayList<Recycle_model> details = new ArrayList<>();
    Context context;
    Bitmap bitmap;
    BottomSheetDialog dialog;
    DatabaseReference databaseReference;


    public Recycle_adapter(Context context, ArrayList<Recycle_model> details) {
        this.context = context;
        this.details = details;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycle_info, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //get data
        Recycle_model model = details.get(position);
        String id = model.getId();
        String image = model.getImage();
        String name = model.getName();
        String species = model.getSpecies();
        String breed = model.getBreed();
        String size = model.getSize();
        String gender = model.getGender();
        String neutered = model.getNeutered();
        String vaccinated = model.getVaccinated();
        String Friendlywithdogs = model.getFwithdogs();
        String Friendlywithcats = model.getFwithcats();
        String fwithkids = model.getFwithkids();
        String fwithkidsg = model.getGetFwithkidssg();


        //set data

        Picasso.get().load(image).into(holder.image_view1);

        holder.txt1.setText(name);
        holder.txt2.setText(species);
        holder.txt3.setText(breed);

        holder.txt9.setText(size + " " + "inch");

        if (gender.equals("true")) {
            holder.txt4.setText("female");
        } else if (gender.equals(null)) {
            holder.txt4.setText(" ");
        } else {
            holder.txt4.setText("male");
        }

        if (gender.equals("true")) {
            holder.txt4.setText("female");
        } else {
            holder.txt4.setText("male");
        }


        if (neutered.equals("true")) {
            holder.txt5.setText("Neutured");
        } else {
            holder.txt5.setText("");
            holder.txt5.setBackground(null);
        }

        if (vaccinated.equals("true")) {
            holder.txt6.setText("Vaccinated");
        } else {
            holder.txt6.setText("");
            holder.txt6.setBackground(null);
        }

        if (Friendlywithdogs.equals("true")) {
            holder.txt7.setText("Friendly with dogs");
        } else {
            holder.txt7.setText("");
            holder.txt7.setBackground(null);
        }

        if (Friendlywithcats.equals("true")) {
            holder.txt8.setText("Friendly with cats");
        } else {
            holder.txt8.setText("");
            holder.txt8.setBackground(null);
        }

        holder.image_view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, Details.class);
                i.putExtra("id", id);
                i.putExtra("image", model.getImage());
                i.putExtra("name", name);
                i.putExtra("species", species);
                i.putExtra("breed", breed);
                i.putExtra("size", size);
                i.putExtra("gender", gender);
                i.putExtra("neutered", neutered);
                i.putExtra("vaccinated", vaccinated);
                i.putExtra("Friendlywithdogs", Friendlywithdogs);
                i.putExtra("Friendlywithcats", Friendlywithcats);
                i.putExtra("Friendlywithkids10", fwithkids);
                i.putExtra("Friendlywithkids10G", fwithkidsg);

                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });
        holder.imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, AddDetails.class);
                i.putExtra("id", id);
                i.putExtra("image", model.getImage());
                i.putExtra("name", name);
                i.putExtra("species", species);
                i.putExtra("breed", breed);
                i.putExtra("size", size);
                i.putExtra("gender", gender);
                i.putExtra("neutered", neutered);
                i.putExtra("vaccinated", vaccinated);
                i.putExtra("Friendlywithdogs", Friendlywithdogs);
                i.putExtra("Friendlywithcats", Friendlywithcats);
                i.putExtra("Friendlywithkids10", fwithkids);
                i.putExtra("Friendlywithkids10G", fwithkidsg);
                i.putExtra("isEditMode", true); //update data si true

                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });

        holder.imageView.setOnClickListener(v -> {
            Dialog dialog = new Dialog(context);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.custom_delete_dialog);


            Button btn1 = dialog.findViewById(R.id.yes_btn);
            Button btn2 = dialog.findViewById(R.id.no_btn);
            ImageView btn3 = dialog.findViewById(R.id.cross_btn);

            btn1.setOnClickListener(v1 -> {
//                Toast.makeText(context.getApplicationContext(),"Yes" , Toast.LENGTH_LONG).show();
                databaseReference = FirebaseDatabase.getInstance().getReference()
                        .child("UserData").child(id);


                databaseReference.removeValue();
                details.remove(position);

//                details.remove(position);
//                details.notify();

//                notifyItemRemoved(position);
//                notifyItemChanged(position, details.size());
                btn1.setBackgroundColor(Color.BLUE);
                btn1.setTextColor(Color.WHITE);
                dialog.cancel();
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btn2.setBackgroundColor(Color.BLUE);
                    btn2.setTextColor(Color.WHITE);
                    dialog.cancel();
                }
            });

            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.cancel();
                }
            });
            dialog.show();
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
            dialog.getWindow().setGravity(Gravity.BOTTOM);


        });
//        holder.btn1.setOnClickListener(v -> {
//            details.remove(position);
//            notifyItemChanged(position);
//        });
//
    }

    @Override
    public int getItemCount() {
        return details.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9;
        ImageView image_view1, imageView, imageView2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt1 = itemView.findViewById(R.id.dogname_txt);
            txt2 = itemView.findViewById(R.id.species_txt);
            txt3 = itemView.findViewById(R.id.breed_name_txt);
            txt4 = itemView.findViewById(R.id.gender_txt);
            txt5 = itemView.findViewById(R.id.neutered_txt);
            txt6 = itemView.findViewById(R.id.vacci_txt);
            txt7 = itemView.findViewById(R.id.friwithdogs_txt);
            txt8 = itemView.findViewById(R.id.friwithcats_txt);
            txt9 = itemView.findViewById(R.id.size_txt);
            image_view1 = itemView.findViewById(R.id.main_img);

//
            imageView = itemView.findViewById(R.id.delete_img);
            imageView2 = itemView.findViewById(R.id.update_btn);

        }
    }
}