package com.sahil.zomato.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sahil.zomato.DBHelper;
import com.sahil.zomato.DetailActivity;
import com.sahil.zomato.Modals.OrderModal;
import com.sahil.zomato.R;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.viewHolder>{
    ArrayList<OrderModal> list;
    Context context;

    public OrderAdapter(ArrayList<OrderModal> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.order_sample,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final OrderModal modal =list.get(position);
        holder.orderimg.setImageResource(modal.getOrderImage());
        holder.orderItemName.setText(modal.getOrderName());
        holder.Price.setText(modal.getOrderPrice());
        holder.OrderNo.setText(modal.getOrderNumber());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, DetailActivity.class);
                intent.putExtra("id",Integer.parseInt(modal.getOrderNumber()));
                intent.putExtra("type",2);
                context.startActivity(intent);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                new AlertDialog.Builder(context)
                .setTitle("Delete Item")
                        .setIcon(R.drawable.warning)
                        .setMessage("Are you sure to delete your order")
                        .setPositiveButton("Yes" , new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface , int i) {
                                DBHelper helper=new DBHelper(context);
                                if (helper.Delete(modal.getOrderNumber())>0){
                                    Toast.makeText(context , "Deleted" , Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    Toast.makeText(context , "Error" , Toast.LENGTH_SHORT).show();
                                }

                            }

                        })
                        .setNegativeButton("No" , new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface , int i) {
                                dialogInterface.cancel();
                            }
                        })
                        .setNeutralButton("Help" , new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface , int i) {
                                Toast.makeText(context , "Go to Website" , Toast.LENGTH_SHORT).show();
                            }
                        }).show();
               return  false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView orderimg;
        TextView orderItemName,Price,OrderNo;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            orderimg=itemView.findViewById(R.id.orderImage);
            orderItemName=itemView.findViewById(R.id.orderName);
            Price=itemView.findViewById(R.id.orderPrice);
            OrderNo=itemView.findViewById(R.id.orderNumber);


        }
    }
}
