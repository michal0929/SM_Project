package com.example.michal.weekplanner.model;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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

    public String getData() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:SS", Locale.US);
        String time=sdf.format(data);
        return time;
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
