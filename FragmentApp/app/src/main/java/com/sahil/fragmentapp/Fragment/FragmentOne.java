package com.sahil.fragmentapp.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sahil.fragmentapp.R;
import com.sahil.fragmentapp.ScrollingActivity;


public class FragmentOne extends Fragment {
TextView tv;

    public FragmentOne() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_one, container, false);
        tv=view.findViewById(R.id.fragtext);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), ScrollingActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}