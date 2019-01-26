package com.example.michal.weekplanner.views.View;


import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.michal.weekplanner.AppDatabase;
import com.example.michal.weekplanner.R;
import com.example.michal.weekplanner.model.Event;

public class View_Events_Details extends AppCompatActivity {
    String productName;
    String dataPro;

    TextView titleSub;
    TextView data;
    TextView desc;
    TextView GPS;

    @Override
    public void onResume() {
        super.onResume();
        final int IDD=getIntent().getIntExtra(View_Events.ID_TAG,0);
        final AppDatabase database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, AppDatabase.DATABASE_NAME2).allowMainThreadQueries().build();

        Event elementToEdit = database.elementEventDao().getElementById(IDD);
        titleSub.setText(elementToEdit.getTitle());
        data.setText(elementToEdit.getData());
        desc.setText(elementToEdit.getDesc());
        GPS.setText(elementToEdit.getGPS());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view1_list_event_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.vIII_details);
        titleSub=(TextView)findViewById(R.id.textTitleSub3);
        data=(TextView)findViewById(R.id.date1);
        desc=(TextView)findViewById(R.id.desc1);
        GPS=(TextView)findViewById(R.id.gps1);


        final int IDD=getIntent().getIntExtra(View_Events.ID_TAG,0);
        final AppDatabase database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, AppDatabase.DATABASE_NAME2).allowMainThreadQueries().build();


        Event elementToEdit = database.elementEventDao().getElementById(IDD);
        titleSub.setText(elementToEdit.getTitle());
        data.setText(elementToEdit.getData());
        desc.setText(elementToEdit.getDesc());
        GPS.setText(elementToEdit.getGPS());

        Button editBtn = findViewById(R.id.edit1);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(View_Events_Details.this, View_Events_Edit.class);
                intent.putExtra("ID_event",IDD);
                startActivity(intent);
            }
        });
        Button removeBtn = findViewById(R.id.detele1);
        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                database.elementEventDao().deleteElementE(IDD);
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
