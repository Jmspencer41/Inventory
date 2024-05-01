package com.inventory.controllers;

import com.inventory.classes.Item;
import com.inventory.frontends.InventoryApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import com.inventory.frontends.EditInventory;
import java.io.IOException;
import static com.inventory.frontends.InventoryApplication.inventoryScrollPane;

/**
 * Controller class for editing inventory items.
 */
public class EditInventoryController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField descriptionField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField quantityField;

    private Item item;

    /**
     * Sets the fields with the data of the selected item.
     * 
     * @param item The item to edit
     */
    @FXML
    public void setFields(Item item) {
        this.item = item;
        nameField.setText(item.getName());
        descriptionField.setText(item.getDescription());
        priceField.setText(String.valueOf(item.getPrice()));
        quantityField.setText(String.valueOf(item.getQuantity()));
    }

    /**
     * Handles the click event of the "Save" button.
     * Saves the changes made to the item.
     * 
     * @param actionEvent The ActionEvent
     * @throws IOException if an I/O error occurs
     */
    @FXML
    public void saveButton(ActionEvent actionEvent) throws IOException {
        String name = nameField.getText();
        String description = descriptionField.getText();
        double itemPrice;
        int quantity;

        if (name.isEmpty() || description.isEmpty()) {
            throw new IOException("Price and Quantity fields cannot be empty");
        } else {
            try {
                itemPrice = Double.parseDouble(priceField.getText());
                quantity = Integer.parseInt(quantityField.getText());
            } catch (NumberFormatException e) {
                throw new IOException("Price and Quantity must be numbers");
            }
        }

        item.setName(name);
        item.setDescription(description);
        item.setPrice(itemPrice);
        item.setQuantity(quantity);
        item.setTotalPrice(itemPrice * quantity);
        InventoryApplication.inventory.updateInventoryTable(inventoryScrollPane);

        EditInventory.EditStage.close();
    }

    /**
     * Handles the click event of the "Delete" button.
     * Deletes the item from the inventory.
     * 
     * @param actionEvent The ActionEvent
     * @throws IOException if an I/O error occurs
     */
    @FXML
    public void deleteButton(ActionEvent actionEvent) throws IOException {
        InventoryApplication.inventory.removeItem(EditInventory.getIndex(), inventoryScrollPane);
        EditInventory.EditStage.close();
    }
}
