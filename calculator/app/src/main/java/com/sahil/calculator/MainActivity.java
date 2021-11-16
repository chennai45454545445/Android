package com.sahil.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText etFirst,etSecond;
    TextView ans;
    Button btn1,btn2,btn3,btn4,rAte,sHare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirst =findViewById(R.id.etFirst);
        etSecond =findViewById(R.id.etSecond);

        ans =findViewById(R.id.ans);

        btn1 =findViewById(R.id.btn1);
        btn2 =findViewById(R.id.btn2);
        btn3 =findViewById(R.id.btn3);
        btn4 =findViewById(R.id.btn4);

  btn1.setOnClickListener(new View.OnClickListener() {
      @Override

      public void onClick(View v) {
       double first,second,answer;


          try {
             if (etFirst==null&&etSecond==null){
                 ans.setText("");

             }
              first= (double)Double.parseDouble(etFirst.getText().toString());
              second=(double)Double.parseDouble(etSecond.getText().toString());
              answer=(double)first+second;
              ans.setText("Ans is "+answer);
          }
          catch (Exception e){
             e.printStackTrace();

          }

      }
  });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double first,second,answer;
                try {
                    if (etFirst==null&&etSecond==null){
                        ans.setText("");
                    }
                    first= Double.parseDouble(etFirst.getText().toString());
                    second=Double.parseDouble(etSecond.getText().toString());
                    answer=first-second;
                    ans.setText("Ans is "+answer);
                }
                catch (Exception e){
                    e.printStackTrace();

                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              double first,second,answer;
                
                try {
                    if (etFirst==null&&etSecond==null){
                        ans.setText("");
                    }
                    first= Double.parseDouble(etFirst.getText().toString());
                    second=Double.parseDouble(etSecond.getText().toString());
                    answer=first*second;
                    ans.setText("Ans is "+answer);
                }
                catch (Exception e){
                    e.printStackTrace();

                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double first,second,answer;

                try {
                    if (etFirst==null&&etSecond==null){
                        ans.setText("");
                    }
                    first= Double.parseDouble(etFirst.getText().toString());
                    second=Double.parseDouble(etSecond.getText().toString());
                    answer=first/second;
                    ans.setText("Ans is "+answer);
                }
                catch (Exception e){
                    e.printStackTrace();

                }
            }
        });


    }
}