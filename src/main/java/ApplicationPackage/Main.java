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
    private Stage window;
    private AnchorPane anchorPane;
    FXMLLoader loader = new FXMLLoader();
    public static Stage window2;
    public static String message = "";
    Logger logger = LoggerFactory.getLogger(Main.class);


    @Override
    public void start(Stage window1) throws IOException {
        window2 = window1;
        this.window = window1;
        this.window.setTitle("Welcome");
        this.window.setResizable(false);
        this.loader.setLocation(Main.class.getResource("Login.fxml"));
        this.anchorPane = (AnchorPane)this.loader.load();
        Scene scene1 = new Scene(this.anchorPane);
        this.window.setScene(scene1);
        this.window.show();
        logger.info("This is the Main Logger");

    }


    public static void main(String[] args) {
        connector =  new MyConnector();
        launch();
    }
}