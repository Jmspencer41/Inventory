package com.inventory.controllers;

import com.inventory.frontends.EditInventory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import com.inventory.classes.Item;

import java.io.IOException;

/**
 * Controller class for the item HBox view.
 */
public class ItemHBoxController {

    @FXML
    private Label nameLabel;
    @FXML
    private Label descriptionLabel;
    @FXML
    private Label locationLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private Label quantityLabel;
    @FXML
    private Label totalPriceLabel;
    @FXML
    private Item item;

    /**
     * Sets the data of the item in the HBox.
     * @param item The item to display
     */
    public void setItemData(Item item) {
        this.item = item;
        nameLabel.setText(item.getName());
        descriptionLabel.setText(item.getDescription());
        priceLabel.setText("$" + item.getPrice());
        quantityLabel.setText(String.valueOf(item.getQuantity()));
        totalPriceLabel.setText("$" + item.getTotalPrice());
    }

    /**
     * Handles the click event of the "Edit" button.
     * Opens the Edit Inventory window.
     * @param actionEvent The ActionEvent
     * @throws IOException if an I/O error occurs
     */
    public void onEditClick(ActionEvent actionEvent) throws IOException {
        EditInventory editInventory = new EditInventory(item);
    }

}