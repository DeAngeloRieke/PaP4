package com.example.deangelorieke.dnd;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class NewCharacter extends AppCompatActivity {
    public int count = 0;
    SharedPreferences prefs;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        prefs = this.getSharedPreferences(
                "com.example.deangelorieke.dnd", Context.MODE_PRIVATE);
        count = prefs.getInt("count",0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_character);

        final Character C = new Character();
        List<String> Classes = new ArrayList<String>();
        Classes.add("Barbarian");
        Classes.add("Bard");
        Classes.add("Cleric");
        Classes.add("Druid");
        Classes.add("Fighter");
        Classes.add("Monk");
        Classes.add("Paladin");
        Classes.add("Ranger");
        Classes.add("Rogue");
        Classes.add("Sorcerer");
        Classes.add("Warlock");
        Classes.add("Wizard");

        ArrayAdapter<String> classadapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, Classes);

        classadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner classItems = (Spinner) findViewById(R.id.classSpinner);
        classItems.setAdapter(classadapter);

        List<String> BG = new ArrayList<String>();
        BG.add("Adventurer");

        ArrayAdapter<String> bgAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, BG);

        bgAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner bgItem = (Spinner) findViewById(R.id.bgSpinner);
        bgItem.setAdapter(bgAdapter);

        List<String> Races = new ArrayList<String>();
        Races.add("Dragonborn");
        Races.add("Dwarf");
        Races.add("Elf");
        Races.add("Gnome");
        Races.add("Half Elf");
        Races.add("Half Orc");
        Races.add("Halfling");
        Races.add("Human");
        Races.add("Tiefling");

        ArrayAdapter<String> raceAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, Races);

        raceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner raceItems = (Spinner) findViewById(R.id.raceSpinner);
        raceItems.setAdapter(raceAdapter);

        List<String> Align = new ArrayList<String>();
        Align.add("Lawful Good");
        Align.add("Lawful Neutral");
        Align.add("Lawful Evil");
        Align.add("Neutral Good");
        Align.add("True Neutral");
        Align.add("Neutral Evil");
        Align.add("Chaotic Good");
        Align.add("Chaotic Neutral");
        Align.add("Chaotic Evil");

        ArrayAdapter<String> alignAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, Align);

        alignAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner alignSpinner = (Spinner) findViewById(R.id.alSpinner);
        alignSpinner.setAdapter(alignAdapter);

        List<String> lvl = new ArrayList<String>();
        lvl.add("1");
        lvl.add("2");
        lvl.add("3");
        lvl.add("4");
        lvl.add("5");
        lvl.add("6");
        lvl.add("7");
        lvl.add("8");
        lvl.add("9");
        lvl.add("10");
        lvl.add("11");
        lvl.add("12");
        lvl.add("13");
        lvl.add("14");
        lvl.add("15");
        lvl.add("16");
        lvl.add("17");
        lvl.add("18");
        lvl.add("19");
        lvl.add("20");

        ArrayAdapter<String> lvlAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, lvl);

        lvlAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner lvlSpinner = (Spinner) findViewById(R.id.lvlSpinner);
        lvlSpinner.setAdapter(lvlAdapter);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        actionbar.setTitle("New Character");

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
                        else if (menuItem.toString().equals("Existing Character"))
                        {
                            sendExiChar();
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
        Button next = findViewById(R.id.cc1NextButton);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nameET = (EditText) findViewById(R.id.nameInput);
                String nameSt = nameET.getText().toString();
                Spinner lvlET = (Spinner) findViewById(R.id.lvlSpinner);
                String lvlSt = lvlET.getSelectedItem().toString();
                Spinner classET = (Spinner) findViewById(R.id.classSpinner);
                String classST = classET.getSelectedItem().toString();
                addToSharedPref(nameSt, lvlSt, classST);
                Intent ccNext = new Intent(NewCharacter.this, statallocation.class);
                startActivityForResult(ccNext, 1);
            }
        });
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
    public void sendExiChar()
    {
        Intent exiCharIntent = new Intent(this,ExistingCharacters.class);
        startActivity(exiCharIntent);
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
    public void addToSharedPref(String name, String lvl, String Class)
    {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("name" + count, name);
        editor.putString("lvl" + count, lvl);
        editor.putString("class" + count, Class);
        count++;
        editor.putInt("count", count);
        editor.apply();
    }
}