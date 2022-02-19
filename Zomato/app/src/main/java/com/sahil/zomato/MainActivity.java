package com.sahil.zomato;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.Switch;

import com.sahil.zomato.Adapters.mainAdapter;
import com.sahil.zomato.Modals.newModal;
import com.sahil.zomato.databinding.ActivityMainBinding;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<newModal> list=new ArrayList<>();
        list.add(new newModal(R.drawable.food4,"Chicken Tikka","10","Chicken Tikka is Good"));
        list.add(new newModal(R.drawable.pizza,"Pizza","5","Pizza is Good"));
        mainAdapter adapter=new mainAdapter(list,this);

       binding.recyclerView.setAdapter(adapter);

       LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
      binding.recyclerView.setLayoutManager(linearLayoutManager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.check_orders,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.myorders:
                Intent intent=new Intent(MainActivity.this,order.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}