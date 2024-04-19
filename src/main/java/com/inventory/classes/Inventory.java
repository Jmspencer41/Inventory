package com.inventory.classes;

import com.inventory.controllers.ItemHBoxController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import com.inventory.frontends.InventoryApplication;

public class Inventory {
    public static ArrayList<Item> inventory;
    //Don't think I need this counter?
    public static int inventoryItemCount;

    public Inventory() throws IOException {
        inventory = new ArrayList<>();
        String line = "";
        inventoryItemCount = 0;

        // Read the inventory file and add items to the inventory
        while (line != null) {
            line = InventoryApplication.in.readLine();
            if (line != null) {
                String[] item = line.split(",");
                Item newItem = new Item(item[0], item[1], Double.parseDouble(item[2]), Integer.parseInt(item[3]));
                inventory.add(newItem);
                inventoryItemCount++;
            }
        }
    }

    public int size() {
        return inventory.size();
    }

    public void addItem(Item item, ScrollPane scrollPane) throws IOException {
        inventory.add(item);
        showInventory(scrollPane);
    }

    public void removeItem(int index, ScrollPane scrollPane) throws IOException {
        inventory.remove(index);
        showInventory(scrollPane);
    }

    public void updateInventoryTable(ScrollPane scrollPane) throws IOException {
        showInventory(scrollPane);
    }

    public void showInventory(ScrollPane inventoryScrollPane) throws IOException {
        VBox vBox = new VBox();
        for (Item item : inventory) {
            URL url = InventoryApplication.class.getResource("item-hbox-view.fxml");
            FXMLLoader loader = new FXMLLoader(url);
            HBox itemHBox = loader.load();
            ItemHBoxController itemHBoxController = loader.getController();
            itemHBoxController.setItemData(item);
            vBox.getChildren().add(itemHBox);
        }
        inventoryScrollPane.setContent(vBox);
    }

    public void saveInventory() {
        try {

            BufferedWriter out = new BufferedWriter(new FileWriter(InventoryApplication.inventoryFilePath, false));

            for (Item item : inventory) {
                out.write(item.getName() + "," + item.getDescription() + "," + item.getPrice() + "," + item.getQuantity() + "\n");
            }
            out.close();
            Alert success = new Alert(Alert.AlertType.INFORMATION);
            success.setTitle("Save");
            success.setHeaderText("Save Successful");
            success.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findItem(String searchedItem) throws IOException {
        ArrayList<Item> searchResults = new ArrayList<>();
        for (Item item : inventory) {
            if (item.getName().equals(searchedItem)) {
                searchResults.add(item);
            }
        }
        if (searchResults.isEmpty()) {
            throw new IOException("Item not found.");
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(InventoryApplication.class.getResource("home-view.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 1200, 800);
            ScrollPane inventoryScrollPane = (ScrollPane) scene.lookup("#inventoryScrollPane");
            InventoryApplication.primaryStage.setScene(scene);

        }
    }
}