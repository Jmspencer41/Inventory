package com.inventory.classes;

import javafx.scene.control.Alert;

import java.io.*;
import java.util.ArrayList;

public class InventoryLocations{
    private ArrayList<String> locations;
    private final String LOCATION_FILE_PATH = "src/main/resources/files/locations.txt";
    private String name;

    public InventoryLocations() throws IOException {
        locations = new ArrayList<>();
        String line = "";

        BufferedReader in = new BufferedReader(new FileReader(LOCATION_FILE_PATH));
        while (line != null) {
            line = in.readLine();
            locations.add(line);
        }
        in.close();
    }

    public String getLocation(String location) {
        return name;
    }

    public void addLocation(String location) {
        locations.add(location);
    }

    public void removeLocation(String location) {
        locations.remove(location.indexOf(location));
    }

    public void saveLocation() {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(LOCATION_FILE_PATH));

        } catch (IOException e) {
            Alert success = new Alert(Alert.AlertType.ERROR);
            success.setTitle("Save");
            success.setHeaderText("Save Unsuccessful");
            success.setContentText(e.getMessage() + " Location data was not able to save.");
            success.show();
            e.printStackTrace();
        }
    }
}
