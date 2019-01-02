package com.example.michal.weekplanner.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.michal.weekplanner.R;
import com.example.michal.weekplanner.model.Event;


import java.util.Date;
import java.util.List;


public class View_EventListAdapter extends BaseAdapter {

    private Context context;
    private List<Event>eventList;
    public View_EventListAdapter(Context context, List<Event> eventList)
    {
        this.context=context;
        this.eventList=eventList;
    }
    @Override
    public int getCount() {
        return eventList.size();
    }

    @Override
    public Object getItem(int position) {
        return eventList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=View.inflate(context, R.layout.list_item_shop,null);
        TextView titleText=(TextView)v.findViewById(R.id.item_title);
        TextView data=(TextView)v.findViewById(R.id.date);
        titleText.setText(eventList.get(position).getTitle());
        data.setText(eventList.get(position).getData());
        return v;
    }

}
