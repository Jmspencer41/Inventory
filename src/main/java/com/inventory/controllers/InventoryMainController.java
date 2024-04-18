package com.inventory.controllers;

import com.inventory.frontends.AddInventory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;

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
}