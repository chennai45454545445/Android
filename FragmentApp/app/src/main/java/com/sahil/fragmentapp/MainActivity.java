package com.sahil.fragmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.sahil.fragmentapp.Fragment.FragmentOne;
import com.sahil.fragmentapp.Fragment.FragmentSecond;

public class MainActivity extends AppCompatActivity {
Button one,second;
LinearLayout linearlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one=findViewById(R.id.btn1);
        second=findViewById(R.id.btn2);
        linearlayout=findViewById(R.id.linearLayout);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentOne fragmentOne=new FragmentOne();
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.linearLayout,fragmentOne);
                transaction.commit();

            }
        });

        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentSecond fragmentSecond=new FragmentSecond();
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.linearLayout,fragmentSecond);
                transaction.commit();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(MainActivity.this,MainActivity.class);
        startActivity(intent);
    }
}