module com.example.recipeapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.bson;
    requires org.mongodb.driver.core;
    requires com.fasterxml.jackson.databind;


    opens ApplicationPackage to javafx.fxml;
    exports ApplicationPackage;
    opens ControllerPackage to javafx.fxml;
    exports ControllerPackage;
}
