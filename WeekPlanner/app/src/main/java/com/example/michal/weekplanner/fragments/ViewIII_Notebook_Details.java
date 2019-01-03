package com.example.michal.weekplanner.fragments;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.michal.weekplanner.R;

public class ViewIII_Notebook_Details extends AppCompatActivity {
    String productName;
    String productDesc;
    int productPics;

    TextView titleSub;
    ImageView imageSub;
    TextView detaiSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view3_list_item_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.vIII_details);
        titleSub=(TextView)findViewById(R.id.textTitleSub);
        imageSub=(ImageView)findViewById(R.id.imageSub);
        detaiSub=(TextView)findViewById(R.id.textDetailSub);


        int arrayPosition=getIntent().getIntExtra("postition",0);

        productName=getResources().getStringArray(R.array.mainlist)[arrayPosition];
        productPics=getResources().obtainTypedArray(R.array.superPics).getResourceId(arrayPosition,1);
        productDesc=getResources().getStringArray(R.array.detailed)[arrayPosition];

        titleSub.setText(productName);
        imageSub.setImageResource(productPics);
        detaiSub.setText(productDesc);


    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
