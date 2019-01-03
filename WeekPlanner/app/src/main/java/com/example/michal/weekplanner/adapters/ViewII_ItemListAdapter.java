package com.example.michal.weekplanner.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.michal.weekplanner.R;
import com.example.michal.weekplanner.model.ItemList;

import java.util.List;


public class ViewII_ItemListAdapter extends BaseAdapter {

    private Context context;
    private List<ItemList>ItemList;
    public ViewII_ItemListAdapter(Context context, List<ItemList> ItemList)
    {
        this.context=context;
        this.ItemList=ItemList;
    }
    @Override
    public int getCount() {
        return ItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return ItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=View.inflate(context, R.layout.view2_list_item_shop,null);
        TextView titleText=(TextView)v.findViewById(R.id.item_title_shop);
        TextView data=(TextView)v.findViewById(R.id.quantity);
        titleText.setText(ItemList.get(position).getTitle());
        data.setText(ItemList.get(position).getDesc());
        return v;
    }

}
