package com.example.michal.weekplanner;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.michal.weekplanner.model.Event;
import com.example.michal.weekplanner.model.ItemListNotebook;

import java.util.List;

@Dao
public interface ElementNotebookDao {
    @Insert
    void insertAllN(ItemListNotebook... ItemListNotebook);

    @Query("UPDATE ItemListNotebook SET title = :setTitle, `desc` = :setDesc WHERE id= :givenID")
    void updateN(int givenID, String setTitle, String setDesc);

    @Query("DELETE FROM ItemListNotebook WHERE id = :ID")
    void deleteElementN(int ID);

    @Query("SELECT * FROM ItemListNotebook")
    List<ItemListNotebook> getAllElementsN();


    @Query("SELECT * FROM ItemListNotebook WHERE title LIKE :getTitle ")
    List<ItemListNotebook> getAllElementsWithNameN(String getTitle);


    @Query("SELECT * FROM ItemListNotebook WHERE id LIKE :ID")
    ItemListNotebook getElementById(Integer ID);
}


