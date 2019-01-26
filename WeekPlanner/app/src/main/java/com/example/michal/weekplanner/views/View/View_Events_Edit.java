package com.example.michal.weekplanner.views.View;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.michal.weekplanner.AppDatabase;
import com.example.michal.weekplanner.R;
import com.example.michal.weekplanner.model.Event;

public class View_Events_Edit extends AppCompatActivity {

    private EditText nameText, descriptionText,dataText, GPSText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view1_list_event_edit);
        getSupportActionBar().setTitle(R.string.editevent);

        nameText = findViewById(R.id.nameedit);
        descriptionText = findViewById(R.id.descriptionTextedit);
        dataText = findViewById(R.id.dataedit);
        GPSText = findViewById(R.id.localTextedit);

        final int editableId = getIntent().getIntExtra("ID_event",0);
        final AppDatabase database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, AppDatabase.DATABASE_NAME2).allowMainThreadQueries().build();

        Event elementToEdit = database.elementEventDao().getElementById(editableId);
        nameText.setText(elementToEdit.getTitle());
        descriptionText.setText(elementToEdit.getData());
        dataText.setText(elementToEdit.getDesc());
        GPSText.setText(elementToEdit.getGPS());

        Button editBtn = findViewById(R.id.button3);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameText.getText().toString();
                String description = descriptionText.getText().toString();
                String data = dataText.getText().toString();
                String GPS =GPSText.getText().toString();;
                database.elementEventDao().update(editableId, name,data, description,GPS);
                finish();
            }
        });

    }
}
