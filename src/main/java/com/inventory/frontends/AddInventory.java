package com.inventory.frontends;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Represents the Add Inventory window.
 */
public class AddInventory {

    private static Stage AddInventoryStage;

    /**
     * Constructor for the AddInventory class.
     * Creates and displays the Add Inventory window.
     * 
     * @throws IOException if an I/O error occurs
     */
    public AddInventory() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(InventoryApplication.class.getResource("add-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 720, 720);

        AddInventoryStage = new Stage();
        AddInventoryStage.setTitle("Add Inventory");
        AddInventoryStage.setScene(scene);
        AddInventoryStage.show();
    }

    /**
     * Closes the Add Inventory window.
     */
    public static void close() {
        AddInventoryStage.close();
    }
}
