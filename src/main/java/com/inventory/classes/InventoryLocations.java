package com.inventory.classes;

import javafx.scene.control.Alert;

import java.io.*;
import java.util.ArrayList;

public class InventoryLocations{
    private static ArrayList<String> locations;
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

    public static void addLocation(String location) {
        locations.add(location);
    }

    public void removeLocation(String location) {
        locations.remove(location.indexOf(location));
    }

    public void saveLocation() {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(LOCATION_FILE_PATH));

            for (String location : locations) {
                out.write(location);
            }
            out.close();

        } catch (IOException e) {
            Alert failed = new Alert(Alert.AlertType.ERROR);
            failed.setTitle("Save");
            failed.setHeaderText("Save Unsuccessful");
            failed.setContentText(e.getMessage() + " Location data was unable to save.");
            failed.show();
            e.printStackTrace();
        }
    }
}
