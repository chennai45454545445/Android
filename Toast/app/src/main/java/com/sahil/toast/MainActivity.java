package com.sahil.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button byDefault,Gravity,Nested;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        byDefault=findViewById(R.id.btnOne);
      Gravity=findViewById(R.id.btnTwo);
        Nested=findViewById(R.id.btnThree);


        byDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "By Default", Toast.LENGTH_SHORT).show();
            }
        });

       Gravity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Toast toast=Toast.makeText(MainActivity.this,"Gravity",Toast.LENGTH_SHORT);
              toast.setGravity(200,0,0);
              toast.show();
            }
        });

        Nested.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast=Toast.makeText(MainActivity.this,"Gravity",Toast.LENGTH_SHORT);
                toast.setGravity(300,0,0);
                toast.show();
            }
        });
    }
}