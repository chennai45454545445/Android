package com.sahil.covid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    LottieAnimationView lottieAnimationView;
    Button button;
    ImageView love,star;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        love=findViewById(R.id.love);
        star=findViewById(R.id.star);
        button=findViewById(R.id.button);
lottieAnimationView=findViewById(R.id.splashanime);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lottieAnimationView.setVisibility(View.VISIBLE);
                button.setVisibility(View.INVISIBLE);
                love.setVisibility(View.INVISIBLE);
               star.setVisibility(View.INVISIBLE);
                lottieAnimationView.playAnimation();
                Thread thread=new Thread(){

                    public void run(){
                        try {
                            sleep(1000);
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                        finally {
                            Intent intent=new Intent(MainActivity.this,Detailed.class);
                            startActivity(intent);
                            finish();
                        }
                    }

                };thread.start();

            }


        });
    }
}