package com.example.deangelorieke.dnd;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ExistingCharacters extends AppCompatActivity {
    public int count = 0;
    SharedPreferences prefs;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    public List<String> populateList = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_characters);

        prefs = this.getSharedPreferences(
                "com.example.deangelorieke.dnd", Context.MODE_PRIVATE);
        count = prefs.getInt("count",0);

        populateChar();

        ListView mainLV = (ListView) findViewById(R.id.eCListView);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                populateList );

        mainLV.setAdapter(arrayAdapter);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        actionbar.setTitle("Character List");

        mDrawerLayout = findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.Open, R.string.Close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();

                        if (menuItem.toString().equals("News"))
                        {
                            sendMenu();
                        }
                        else if (menuItem.toString().equals("Log In"))
                        {
                            sendLog();
                        }
                        else if (menuItem.toString().equals("New Character"))
                        {
                            sendNewChar();
                        }
                        else if (menuItem.toString().equals("Database"))
                        {
                            sendDB();
                        }
                        else if (menuItem.toString().equals("Monster Manual"))
                        {
                            sendMon();
                        }
                        else if (menuItem.toString().equals("Classes"))
                        {
                            sendClass();
                        }
                        else if (menuItem.toString().equals("Races"))
                        {
                            sendRace();
                        }else if (menuItem.toString().equals("Dungeon Master"))
                        {
                            sendDM();
                        }

                        return true;
                    }
                }
        );

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void sendMenu()
    {
        Intent menuIntent = new Intent(this,OpeningMenu.class);
        startActivity(menuIntent);
    }
    public void sendLog()
    {
        Intent logIntent = new Intent(this,DriveLogin.class);
        startActivity(logIntent);
    }
    public void sendNewChar()
    {
        Intent newCharIntent = new Intent(this,NewCharacter.class);
        startActivity(newCharIntent);
    }
    public void sendDB()
    {
        Intent dbIntent = new Intent(this,InfoDatabase.class);
        startActivity(dbIntent);
    }
    public void sendClass()
    {
        Intent classIntent = new Intent(this,InfoClasses.class);
        startActivity(classIntent);
    }
    public void sendMon()
    {
        Intent monIntent = new Intent(this,InfoMonsters.class);
        startActivity(monIntent);
    }
    public void sendRace()
    {
        Intent raceIntent = new Intent(this,InfoRaces.class);
        startActivity(raceIntent);
    }
    public void sendDM()
    {
        Intent dmIntent = new Intent(this,DMMode.class);
        startActivity(dmIntent);
    }
    public void populateChar()
    {
        for(int i = 0; i < count; i++)
        {
            String name = prefs.getString("name" + i, "");
            populateList.add(name);
           // String lvl = prefs.getString("lvl" + i, "");
           // populateList.add(lvl);
           // String Class = prefs.getString("class" + i, "");
           // populateList.add(Class);
        }
    }
}
