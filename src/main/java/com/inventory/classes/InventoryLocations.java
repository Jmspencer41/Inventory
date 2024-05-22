package com.inventory.classes;

import java.util.ArrayList;

public class InventoryLocations implements Location{
    private ArrayList<String> locations;
    private String name;

    public InventoryLocations(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    //TODO: Figure out how im going to do this
    public void addLocation() {

    }

    public void removeLocation() {

    }
}
