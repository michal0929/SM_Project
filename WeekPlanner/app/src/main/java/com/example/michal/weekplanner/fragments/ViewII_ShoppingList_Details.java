package com.example.michal.weekplanner.fragments;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.michal.weekplanner.R;

public class ViewII_ShoppingList_Details extends AppCompatActivity {
    String productName;
    String productDesc;

    TextView titleSub;
    TextView detaiSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view2_list_item_shop_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.vIII_details);
        titleSub=(TextView)findViewById(R.id.textTitleSub2);
        detaiSub=(TextView)findViewById(R.id.textDetailSub2);


        int arrayPosition=getIntent().getIntExtra("postition",0);

        productName=getResources().getStringArray(R.array.mainlist)[arrayPosition];
        productDesc=getResources().getStringArray(R.array.detailed)[arrayPosition];

        titleSub.setText(productName);
        detaiSub.setText(productDesc);


    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
