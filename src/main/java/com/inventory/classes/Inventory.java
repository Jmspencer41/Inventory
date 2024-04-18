package com.inventory.classes;

import com.inventory.controllers.ItemHBoxController;
import javafx.fxml.FXMLLoader;
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
