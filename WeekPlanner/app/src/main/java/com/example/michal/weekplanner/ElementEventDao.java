package com.example.michal.weekplanner;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.michal.weekplanner.model.Event;

import java.util.List;

@Dao
public interface ElementEventDao {
    @Insert
    void insertAllE(Event... Event);

    @Query("UPDATE Event SET title1 = :setTitle, `data1` = :setData, `desc1` = :setDesc, `GPS1` = :setGPS WHERE id= :givenID")
    void update(int givenID, String setTitle, String setData, String setDesc, String setGPS);

    @Query("DELETE FROM Event WHERE id = :ID")
    void deleteElementE(int ID);

    @Query("SELECT * FROM Event")
    List<Event> getAllElementsE();


    @Query("SELECT * FROM Event WHERE title1 LIKE :getTitle ")
    List<Event> getAllElementsWithNameE(String getTitle);


    @Query("SELECT * FROM Event WHERE id LIKE :ID")
    Event getElementById(Integer ID);
}


