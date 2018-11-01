package com.example.deangelorieke.dnd;

import java.lang.reflect.Array;

    class Item {
    private int power;
    private String iName;
    private String Descr;

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

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
