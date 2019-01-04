package com.example.michal.weekplanner.fragments.View;

import android.annotation.SuppressLint;
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
import android.widget.Button;
import android.widget.ListView;

import com.example.michal.weekplanner.AppDatabase;
import com.example.michal.weekplanner.R;
import com.example.michal.weekplanner.adapters.View_EventListAdapter;
import com.example.michal.weekplanner.model.Event;


import java.util.ArrayList;
import java.util.List;


public class View_Events extends Fragment {

    public static final String ID_TAG = "ElementID";
    ListView myListView;
    List<Event> EventItemsList;
    View_EventListAdapter adapter;

    private AppDatabase database;
    @SuppressLint("ValidFragment")
    public View_Events(AppDatabase database) {
        this.database = database;
    }


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        EventItemsList=new ArrayList<>();
        database.elementEventDao().insertAllE();
        EventItemsList = database.elementEventDao().getAllElementsE();

        View rootView=inflater.inflate(R.layout.view1,container,false);

        myListView=(ListView)rootView.findViewById(R.id.mySuperListView1);

        adapter= new View_EventListAdapter(getActivity(), EventItemsList);

        myListView.setAdapter(adapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int ID = EventItemsList.get(position).getId();
                Intent intent = new Intent(getActivity(), View_Events_Details.class);
                intent.putExtra(ID_TAG, ID);
                startActivity(intent);
            }
        });

        Button button = rootView.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), View_Events_Add.class);
                startActivity(myIntent);
                myListView.invalidateViews();
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
