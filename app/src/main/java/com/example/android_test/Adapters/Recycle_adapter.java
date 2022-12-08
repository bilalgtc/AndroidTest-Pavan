package com.example.android_test.Adapters;


import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_test.Dashboard;
import com.example.android_test.Models.Recycle_model;
import com.example.android_test.R;

import java.util.ArrayList;

public class Recycle_adapter extends RecyclerView.Adapter<Recycle_adapter.ViewHolder> {
    ArrayList<Recycle_model> details=new ArrayList<>();
    Context context;

    public Recycle_adapter(Context context, ArrayList<Recycle_model> details){
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
        holder.image.setImageResource(details.get(position).img);
        holder.txt1.setText(details.get(position).name);
        holder.txt2.setText(details.get(position).breed);



        holder.imageView.setOnClickListener(v -> {
            Dialog dialog =new Dialog(context);
            dialog.setContentView(R.layout.custom_delete_dialog);
            dialog.show();

            Button btn1=dialog.findViewById(R.id.yes_btn);
            Button btn2=dialog.findViewById(R.id.no_btn);
            btn1.setOnClickListener(v1 -> {
                Toast.makeText(context.getApplicationContext(),"Yes" , Toast.LENGTH_LONG).show();
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                dialog.cancel();
                }
            });

        });

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
        ImageView image,imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt1=itemView.findViewById(R.id.dogname_txt);
            txt2=itemView.findViewById(R.id.breed_name_txt);
            image=itemView.findViewById(R.id.main_img);

            imageView=itemView.findViewById(R.id.delete_img);


        }
    }
}
