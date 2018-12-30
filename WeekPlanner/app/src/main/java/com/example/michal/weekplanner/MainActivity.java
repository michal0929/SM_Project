package com.example.michal.weekplanner;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.michal.weekplanner.model.ItemSlideMenu;
import com.example.michal.weekplanner.adapters.SlideMenuAdapter;
import com.example.michal.weekplanner.fragments.*;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ItemSlideMenu> listSliding;
    private SlideMenuAdapter adapter;
    private ListView listViewSliding;
    private DrawerLayout drawerLayout;
    private Context context;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewSliding=(ListView)findViewById(R.id.lv_sliding_menu);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        listSliding = new ArrayList<>();
        listSliding.add(new ItemSlideMenu(R.string.start));
        listSliding.add(new ItemSlideMenu(R.string.viewI));
        listSliding.add(new ItemSlideMenu(R.string.viewII));
        listSliding.add(new ItemSlideMenu(R.string.viewIII));

        adapter = new SlideMenuAdapter(this, listSliding);

        listViewSliding.setAdapter(adapter);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        setTitle(listSliding.get(0).getTitle());
        listViewSliding.setItemChecked(0,true);
        drawerLayout.closeDrawer(listViewSliding);

        replaceFragment(0);

        listViewSliding.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setTitle(listSliding.get(position).getTitle()); //bobiera tytuł i ustawia go

                listViewSliding.setItemChecked(position, true);

                replaceFragment(position);

                drawerLayout.closeDrawer(listViewSliding);
            }
        });

        actionBarDrawerToggle= new ActionBarDrawerToggle(this,drawerLayout, R.string.drawer_opened, R.string.drawer_close)
        {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }
        };
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        this.context = this;



    }

    public boolean onOptionsItemSelected(MenuItem item)//służy do obracania się hambure
    {
        if(actionBarDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onPostCreate(Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    private  void replaceFragment(int pos)
    {
        Fragment fragment=null;
        switch(pos)
        {
            case 0:
                fragment= new Start();
                break;
            case 1:
                fragment= new View_Events();
                break;
            case 2:
                fragment= new ViewII_ShoppingList();
                break;
            default:
                fragment= new ViewIII_Notebook();
                break;
        }
        if(null!=fragment)
        {
            // podmiana fragmentow poprzez fragment manager
            FragmentManager fragmentManager=getFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.main_content, fragment);
            transaction.commit();
        }

    }
}
