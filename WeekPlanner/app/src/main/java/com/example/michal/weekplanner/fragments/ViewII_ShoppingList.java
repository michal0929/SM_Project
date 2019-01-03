package com.example.michal.weekplanner.fragments;

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
import com.example.michal.weekplanner.adapters.ViewII_ItemListAdapter;
import com.example.michal.weekplanner.model.ItemList;

import java.util.ArrayList;
import java.util.List;


public class ViewII_ShoppingList extends Fragment {


    public static final String ID_TAG = "ElementID";
    ListView myListView;
    List<ItemList> ItemsList;
    ViewII_ItemListAdapter adapter;

    private AppDatabase database;
    String[] productName;
    String[] productDesc;
    @SuppressLint("ValidFragment")
    public ViewII_ShoppingList(AppDatabase database) {
        this.database = database;
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ItemsList=new ArrayList<>();
        database.elementShoppingDao().insertAll();
        ItemsList = database.elementShoppingDao().getAllElements();
        View rootView=inflater.inflate(R.layout.view2,container,false);

        myListView=(ListView)rootView.findViewById(R.id.mySuperListView2);

        adapter=new ViewII_ItemListAdapter(getActivity(), ItemsList);

        myListView.setAdapter(adapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int ID = ItemsList.get(position).getId();
                Intent intent = new Intent(getActivity(), ViewII_ShoppingList_Details.class);
                intent.putExtra(ID_TAG, ID);
                startActivity(intent);
            }
        });

        Button button = rootView.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), ViewII_ShoppingList_Add.class);
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
