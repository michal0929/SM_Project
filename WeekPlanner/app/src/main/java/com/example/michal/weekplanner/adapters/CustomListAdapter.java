package com.example.michal.weekplanner.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.michal.weekplanner.R;
import com.example.michal.weekplanner.model.RowItem;
import java.util.List;


public class CustomListAdapter extends BaseAdapter {

    private Context context;
    private List<RowItem> itemList;
    public CustomListAdapter(Context context, List<RowItem> itemList)
    {
        this.context=context;
        this.itemList=itemList;
    }
    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=View.inflate(context, R.layout.list_item,null);
        TextView titleText=(TextView)v.findViewById(R.id.textfortitile);
        ImageView imageView=(ImageView)v.findViewById(R.id.imageplz);
        titleText.setText(itemList.get(position).getTitle());
        imageView.setImageResource(itemList.get(position).getPicture());
        return v;
    }
}
