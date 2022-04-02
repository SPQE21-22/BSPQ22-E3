package ApplicationPackage;

import MongoConnector.MyConnector;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import com.mongodb.ConnectionString;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.bson.Document;
//import org.bson.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Welcome to the Recipe App!");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        MyConnector connector =  new MyConnector();
        launch();
    }
}