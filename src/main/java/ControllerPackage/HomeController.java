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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ControllerPackage.LoginController;
import ControllerPackage.ProfileController;
import ControllerPackage.ProfileController;
import ModelPackage.User;

import java.io.IOException;
import java.util.Optional;

import static ControllerPackage.LoginController.local_user;

public class HomeController {

    FXMLLoader loader = new FXMLLoader();


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

            Alert alerta2 = new Alert(Alert.AlertType.INFORMATION);
            alerta2.setTitle("Sorry, "+local_user.getFirst_name());
            alerta2.setHeaderText("Window under construction.");
            Optional<ButtonType> resultado = alerta2.showAndWait();

            if (resultado.get() == ButtonType.OK) {
                alerta2.close();
            } else {
                event.consume();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

