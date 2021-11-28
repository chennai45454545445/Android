package com.sahil.foodwala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class signup extends AppCompatActivity {
    Button Regis;
    TextView Second;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Regis=findViewById(R.id.mySignup);
      Regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(signup.this,skip.class);
                startActivity(intent);
            }
        });
        Second=findViewById(R.id.dontHave);
        Second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(signup.this,signin.class);
                startActivity(intent);
            }
        });
        getSupportActionBar().setTitle("Sign Up");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public boolean onSupport(){
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}