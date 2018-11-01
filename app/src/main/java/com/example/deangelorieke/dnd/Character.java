package com.example.deangelorieke.dnd;

import java.lang.reflect.Array;

public class Character {
    private int characterId;
    private String CName;
    private String CRace;
    private String CClass;
    private String CAlignment;
    private String CBackground;
    private String Flavortext;
    private int Strength;
    private int Intel;
    private int Dex;
    private int Wisdom;
    private int Charisma;
    private int Cons;
    private int CarryW = 150;
    Item[] IArray = new Item[CarryW];

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public String getCRace() {
        return CRace;
    }

    public void setCRace(String CRace) {
        this.CRace = CRace;
    }

    public String getCClass() {
        return CClass;
    }

    public void setCClass(String CClass) {
        this.CClass = CClass;
    }

    public String getCAlignment() {
        return CAlignment;
    }

    public void setCAlignment(String CAlignment) {
        this.CAlignment = CAlignment;
    }

    public String getCBackground() {
        return CBackground;
    }

    public void setCBackground(String CBackground) {
        this.CBackground = CBackground;
    }

    public String getFlavortext() {
        return Flavortext;
    }

    public void setFlavortext(String flavortext) {
        Flavortext = flavortext;
    }

    public int getStrength() {
        return Strength;
    }

    public void setStrength(int strength) {
        Strength = strength;
    }

    public int getIntel() {
        return Intel;
    }

    public void setIntel(int intel) {
        Intel = intel;
    }

    public int getDex() {
        return Dex;
    }

    public void setDex(int dex) {
        Dex = dex;
    }

    public int getWisdom() {
        return Wisdom;
    }

    public void setWisdom(int wisdom) {
        Wisdom = wisdom;
    }

    public int getCharisma() {
        return Charisma;
    }

    public void setCharisma(int charisma) {
        Charisma = charisma;
    }

    public int getCons() {
        return Cons;
    }

    public void setCons(int cons) {
        Cons = cons;
    }

    public int getCarryW() {
        return CarryW;
    }

    public void setCarryW(int carryW) {
        CarryW = carryW;
    }

    public Item[] getIArray() {
        return IArray;
    }

    public void setIArray(Item[] IArray) {
        this.IArray = IArray;
    }
}