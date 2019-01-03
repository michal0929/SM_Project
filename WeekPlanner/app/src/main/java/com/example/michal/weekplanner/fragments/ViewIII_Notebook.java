package com.example.michal.weekplanner.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.michal.weekplanner.MainActivity;
import com.example.michal.weekplanner.R;
import com.example.michal.weekplanner.adapters.ViewIII_ItemListNotebookAdapter;
import com.example.michal.weekplanner.model.ItemListNotebook;

import java.util.ArrayList;
import java.util.List;

public class ViewIII_Notebook extends Fragment {


    ListView myListView;
    List<ItemListNotebook> itemsListListNotebook;
    ViewIII_ItemListNotebookAdapter adapter;

    String[] productName;
    String[] productDesc;
    TypedArray productPics;


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.view3,container,false);

        myListView=(ListView)rootView.findViewById(R.id.mySuperListView3);

        itemsListListNotebook =new ArrayList<>();

        productName=getResources().getStringArray(R.array.mainlist);
        productPics=getResources().obtainTypedArray(R.array.superPics);
        productDesc=getResources().getStringArray(R.array.detailed);

        for(int i=0;i<productName.length;i++)
        {
            itemsListListNotebook.add(new ItemListNotebook(productName[i],productPics.getResourceId(i,-1), productDesc[i]));
        }

        adapter=new ViewIII_ItemListNotebookAdapter(getActivity(), itemsListListNotebook);

        myListView.setAdapter(adapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ViewIII_Notebook_Details.class);
                intent.putExtra("postition",position);
                startActivity(intent);
            }
        });


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
