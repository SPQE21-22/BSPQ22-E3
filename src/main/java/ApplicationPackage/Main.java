package ApplicationPackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));

        //int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
        //int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();
        Scene scene = new Scene(fxmlLoader.load(), 355,284);
        stage.setTitle("Welcome to the DeustoFood Recipe App!");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}