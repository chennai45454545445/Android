package com.sahil.foodwala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class signin extends AppCompatActivity {
Button Login;
TextView First;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        Login=findViewById(R.id.mySignup);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(signin.this,skip.class);
                startActivity(intent);
            }
        });
     First=findViewById(R.id.dontHave);
        First.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(signin.this,signup.class);
                startActivity(intent);
            }
        });
        getSupportActionBar().setTitle("Sign In");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public boolean onSupport(){
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}