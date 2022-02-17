package com.sahil.imagepicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.github.drjacky.imagepicker.ImagePicker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
ImageView backcover;
CircleImageView profile;
FloatingActionButton fb,fb1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        backcover=findViewById(R.id.Cover);
        profile=findViewById(R.id.ProfileImg);
        fb1=findViewById(R.id.floatingActionButton2);
        fb=findViewById(R.id.floatingActionButton);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.Companion.with(MainActivity.this)
                        .crop()
                        .compress(1024)
                        .maxResultSize(1024,1024)
                       .start(1);//Final image resolution will be less than 1080 x 1080(Optional)


            }
        });
        fb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.Companion.with(MainActivity.this)
                        .maxResultSize(1024,1024)
                        .start(2);//Final image resolution will be less than 1080 x 1080(Optional)


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode , int resultCode , @Nullable Intent data) {
        super.onActivityResult(requestCode , resultCode , data);
        if(requestCode==1){
            Uri uri=data.getData();
            backcover.setImageURI(uri);
        }
        else {
            Uri uri=data.getData();
           profile.setImageURI(uri);
        }

    }
}