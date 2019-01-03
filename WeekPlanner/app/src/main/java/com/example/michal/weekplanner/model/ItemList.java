package com.example.michal.weekplanner.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;



@Entity
public class ItemList {

    @PrimaryKey(autoGenerate = true)
    private int id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ColumnInfo(name = "title")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    @ColumnInfo(name = "desc")
    private String desc;

    public String getDesc () {
        return desc;
    }

    public void setDesc(String value) {
        this.title = value;
    }

    public ItemList(String title, String desc) {

        this.title = title;
        this.desc = desc;
    }


    public String toString() {
        return  this.title + "\n" + this.desc;
    }

}