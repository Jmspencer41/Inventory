package com.inventory.controllers;

import com.inventory.classes.Item;
import com.inventory.frontends.AddInventory;
import com.inventory.frontends.InventoryApplication;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AddInventoryController {

    @FXML
    private TextField itemNameTextField;
    @FXML
    private TextField descriptionTextField;
    @FXML
    private TextField priceTextField;
    @FXML
    private TextField quantityTextField;


    @FXML
    protected void onAddInventoryClick() throws IOException {

        String itemName = itemNameTextField.getText();
        String itemDescription = descriptionTextField.getText();
        double itemPrice;
        int itemQuantity;

        // Check if the price and quantity fields are empty
        if (priceTextField.getText().isEmpty() || quantityTextField.getText().isEmpty()) {
            throw new IOException("Price and Quantity fields cannot be empty");
        } else {
            try {
                itemPrice = Double.parseDouble(priceTextField.getText());
                itemQuantity = Integer.parseInt(quantityTextField.getText());
            }
            catch (NumberFormatException e) {
                throw new IOException("Price and Quantity must be numbers");
            }
        }

        Item newItem = new Item(itemName, itemDescription, itemPrice, itemQuantity);
        ScrollPane ScrollPane = InventoryApplication.inventoryScrollPane;

        // Add the new item to the inventory
        try {
            InventoryApplication.inventory.addItem(newItem, ScrollPane);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Write the new item to the inventory file
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(InventoryApplication.inventoryFilePath, true));
            out.write(newItem.getName() + "," + newItem.getDescription() + "," + newItem.getPrice() + "," + newItem.getQuantity() + "\n");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        AddInventory.close(); // Close the Add Inventory window

    }

}
