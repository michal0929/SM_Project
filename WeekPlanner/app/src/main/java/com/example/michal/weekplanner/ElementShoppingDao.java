package com.example.michal.weekplanner;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.michal.weekplanner.model.ItemList;

import java.util.List;

@Dao
public interface ElementShoppingDao {
    @Insert
    void insertAll(ItemList... ItemList);

    @Query("UPDATE ItemList SET title = :setName, `desc` = :setDescription WHERE id= :givenID")
    void update(int givenID, String setName, String setDescription);

    @Query("DELETE FROM ItemList WHERE id = :ID")
    void deleteElement(int ID);

    @Query("SELECT * FROM ItemList")
    List<ItemList> getAllElements();


    @Query("SELECT * FROM ItemList WHERE title LIKE :getName ")
    List<ItemList> getAllElementsWithName(String getName);


    @Query("SELECT * FROM ItemList WHERE id LIKE :ID")
    ItemList getElementById(Integer ID);

}


