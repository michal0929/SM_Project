package com.example.michal.weekplanner.fragments.ViewIII;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.michal.weekplanner.AppDatabase;
import com.example.michal.weekplanner.R;
import com.example.michal.weekplanner.model.ItemListNotebook;

public class ViewIII_Notebook_Add extends AppCompatActivity {

    private EditText nameText, descriptionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.view3_list_item_add);
        getSupportActionBar().setTitle(R.string.addnotebook);
        nameText = findViewById(R.id.nameTextN);
        descriptionText = findViewById(R.id.descriptionaddN);

        Context appContext = getApplicationContext();
        final AppDatabase database = Room.databaseBuilder(appContext, AppDatabase.class, AppDatabase.DATABASE_NAME2).allowMainThreadQueries().build();

        Button button = findViewById(R.id.add3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameText.getText().toString();
                String description = descriptionText.getText().toString();

                database.elementNotebookDao().insertAllN(new ItemListNotebook(name, description));
                finish();
            }
        });

        Button can = findViewById(R.id.cancel3);
        can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
