package com.inventory.controllers;

import com.inventory.classes.Inventory;
import com.inventory.classes.Item;
import com.inventory.frontends.InventoryApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.inventory.frontends.EditInventory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static com.inventory.frontends.InventoryApplication.inventoryScrollPane;

public class EditInventoryController {

    @FXML
    private static TextField nameField = new TextField();
    @FXML
    private static TextField descriptionField = new TextField();
    @FXML
    private static TextField priceField = new TextField();
    @FXML
    private static TextField quantityField = new TextField();

    @FXML
    public static void setFields(Item item) {
        nameField.setText(item.getName());
        descriptionField.setText(item.getDescription());
        priceField.setText(String.valueOf(item.getPrice()));
        quantityField.setText(String.valueOf(item.getQuantity()));
    }

    @FXML
    public void saveButton(ActionEvent actionEvent) {
        EditInventory.EditStage.close();
    }

    @FXML
    public void deleteButton(ActionEvent actionEvent) throws IOException {
        InventoryApplication.inventory.removeItem(EditInventory.getIndex(), inventoryScrollPane);
        EditInventory.EditStage.close();
    }
}
