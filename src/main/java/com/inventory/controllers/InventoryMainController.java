package com.inventory.controllers;

import com.inventory.classes.Inventory;
import com.inventory.frontends.AddInventory;
import com.inventory.frontends.InventoryApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import java.io.IOException;
import static com.inventory.frontends.InventoryApplication.inventory;

/**
 * Controller class for the main inventory interface.
 */
public class InventoryMainController {

    @FXML
    public TextField searchText;
    public ScrollPane inventoryScrollPane;

    /**
     * Handles the click event of the "Add Inventory" button.
     * Opens the Add Inventory window.
     * @throws IOException if an I/O error occurs
     */
    @FXML
    protected void onAddInventoryClick() throws IOException {
        AddInventory addInventory = new AddInventory();
    }

    /**
     * Handles the click event of the "Settings" button.
     * Opens the settings scene.
     * @throws IOException if an I/O error occurs
     */
    @FXML
    protected void onSettingsClick() throws IOException {
        InventoryApplication.setSettingsScene();
    }

    /**
     * Handles the click event of the "Search" button.
     * Searches for an item in the inventory.
     */
    @FXML
    public void onSearchClick(ActionEvent actionEvent) {
        String searchItem = searchText.getText();

        try {
            Inventory searchInventory = new Inventory(searchItem);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }

    /**
     * Handles the click event of the "Save" button.
     * Saves the inventory.
     */
    @FXML
    public void onSaveClick(ActionEvent actionEvent) {
        inventory.saveInventory();
    }

    /**
     * Handles the click event of the "Home" button.
     * Returns to the main inventory interface.
     */
    @FXML
    public void onHomeButtonClick(ActionEvent actionEvent) {
        InventoryApplication.setMainScene();
    }

    /**
     * Handles the click event of the "Dark Mode" button.
     * Switches to dark mode (to be implemented).
     */
    @FXML
    public void darkMode(ActionEvent actionEvent) {
        InventoryApplication.setDarkMode();
    }
}