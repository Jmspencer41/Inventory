package com.inventory.frontends;

import com.inventory.classes.Item;
import com.inventory.controllers.EditInventoryController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Represents the Edit Inventory window.
 */
public class EditInventory {

    public static Stage EditStage;
    private static int index;

    /**
     * Constructor for the EditInventory class.
     * Creates and displays the Edit Inventory window.
     * 
     * @param item The item to edit
     * @throws IOException if an I/O error occurs
     */
    public EditInventory(Item item) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(InventoryApplication.class.getResource("edit-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 720, 720);

        EditInventoryController editController = fxmlLoader.getController();

        editController.setFields(item);

        index = item.getIndex();
        EditStage = new Stage();
        EditStage.setTitle("Edit Inventory");
        EditStage.setScene(scene);
        EditStage.show();

    }

    /**
     * Returns the index of the edited item.
     * 
     * @return The index of the edited item
     */
    public static int getIndex() {
        return index;
    }
}
