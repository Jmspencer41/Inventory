package com.inventory.frontends;

import com.inventory.classes.Item;
import com.inventory.controllers.EditInventoryController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EditInventory {


    public static Stage EditStage;
    private static int index;
    public EditInventory(Item item) throws IOException {
        //index = item.getIndex();
        EditInventoryController.setFields(item);
        System.out.println(item.getName());
        FXMLLoader fxmlLoader = new FXMLLoader(InventoryApplication.class.getResource("edit-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 720, 720);

        EditStage = new Stage();
        EditStage.setTitle("Edit Inventory");
        EditStage.setScene(scene);
        EditStage.show();

    }
    public static int getIndex() {
        return index;
    }

    public void close() {
        EditStage.close();
    }
}
