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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class NewCharacter extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
                EditText ET = (EditText) findViewById(R.id.nameInput);
                C.setCName(ET.getText().toString());
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

//Backgrounds:
//      Acolyte          	PHB	Insight (WIS), religion (INT)	Any x2	None
//      Anthropologist	        ToA	Insight (WIS), religion (INT)	Any x2	None
//      Archaeologist	        ToA	History (INT), survival (WIS)	Any x1	Choose 1: cartographer's tools, navigator's tools
//      Black Fist            Double Agent	CoS (AL)	Deception (CHA), insight (WIS)	None	Disguise kit, and choose 1: artisan's tools x1, gaming set x1
//      Caravan Specialist      	EE (AL)	Animal handling (WIS), survival (WIS)	Any x1	Vehicles (land)
//      Charlatan	         PHB	Deception (CHA), sleight of hand (DEX)	None	Disguise kit, forgery kit
//      City Watch	          SCAG	Athletics (STR), insight (WIS)	Any x2	None
//      Clan Crafter	       SCAG	History (INT), insight (WIS)	Any x1	Artisan's tools x1
//      Cloistered Scholar	       SCAG	History (INT), and choose 1: arcana (INT), nature (INT), religion (INT)	Any x2	None
//      Cormanthor Refugee	        RoD (AL)	Nature (INT), survival (WIS)	Elvish	Artisan's tools x1
//      Courtier	       SCAG	Insight (WIS), persuasion (CHA)	Any x2	None
//      Criminal	         PHB	Deception (CHA), stealth (DEX)	None	Gaming set x1, thieves' tools
//      Dissenter	         PS:A	Special (See page)	Special (See page)	Special (See page)
//      Dragon Casualty	          CoS (AL)	Intimidation (CHA), survival (WIS)	Draconic	Special (See page)
//      Earthspur Miner      	EE (AL)	Athletics (STR), survival (WIS)	Dwarvish, Undercommon	None
//      Entertainer         	PHB	Acrobatics (DEX), performance (CHA)	None	Disguise kit, musical instrument x1
//      Faction Agent	     SCAG	Insight (WIS), and choose 1: special (See page)	Any x2	None
//      Far Traveler	       SCAG	Insight (WIS), perception (WIS)	Any x1	Choose 1: musical instrument x1, gaming set x1
//      Folk Hero	              PHB	Animal handling (WIS), survival (WIS)	None	Artisan's tools x1, vehicles (land)
//      Gate Urchin	               RoD (AL)	Deception (CHA), sleight of hand (DEX)	None	Musical instrument x1, thieves' tools
//      Gladiator	               PHB	Acrobatics (DEX), performance (CHA)	None	Disguise kit, unusual weapon x1
//      Guild Artisan	            PHB	Insight (WIS), persuasion (CHA)	Any x1	Artisan's tools x1
//      Guild Merchant	            PHB	Insight (WIS), persuasion (CHA)	Any x1	Navigator's tools
//      Harborfolk	                EE (AL)	Athletics (STR), sleight of hand (DEX)	None	Gaming set x1, vehicles (water)
//      Haunted One                   	CoS	Choose 2: Arcana (INT), investigation (INT), religion (INT), survival (WIS)	Exotic x1	None
//      Hermit	                   PHB	Medicine (WIS), religion (INT)	Any x1	Herbalism kit
//      Hillsfar Merchant               	RoD (AL)	Insight (WIS), persuasion (CHA)	None	Vehicles (land), vehicles (water)
//      Hillsfar Smuggler	         RoD (AL)	Perception (WIS), stealth (DEX)	Any x1	Forgery kit
//      House Agent	                  WGE	Investigation (INT), persuasion (CHA)	None	Special (See page)
//      Inheritor	               SCAG	Survival (WIS), and choose 1: arcana (INT), history (INT), religion (INT)	None	Gaming set x1, musical instrument x1
//      Initiate	             PS:A	Athletics (STR), intimidation (CHA)	None	Gaming set x1, vehicles (land)
//      Inquisitor	                PS:In	Investigation (INT), religion (INT)	None	Artisan's tools x1, thieves' tools
//      Investigator              	SCAG	Insight (WIS), investigation (INT)	Any x2	None
//      Iron Route Bandit                 	CoS (AL)	Animal handling (WIS), stealth (DEX)	None	Gaming set x1, vehicles (land)
//      Knight                      	PHB	History (INT), persuasion (CHA)	Any x1	Gaming set x1
//      Knight of the Order	                 SCAG	Persuasion (CHA), and choose 1: special (See page)	Any x1	Choose 1: gaming set x1, musical instrument x1
//      Mercenary Veteran	              SCAG	Athletics (STR), persuasion (CHA)	None	Gaming set x1, vehicles (land)
//      Mulmaster Aristocrat	               EE (AL)	Deception (CHA), performance (CHA)	None	Artisan's tools x1, musical instrument x1
//      Noble	                     PHB	History (INT), persuasion (CHA)	Any x1	Gaming set x1
//      Outlander	                PHB	Athletics (STR), survival (WIS)	Any x1	Musical instrument x1
//      Phlan Insurgent	                 CoS (AL)	Stealth (DEX), survival (WIS)	None	Artisan's tools x1, vehicles (land)
//      Phlan Refugee	             EE (AL)	Athletics (STR), insight (WIS)	Any x1	Artisan's tools x1
//      Pirate	                     PHB	Athletics (STR), perception (WIS)	None	Navigator's tools, vehicles (water)
//      Sage	                     PHB	Arcana (INT), history (INT)	Any x2	None
//      Sailor	                     PHB	Athletics (STR), perception (WIS)	None	Navigator's tools, vehicles (water)
//      Secret Identity         	RoD (AL)	Deception (CHA), stealth (DEX)	None	Disguise kit, forgery kit
//      Shade Fanatic	             RoD (AL)	Deception (CHA), intimidation (CHA)	Netherese	Forgery kit
//      Soldier                  	PHB	Athletics (STR), intimidation (CHA)	None	Gaming set x1, vehicles (land)
//      Spy                        	PHB	Deception (CHA), stealth (DEX)	None	Gaming set x1, thieves' tools
//      Stojanow Prisoner	                CoS (AL)	Deception (CHA), perception (WIS)	None	Gaming set x1, thieves' tools
//      Ticklebelly Nomad	                      CoS (AL)	Animal handling (WIS), nature (INT)	Giant	Herbalism kit
//      Trade Sheriff	                        RoD (AL)	Investigation (INT), persuasion (CHA)	Elvish	Thieves' tools
//      Urban Bounty Hunter	                 SCAG	Choose 2: deception (CHA), insight (WIS), persuasion (CHA), stealth (DEX)	None	Choose 2: gaming set x1, musical instrument x1, thieves' tools
//      Urchin	                          PHB	Sleight of hand (DEX), stealth (DEX)	None	Disguise kit, thieves' tools
//      Uthgardt Tribe Member                	SCAG	Athletics (STR), survival (WIS)	Any x1	Choose 1: artisan's tools x1, musical instrument x1
//      Vizier                         	PS:A	History (INT), religion (INT)	None	Artisan's tools x1, musical instrument x1
//      Waterdhavian Noble                  	SCAG	History (INT), persuasion (CHA)	Any x1	Choose 1: gaming set x1, musical instrument x1

//Alignment:
//Chaotic good evil, neutral; Lawful good, evil, neutral; Neutral good, true neutral, neutral evil;

//Level 1-20;