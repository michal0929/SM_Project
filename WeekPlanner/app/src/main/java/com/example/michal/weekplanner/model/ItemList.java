package com.example.michal.weekplanner.model;

public class ItemList {
    private String title;
    private String desc;



    public ItemList(String title, int picture, String desc)
    {
        this.title=title;
        this.desc=desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc(){
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }



}
