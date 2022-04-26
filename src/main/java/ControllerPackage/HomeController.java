package ControllerPackage;


import ApplicationPackage.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ControllerPackage.LoginController;
import ControllerPackage.ProfileController;
import ControllerPackage.ProfileController;
import ModelPackage.User;

import java.io.IOException;

import static ControllerPackage.LoginController.local_user;

public class HomeController {

    FXMLLoader loader = new FXMLLoader();


    public void onProfileButtonClick(ActionEvent event) throws Exception {
        //name_label.setText(local_user.getFirst_name());
        try {
            FXMLLoader fmxloader = new FXMLLoader(getClass().getResource("/ApplicationPackage/Profile.fxml"));
            Parent root1 = (Parent) fmxloader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

