package com.inventory.frontends;

import com.inventory.classes.Item;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AddInventory {

    private static Stage AddInventoryStage;

    public AddInventory() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(InventoryApplication.class.getResource("add-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 720, 720);

        AddInventoryStage = new Stage();
        AddInventoryStage.setTitle("Add Inventory");
        AddInventoryStage.setScene(scene);
        AddInventoryStage.show();
    }

    public static void close() {
        AddInventoryStage.close();
    }
}
