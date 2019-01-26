package com.example.michal.weekplanner.views.View;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.michal.weekplanner.AppDatabase;
import com.example.michal.weekplanner.R;
import com.example.michal.weekplanner.model.Event;

public class View_Events_Add extends AppCompatActivity {

    private EditText nameText, descriptionText,dataText, GPSText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view1_list_event_add);
        getSupportActionBar().setTitle(R.string.addevent);
        nameText = findViewById(R.id.nameText);
        descriptionText = findViewById(R.id.descriptionText);
        dataText = findViewById(R.id.dataadd);
        GPSText = findViewById(R.id.localText);
        Context appContext = getApplicationContext();
        final AppDatabase database = Room.databaseBuilder(appContext, AppDatabase.class, AppDatabase.DATABASE_NAME2).allowMainThreadQueries().build();

        Button button = findViewById(R.id.adevent);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameText.getText().toString();
                String description = descriptionText.getText().toString();
                String data = dataText.getText().toString();
                String GPS =GPSText.getText().toString();

                database.elementEventDao().insertAllE(new Event(name,data,description,GPS));
                finish();
            }
        });
        Button can = findViewById(R.id.canceeventadd);
        can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
