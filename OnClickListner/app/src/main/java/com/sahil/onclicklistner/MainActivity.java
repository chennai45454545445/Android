package com.sahil.onclicklistner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
TextView tx1,tx2,tx3,tx4,tx5,tx6;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

tx1=findViewById(R.id.tx1);
        tx2=findViewById(R.id.tx2);
        tx3=findViewById(R.id.tx3);
        tx4=findViewById(R.id.tx4);
        tx5=findViewById(R.id.tx5);
        tx6=findViewById(R.id.tx6);

        tx1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "WEB DOVELOPMENT", Toast.LENGTH_SHORT).show();
            }
        });
        tx2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "ANDROID DOVELOPMENT", Toast.LENGTH_SHORT).show();
            }
        });

        tx3.setOnClickListener(this);
        tx4.setOnClickListener(this);
        tx5.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tx3:
                Toast.makeText(this, "Pythom", Toast.LENGTH_SHORT).show();
            case R.id.tx4:
                Toast.makeText(this, "Pythom", Toast.LENGTH_SHORT).show();
            case R.id.tx5:
                Toast.makeText(this, "Pythom", Toast.LENGTH_SHORT).show();
        }
    }

    public void tx5(View view) {
        Toast.makeText(this, "Machine Leraning", Toast.LENGTH_SHORT).show();
    }

    public void tx6(View view) {
        Toast.makeText(this, "AI", Toast.LENGTH_SHORT).show();
    }
}