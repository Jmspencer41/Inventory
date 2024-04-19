package com.inventory.controllers;

import com.inventory.classes.Item;
import com.inventory.frontends.AddInventory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import org.controlsfx.control.action.Action;
import java.io.IOException;
import static com.inventory.frontends.InventoryApplication.inventory;

public class InventoryMainController {

    @FXML
    public TextField searchText;
    public ScrollPane inventoryScrollPane;

    @FXML
    protected void onAddInventoryClick() throws IOException {
        AddInventory addInventory = new AddInventory();
    }
    @FXML
    protected void onSettingsClick() throws IOException {

    }
    @FXML
    public void onSearchClick(ActionEvent actionEvent) {
        String searchItem = searchText.getText();

        try {
           inventory.findItem(searchItem);



        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }

    }

    @FXML
    public void onSaveClick(ActionEvent actionEvent) {
        inventory.saveInventory();
    }
}