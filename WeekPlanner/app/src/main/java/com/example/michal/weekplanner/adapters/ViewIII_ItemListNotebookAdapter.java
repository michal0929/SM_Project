package com.example.michal.weekplanner.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.michal.weekplanner.R;
import com.example.michal.weekplanner.model.ItemListNotebook;

import java.util.List;


public class ViewIII_ItemListNotebookAdapter extends BaseAdapter {

    private Context context;
    private List<ItemListNotebook> itemListNotebook;
    public ViewIII_ItemListNotebookAdapter(Context context, List<ItemListNotebook> itemList)
    {
        this.context=context;
        this.itemListNotebook =itemList;
    }
    @Override
    public int getCount() {
        return itemListNotebook.size();
    }

    @Override
    public Object getItem(int position) {
        return itemListNotebook.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=View.inflate(context, R.layout.view3_list_item,null);
        TextView titleText=(TextView)v.findViewById(R.id.item);
        TextView desc=(TextView)v.findViewById(R.id.desc);
        titleText.setText(itemListNotebook.get(position).getTitle());
        desc.setText(itemListNotebook.get(position).getDesc());
        return v;
    }

}
