package com.inventory.controllers;

import com.inventory.frontends.AddInventory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.controlsfx.control.action.Action;

import java.io.IOException;

import static com.inventory.frontends.InventoryApplication.inventory;

public class InventoryMainController {


    @FXML
    protected void onAddInventoryClick() throws IOException {
        AddInventory addInventory = new AddInventory();
    }
    @FXML
    protected void onSettingsClick() throws IOException {

    }
    @FXML
    public void onSearchClick(ActionEvent actionEvent) {

    }

    @FXML
    public void onSaveClick(ActionEvent actionEvent) {
        inventory.saveInventory();
    }
}