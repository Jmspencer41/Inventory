package com.inventory.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InventoryLocations implements Location{
    private ArrayList<String> locations;
    private String name;

    public InventoryLocations() throws IOException {
        locations = new ArrayList<>();
        String line = "";

        BufferedReader in = new BufferedReader(new FileReader("src/main/resources/files/locations.txt"));
        while (line != null) {
            line = in.readLine();
            locations.add(line);
        }
        in.close();
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
