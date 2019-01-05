package com.example.michal.weekplanner.fragments.ViewII;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.michal.weekplanner.AppDatabase;
import com.example.michal.weekplanner.R;
import com.example.michal.weekplanner.model.ItemList;

public class ViewII_ShoppingList_Edit extends AppCompatActivity {

    private EditText nameText, descriptionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view2_list_item_shop_edit);
        getSupportActionBar().setTitle(R.string.editevent);
        nameText = findViewById(R.id.nameTextedit);
        descriptionText = findViewById(R.id.quantityedit);

        final int editableId = getIntent().getIntExtra("ID_shop",0);
        final AppDatabase database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, AppDatabase.DATABASE_NAME2).allowMainThreadQueries().build();


        ItemList elementToEdit = database.elementShoppingDao().getElementById(editableId);
        nameText.setText(elementToEdit.getTitle());
        descriptionText.setText(elementToEdit.getDesc());

        Button editBtn = findViewById(R.id.button3);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameText.getText().toString();
                String description = descriptionText.getText().toString();

                database.elementShoppingDao().update(editableId, name, description);
                finish();
            }
        });

    }
}
