package com.example.michal.weekplanner.fragments.ViewII;


import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.michal.weekplanner.AppDatabase;
import com.example.michal.weekplanner.R;
import com.example.michal.weekplanner.model.ItemList;

public class ViewII_ShoppingList_Details extends AppCompatActivity {

    TextView titleSub;
    TextView detaiSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view2_list_item_shop_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.vII_details);
        titleSub=(TextView)findViewById(R.id.textTitleSub2);
        detaiSub=(TextView)findViewById(R.id.textDetailSub2);


        final int IDD=getIntent().getIntExtra(ViewII_ShoppingList.ID_TAG,0);
        final AppDatabase database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, AppDatabase.DATABASE_NAME2).allowMainThreadQueries().build();


        ItemList elementToEdit = database.elementShoppingDao().getElementById(IDD);
        titleSub.setText(elementToEdit.getTitle());
        detaiSub.setText(elementToEdit.getDesc());

        Button editBtn = findViewById(R.id.edit2);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewII_ShoppingList_Details.this, ViewII_ShoppingList_Edit.class);
                intent.putExtra("ID_shop",IDD);
                startActivity(intent);
            }
        });
        Button removeBtn = findViewById(R.id.delete2);
        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                database.elementShoppingDao().deleteElement(IDD);
                finish();
            }
        });

    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
