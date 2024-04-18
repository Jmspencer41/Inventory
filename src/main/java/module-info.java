module com.inventory.inventory {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.inventory.frontends to javafx.fxml;
    exports com.inventory.frontends;
    exports com.inventory.controllers;
    opens com.inventory.controllers to javafx.fxml;
    exports com.inventory.classes;
    opens com.inventory.classes to javafx.fxml;
}