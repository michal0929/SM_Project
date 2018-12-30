package com.example.michal.weekplanner.model;


public class RowItem {
    private String title;
    private int picture;
    private String desc;



    public RowItem(String title, int picture, String desc)
    {
        this.picture=picture;
        this.title=title;
        this.desc=desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getDesc(){
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }





}
