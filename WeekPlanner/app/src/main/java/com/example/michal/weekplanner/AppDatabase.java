package com.example.michal.weekplanner;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.michal.weekplanner.model.ItemList;

@Database(entities = {ItemList.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "ToDoListElementsDB";

    public abstract ElementShoppingDao elementShoppingDao();

}
