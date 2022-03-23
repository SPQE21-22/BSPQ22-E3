package ApplicationPackage;

import com.mongodb.client.*;
import com.mongodb.ConnectionString;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.bson.Document;
//import org.bson.Document;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Welcome to the Recipe App!");
        stage.setScene(scene);
        stage.show();
        MongoClient client = MongoClients.create("mongodb+srv://group3:group3@cluster0.zr68o.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        MongoDatabase db = client.getDatabase("appDB");
        MongoCollection col = db.getCollection("Collection1");
        System.out.println(col.getNamespace());

        //System.out.println(cursor);


    }

    public static void main(String[] args) {
        launch();
    }
}