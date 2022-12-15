package com.example.android_test.Adapters;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_test.Details;
import com.example.android_test.Information;
import com.example.android_test.Models.Recycle_model;
import com.example.android_test.R;

import java.util.ArrayList;

public class Recycle_adapter extends RecyclerView.Adapter<Recycle_adapter.ViewHolder> {
    ArrayList<Recycle_model> details=new ArrayList<>();
    Context context;

    public Recycle_adapter(Context context,ArrayList<Recycle_model> details){
            this.context=context;
            this.details=details;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.recycle_info,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //get data
        Recycle_model model=details.get(position);
//        String id=model.getId();
        String name= model.getName();
        String breed = model.getBreed();
        byte[] image= model.getImg();
        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);

        //set data
        holder.image_view1.setImageBitmap(bitmap);
        holder.txt1.setText(name);
        holder.txt2.setText(breed);


//            Recycle_model recycle_model=details.get(position);

        //get
//       String name=recycle_model.getName();

        //set
//        holder.txt1.setText(name);

//        holder.txt2.setText(details.get(position).breed);
//        holder.image_view1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent(context, Information.class);
//                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivity(i);
//            }
//        });
//        holder.imageView2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent(context, Details.class);
//                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivity(i);
//            }
//        });
//
//        holder.imageView.setOnClickListener(v -> {
//
//
//            Dialog dialog =new Dialog(context);
//            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//            dialog.setContentView(R.layout.custom_delete_dialog);
//
//
//
//            Button btn1=dialog.findViewById(R.id.yes_btn);
//            Button btn2=dialog.findViewById(R.id.no_btn);
//            ImageView btn3=dialog.findViewById(R.id.cross_btn);
//
//
//            btn1.setOnClickListener(v1 -> {
////                Toast.makeText(context.getApplicationContext(),"Yes" , Toast.LENGTH_LONG).show();
//                details.remove(holder.getAdapterPosition());
//                notifyDataSetChanged();
//                dialog.cancel();
//            });
//            btn2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                dialog.cancel();
//                }
//            });
//
//            btn3.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    dialog.cancel();
//                }
//            });
//            dialog.show();
//            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
//            dialog.getWindow().setGravity(Gravity.BOTTOM);
//        });

//        holder.btn1.setOnClickListener(v -> {
//            details.remove(position);
//            notifyItemChanged(position);
//        });
    }

    @Override
    public int getItemCount() {
        return details.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt1,txt2;
        ImageView image_view1,imageView,imageView2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt1=itemView.findViewById(R.id.dogname_txt);
            txt2=itemView.findViewById(R.id.breed_name_txt);
            image_view1=itemView.findViewById(R.id.main_img);
//
//            imageView=itemView.findViewById(R.id.delete_img);
//            imageView2=itemView.findViewById(R.id.update_btn);

        }
    }
}
