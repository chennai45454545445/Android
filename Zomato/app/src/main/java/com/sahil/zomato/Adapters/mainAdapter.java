package com.sahil.zomato.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sahil.zomato.DetailActivity;
import com.sahil.zomato.Modals.newModal;
import com.sahil.zomato.R;

import java.util.ArrayList;

public class mainAdapter extends RecyclerView.Adapter<mainAdapter.viewHolder> {
      ArrayList<newModal> list;
      Context context;


    public mainAdapter(ArrayList<newModal> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sample_mainfood,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final newModal modal=list.get(position);
        holder.foodimg.setImageResource(modal.getImage());
        holder.name.setText(modal.getName());
        holder.price.setText(modal.getPrice());
        holder.description.setText(modal.getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, DetailActivity.class);
                intent.putExtra("Image",modal.getImage());
                intent.putExtra("Name",modal.getName());
                intent.putExtra("Price",modal.getPrice());
                intent.putExtra("Description",modal.getDescription());
                intent.putExtra("type",1);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView foodimg;
        TextView name,price,description;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            foodimg=itemView.findViewById(R.id.imageView);
            name=itemView.findViewById(R.id.foodName);
           price=itemView.findViewById(R.id.foodPrice);
          description=itemView.findViewById(R.id.orderDescription);

        }
    }

}
