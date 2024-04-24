package com.inventory.classes;

public class InventoryLocations implements Location{
    private String name;

    public InventoryLocations(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
