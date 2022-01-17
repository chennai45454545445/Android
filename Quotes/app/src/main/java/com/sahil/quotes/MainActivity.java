package com.sahil.quotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button Share;
TextView Quotes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Share=findViewById(R.id.share);
        Quotes=findViewById(R.id.quotes);
        getSupportActionBar().hide();

        Share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=Quotes.getText().toString();
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,text);
                startActivity(intent);


            }
        });
    }
}