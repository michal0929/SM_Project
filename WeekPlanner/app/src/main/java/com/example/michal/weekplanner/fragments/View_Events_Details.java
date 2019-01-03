package com.example.michal.weekplanner.fragments;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.michal.weekplanner.R;

import java.util.Date;

public class View_Events_Details extends AppCompatActivity {
    String productName;
    String dataPro;

    TextView titleSub;
    TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view1_list_event_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.vIII_details);
        titleSub=(TextView)findViewById(R.id.textTitleSub3);
        data=(TextView)findViewById(R.id.date1);


        int arrayPosition=getIntent().getIntExtra("postition",0);

        productName=getResources().getStringArray(R.array.mainlist)[arrayPosition];
        dataPro =getResources().getStringArray(R.array.detailed)[arrayPosition];

        titleSub.setText(productName);
        data.setText(dataPro);


    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
