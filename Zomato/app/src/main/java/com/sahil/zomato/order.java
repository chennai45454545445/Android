package com.sahil.zomato;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.sahil.zomato.Adapters.OrderAdapter;
import com.sahil.zomato.Modals.OrderModal;
import com.sahil.zomato.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class order extends AppCompatActivity {
ActivityOrderBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding=ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DBHelper helper=new DBHelper(this);
        ArrayList<OrderModal> list=helper.getOrder();
        //list.add(new OrderModal(R.drawable.pizza,"Pizza","5","52658"));
        //list.add(new OrderModal(R.drawable.soup,"Hot Pizza","2","245784"));
        OrderAdapter adapter=new OrderAdapter(list,this);
        binding.orderRecyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        binding.orderRecyclerView.setLayoutManager(linearLayoutManager);




    }
}