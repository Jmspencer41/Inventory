package com.inventory.frontends;

import com.inventory.classes.Inventory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InventoryApplication extends Application {
    public static Inventory inventory;
    public static ScrollPane inventoryScrollPane;
    public static BufferedReader in;
    public static String inventoryFilePath = "src/main/resources/files/inventory.txt";
    public static Stage primaryStage;
    private static Scene mainScene;

    @Override
    public void start(Stage primaryStage) throws IOException {
        InventoryApplication.primaryStage = primaryStage;
        FXMLLoader fxmlLoader = new FXMLLoader(InventoryApplication.class.getResource("home-view.fxml"));
        Parent root = fxmlLoader.load();
        mainScene = new Scene(root, 1200, 800);

        inventoryScrollPane = (ScrollPane) mainScene.lookup("#inventoryScrollPane");

        try {
            in = new BufferedReader(new FileReader(inventoryFilePath));
        } catch (IOException e) {
            try {
                new FileWriter(inventoryFilePath).close();
            } catch (IOException ioException) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                ioException.printStackTrace();
            }
        }


        inventory = new Inventory();
        try {
            inventory.showInventory(inventoryScrollPane);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Could not get inventory scroll pane. " + e.getMessage());
            alert.show();
            e.printStackTrace();
        }

        InventoryApplication.primaryStage.setTitle("My Inventory");
//        setScene(this.primaryStage, scene);
        primaryStage.setTitle("My Inventory");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void setMainScene() {
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}