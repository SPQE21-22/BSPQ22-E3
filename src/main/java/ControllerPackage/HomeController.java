package ControllerPackage;


import ApplicationPackage.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ControllerPackage.LoginController;
import ControllerPackage.ProfileController;
import ControllerPackage.ProfileController;
import ModelPackage.User;

import java.io.IOException;
import java.util.Optional;

import static ApplicationPackage.Main.window2;
import static ControllerPackage.LoginController.local_user;

public class HomeController {

    FXMLLoader loader = new FXMLLoader();
    private AnchorPane anchorPane;


    public void onProfileButtonClick(ActionEvent event) throws Exception {

        try {
            FXMLLoader fmxloader = new FXMLLoader(getClass().getResource("/ApplicationPackage/Profile.fxml"));
            Parent root1 = (Parent) fmxloader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Your Profile");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void onHeartButtonClick(ActionEvent event) throws Exception {
        try {
            window2.setTitle("Welcome, please login");
            this.loader.setLocation(Main.class.getResource("Favorites.fxml"));
            this.anchorPane = (AnchorPane)this.loader.load();
            Scene scene2 = new Scene(this.anchorPane);
            window2.setScene(scene2);
            window2.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

