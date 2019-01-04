package com.example.michal.weekplanner.model;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;



@Entity
public class Event {

    @PrimaryKey(autoGenerate = true)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


        @ColumnInfo(name = "title1")
        private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

        @ColumnInfo(name = "data1")
        private String data;

        public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

        @ColumnInfo(name = "desc1")
        private String desc;

        public String getDesc(){
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

        @ColumnInfo(name = "GPS1")
        private String GPS;

        public String getGPS(){
        return GPS;
    }

    public void setGPS(String GPS) {
        this.GPS = GPS;
    }

    public Event(String title, String data, String desc,String GPS)
        {
            this.title=title;
            this.data=data;
            this.desc=desc;
            this.GPS=GPS;


        }

        public String toString() {
            return  this.title + "\n" + this.data+ "\n" + this.desc+ "\n" + this.GPS;
        }
}
