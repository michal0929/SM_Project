package com.example.michal.weekplanner.views.ViewIII;


import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.michal.weekplanner.AppDatabase;
import com.example.michal.weekplanner.R;
import com.example.michal.weekplanner.model.ItemListNotebook;

public class ViewIII_Notebook_Details extends AppCompatActivity {


    TextView titleSub;
    TextView detaiSub;

    @Override
    public void onResume() {
        super.onResume();
        final int IDD=getIntent().getIntExtra(ViewIII_Notebook.ID_TAG,0);
        final AppDatabase database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, AppDatabase.DATABASE_NAME2).allowMainThreadQueries().build();


        ItemListNotebook elementToEdit = database.elementNotebookDao().getElementById(IDD);
        titleSub.setText(elementToEdit.getTitle());
        detaiSub.setText(elementToEdit.getDesc());

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view3_list_item_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.vIII_details);
        titleSub=(TextView)findViewById(R.id.textTitleSub);
        detaiSub=(TextView)findViewById(R.id.textDetailSub);



        final int IDD=getIntent().getIntExtra(ViewIII_Notebook.ID_TAG,0);
        final AppDatabase database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, AppDatabase.DATABASE_NAME2).allowMainThreadQueries().build();


        ItemListNotebook elementToEdit = database.elementNotebookDao().getElementById(IDD);
        titleSub.setText(elementToEdit.getTitle());
        detaiSub.setText(elementToEdit.getDesc());

        Button editBtn = findViewById(R.id.edit3);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewIII_Notebook_Details.this, ViewIII_Notebook_Edit.class);
                intent.putExtra("ID_shop",IDD);
                startActivity(intent);
            }
        });
        Button removeBtn = findViewById(R.id.detele3);
        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                database.elementNotebookDao().deleteElementN(IDD);
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
