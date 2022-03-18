module com.example.recipeapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.recipeapp to javafx.fxml;
    exports com.example.recipeapp;
}