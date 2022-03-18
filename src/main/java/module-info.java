module com.example.recipeapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens ApplicationPackage to javafx.fxml;
    exports ApplicationPackage;
}