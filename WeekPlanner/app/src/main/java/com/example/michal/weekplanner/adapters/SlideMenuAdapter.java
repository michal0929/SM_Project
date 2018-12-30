package com.example.michal.weekplanner.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.michal.weekplanner.R;
import com.example.michal.weekplanner.model.ItemSlideMenu;

import java.util.List;

public class SlideMenuAdapter extends BaseAdapter {

    private Context context;
    private List<ItemSlideMenu> lstItem;

    public SlideMenuAdapter(Context context, List<ItemSlideMenu> lstItem) {
        this.context=context;
        this.lstItem=lstItem;
    }

    @Override
    public int getCount(){ //zwraca rozmiar tablicy z elementami w menu
        return lstItem.size();
    }

    @Override
    public Object getItem(int position){//zwraca dokladna pozycje zarządanego elementu

        return lstItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v= View.inflate(context, R.layout.item_sliding_menu, null);
        TextView tv=(TextView)v.findViewById(R.id.item_title);
        ItemSlideMenu item =lstItem.get(position);
        tv.setText(item.getTitle());
        return v;

    }
}
