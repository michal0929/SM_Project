package com.example.michal.weekplanner;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.michal.weekplanner.model.ItemList;
import com.example.michal.weekplanner.model.Event;
import com.example.michal.weekplanner.model.ItemListNotebook;

@Database(entities = {ItemList.class,Event.class,ItemListNotebook.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public static final String DATABASE_NAME2 = "ToDoListElementsDB";

    public abstract ElementShoppingDao elementShoppingDao();
    public abstract ElementEventDao elementEventDao();
    public abstract ElementNotebookDao elementNotebookDao();
}
