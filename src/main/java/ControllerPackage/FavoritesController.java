package ControllerPackage;

import ApplicationPackage.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import static ApplicationPackage.Main.window2;

public class FavoritesController {
    FXMLLoader loader = new FXMLLoader();
    private AnchorPane anchorPane;

    public void onBackButtonClick() throws IOException {
        switchToHome();
    }

    public void switchToHome() throws IOException {
        this.loader.setLocation(Main.class.getResource("Home.fxml"));
        this.anchorPane = (AnchorPane)this.loader.load();
        Scene scene2 = new Scene(this.anchorPane);
        window2.setScene(scene2);
        window2.show();

    }

}
