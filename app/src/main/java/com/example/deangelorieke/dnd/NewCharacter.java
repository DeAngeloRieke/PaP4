package com.example.deangelorieke.dnd;

import android.content.Intent;
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
import android.widget.Button;
import android.widget.EditText;

public class NewCharacter extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_character);

        final Character C = new Character();

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
                EditText ET = (EditText) findViewById(R.id.nameInput);
                C.CName = ET.getText().toString();
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
}
