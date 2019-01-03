package com.example.michal.weekplanner.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.michal.weekplanner.R;
import com.example.michal.weekplanner.adapters.View_EventListAdapter;
import com.example.michal.weekplanner.model.Event;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class View_Events extends Fragment {


    ListView myListView;
    List<Event> rowItemsList;
    View_EventListAdapter adapter;

    String[] productName;
    String[] productDesc;
    Date productData;


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.view1,container,false);

        myListView=(ListView)rootView.findViewById(R.id.mySuperListView1);

        rowItemsList=new ArrayList<>();

        productName=getResources().getStringArray(R.array.mainlist);
        productDesc=getResources().getStringArray(R.array.detailed);

        for(int i=0;i<productName.length;i++)
        {
            rowItemsList.add(new Event(productName[i],new Date(1220,12,11), productDesc[i]));
        }

        adapter= new View_EventListAdapter(getActivity(), rowItemsList);

        myListView.setAdapter(adapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), View_Events_Details.class);
                intent.putExtra("postition",position);
                startActivity(intent);
            }
        });

        myListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);

        myListView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                final int checkedCount = myListView.getCheckedItemCount();
                switch (checkedCount) {
                    case 0:
                        mode.setTitle(null);
                        break;
                    case 1:
                        mode.setTitle(R.string.selected_one);
                        break;
                    default:
                        String mystring = getResources().getString(R.string.selected_more);
                        mystring+=" ";
                        mode.setTitle(mystring+checkedCount);
                        break;
                }
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater1=mode.getMenuInflater();
                inflater1.inflate(R.menu.my_menu,menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });

        return rootView;
    }
}
