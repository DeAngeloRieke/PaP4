package com.example.deangelorieke.dnd;

import java.lang.reflect.Array;

public class Item {
    int power;

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }

    public String getDescr() {
        return Descr;
    }

    public void setDescr(String descr) {
        Descr = descr;
    }

    String iName;
    String Descr;

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
