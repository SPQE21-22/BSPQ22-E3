package ApplicationPackage;

import MongoConnector.MyConnector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;




public class Main extends Application {
    @SuppressWarnings("ClassEscapesDefinedScope")
    public static MyConnector connector;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Welcome to Deusto Foods!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        connector =  new MyConnector();
        launch();
    }
}