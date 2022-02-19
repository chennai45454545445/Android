package com.sahil.zomato;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sahil.zomato.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
ActivityDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DBHelper helper = new DBHelper(this);
        if(getIntent().getIntExtra("type",0)==1) {
            final int image = getIntent().getIntExtra("Image" , 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("Price"));
            final String name = getIntent().getStringExtra("Name");
            final String description = getIntent().getStringExtra("Description");


            binding.detailImage.setImageResource(image);
            binding.detailPrice.setText(String.format("%d" , price));
            binding.detailfoodName.setText(name);
            binding.detailDescription.setText(description);
            binding.orderNow.setText("Order Now");
            binding.orderNow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isInserted = helper.insertOrder(
                            binding.nameBox.getText().toString() ,
                            binding.phoneBox.getText().toString() ,
                            price ,
                            image ,
                            description ,
                            name
                    );
                    if (isInserted)
                        Toast.makeText(DetailActivity.this , "Done" , Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(DetailActivity.this , "Failed" , Toast.LENGTH_SHORT).show();

                }
            });


        }
        else {
         int id=getIntent().getIntExtra("id",0);
         Cursor cursor=helper.getOrderById(id);
         int image=cursor.getInt(4);
            binding.detailImage.setImageResource(image);
            binding.detailPrice.setText(String.format("%d",cursor.getInt(3)));
            binding.detailfoodName.setText(cursor.getString(6));
            binding.detailDescription.setText(cursor.getString(5));
            binding.nameBox.setText(cursor.getString(1));
            binding.phoneBox.setText(cursor.getString(2));
            binding.orderNow.setText("Update Now");
            binding.orderNow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
boolean isUpdated=helper.updateOrder(
        binding.nameBox.getText().toString() ,
        binding.phoneBox.getText().toString() ,
        Integer.parseInt(binding.detailPrice.getText().toString()),
        image,
        binding.detailDescription.getText().toString(),
        binding.detailfoodName.getText().toString(),
        id


);
if (isUpdated){
    Toast.makeText(DetailActivity.this , "Update Succesfulley" , Toast.LENGTH_SHORT).show();
}
else {
    Toast.makeText(DetailActivity.this , "Failed" , Toast.LENGTH_SHORT).show();
}
                }
            });

        }


        }




    }