package com.inventory.frontends;

import com.inventory.classes.Inventory;
import com.inventory.classes.InventoryLocations;
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
import java.util.Objects;

/**
 * Represents the main application class for the inventory management system.
 */
public class InventoryApplication extends Application {
    public static Inventory inventory;
    public static InventoryLocations locations;
    public static ScrollPane inventoryScrollPane;
    public static BufferedReader in;
    public static String inventoryFilePath = "src/main/resources/files/inventory.txt";
    public static Stage primaryStage;
    private static Scene mainScene;

    /**
     * Starts the application.
     * @param primaryStage The primary stage
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        InventoryApplication.primaryStage = primaryStage;
        FXMLLoader fxmlLoader = new FXMLLoader(InventoryApplication.class.getResource("home-view.fxml"));
        Parent root = fxmlLoader.load();

        mainScene = new Scene(root, 1000, 600);
        inventoryScrollPane = (ScrollPane) mainScene.lookup("#inventoryScrollPane");

        /**
         * Read the inventory file and add items to the inventory
         * @throws IOException If the file is not found
         */
        try {
            in = new BufferedReader(new FileReader(inventoryFilePath));
        } catch (IOException e) {
            try {
                new FileWriter(inventoryFilePath).close();
            } catch (IOException ioException) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Could not create inventory file. " + ioException.getMessage());
                alert.show();
                ioException.printStackTrace();
            }
        }

        inventory = new Inventory();
        locations = new InventoryLocations();

        /**
         * Show the inventory in the scroll pane
         * @throws Exception If the scroll pane is not found
         */
        try {
            inventory.showInventory(inventoryScrollPane);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Could not get inventory scroll pane. " + e.getMessage());
            alert.show();
            e.printStackTrace();
        }

        InventoryApplication.primaryStage.setTitle("My Inventory");
        primaryStage.setTitle("My Inventory");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    /**
     * Sets the main scene.
     */
    public static void setMainScene() {
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    /**
     * Sets the settings scene.
     * @throws IOException if an I/O error occurs
     */
    public static void setSettingsScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(InventoryApplication.class.getResource("settings-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Sets the dark mode (to be implemented).
     */
    public static void setDarkMode() { // TODO: Implement dark mode
        mainScene.getStylesheets().add(Objects.requireNonNull(InventoryApplication.class.getResource("dark-mode.css")).toExternalForm());
    }

    /**
     * The main method.
     * @param args The command-line arguments
     */
    public static void main(String[] args) {
        launch();
    }
}