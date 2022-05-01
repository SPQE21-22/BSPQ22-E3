package ApplicationPackage;

import MongoConnector.MyConnector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main extends Application {
    @SuppressWarnings("ClassEscapesDefinedScope")
    public static MyConnector connector;
    // Switch Scenes Variables:
    FXMLLoader loader = new FXMLLoader();
    public static Stage window2;
    public static String message = "";
    Logger logger = LoggerFactory.getLogger(Main.class);


    @Override
    public void start(Stage window1) throws IOException {

        window2 = window1;
        window2.setTitle("Welcome");
        window2.setResizable(false);
        this.loader.setLocation(Main.class.getResource("Login.fxml"));
        AnchorPane anchorPane = this.loader.load();
        Scene scene1 = new Scene(anchorPane);
        window2.setScene(scene1);
        window2.show();
        logger.info("This is the Main Logger");

    }


    public static void main(String[] args) {
        if (connector == null) {
            connector = new MyConnector();
        }
        launch();
    }
}