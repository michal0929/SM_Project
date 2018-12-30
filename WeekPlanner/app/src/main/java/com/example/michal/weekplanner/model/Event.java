package com.example.michal.weekplanner.model;


import java.util.Date;

public class Event {
    private String title;
    private Date data;
    private String desc;



    public Event(String title, Date data, String desc)
    {
        this.data=data;
        this.title=title;
        this.desc=desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getData() { return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDesc(){
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
