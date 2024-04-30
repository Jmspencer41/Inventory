package com.inventory.controllers;

import com.inventory.frontends.EditInventory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import com.inventory.classes.Item;

import java.io.IOException;

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

    public void setItemData(Item item) {
        this.item = item;
        nameLabel.setText(item.getName());
        descriptionLabel.setText(item.getDescription());
        priceLabel.setText("$" + item.getPrice());
        quantityLabel.setText(String.valueOf(item.getQuantity()));
        totalPriceLabel.setText("$" + item.getTotalPrice());
    }

    public void onEditClick(ActionEvent actionEvent) throws IOException {
        EditInventory editInventory = new EditInventory(item);
    }


}