package com.inventory.classes;

import com.inventory.controllers.ItemHBoxController;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import com.inventory.frontends.InventoryApplication;
import com.inventory.controllers.EditInventoryController;

public class Inventory {
    public static ArrayList<Item> inventory;
    public static int inventoryItemCount; //Might not need this

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

    public void addItem(Item item, ScrollPane scrollPane) throws IOException {
        inventory.add(item);
        showInventory(scrollPane);
    }

    public void removeItem(int index, ScrollPane scrollPane) throws IOException {
        inventory.remove(index);
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

//    public HBox createItemHBox(Item item) {
//        HBox itemHBox = new HBox();
//        itemHBox.getChildren().add(new Label(item.getName()));
//        itemHBox.getChildren().add(new Label(item.getDescription()));
//        itemHBox.getChildren().add(new Label("$" + item.getPrice()));
//        itemHBox.getChildren().add(new Label("" + item.getQuantity()));
//        itemHBox.getChildren().add(new Label("$" + item.getTotalPrice()));
//        itemHBox.getChildren().add(new Button("Edit"));
//        itemHBox.setSpacing(10);
//        itemHBox.setAlignment(Pos.CENTER);
//        itemHBox.setMaxWidth(3000);
//        HBox.setHgrow(itemHBox, Priority.ALWAYS);
//
//        return itemHBox;
//    }
}