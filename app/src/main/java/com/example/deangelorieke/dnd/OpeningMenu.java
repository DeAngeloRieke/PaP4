package com.example.deangelorieke.dnd;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class OpeningMenu extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
   // private ActionBarDrawerToggle mToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening_menu);

        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
       // ActionBar actionbar = getSupportActionBar();
        //actionbar.setDisplayHomeAsUpEnabled(true);
        //actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        //actionbar.setTitle("Spice Rack");

        mDrawerLayout = findViewById(R.id.drawer_layout);
       // mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.Open, R.string.Close);

        //mDrawerLayout.addDrawerListener(mToggle);
        //mToggle.syncState();

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();

                        if (menuItem.toString().equals("Pantry"))
                        {

                        }
                        else if (menuItem.toString().equals("Grocery List"))
                        {

                        }
                        else if (menuItem.toString().equals("Recipe List"))
                        {

                        }
                        else if (menuItem.toString().equals("Allergies"))
                        {

                        }
                        else if (menuItem.toString().equals("Login"))
                        {

                        }
                        else if (menuItem.toString().equals("About"))
                        {

                        }

                        return true;
                    }
                }
        );
    }
}
