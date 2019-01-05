package com.example.michal.weekplanner.fragments.ViewII;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.michal.weekplanner.AppDatabase;
import com.example.michal.weekplanner.R;
import com.example.michal.weekplanner.model.ItemList;

public class ViewII_ShoppingList_Add extends AppCompatActivity {

    private EditText nameText, descriptionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view2_list_item_shop_add);
        getSupportActionBar().setTitle(R.string.addeshop);

        nameText = findViewById(R.id.nameText);
        descriptionText = findViewById(R.id.quantityadd);

        Context appContext = getApplicationContext();
        final AppDatabase database = Room.databaseBuilder(appContext, AppDatabase.class, AppDatabase.DATABASE_NAME2).allowMainThreadQueries().build();

        Button button = findViewById(R.id.add2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameText.getText().toString();
                String description = descriptionText.getText().toString();

                database.elementShoppingDao().insertAll(new ItemList(name, description));
                finish();
            }
        });
        Button can = findViewById(R.id.cancel2);
        can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
