package ControllerPackage;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import ControllerPackage.LoginController;
import ModelPackage.User;

import java.net.URL;
import java.util.Optional;
import ApplicationPackage.Main;
import ModelPackage.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import ControllerPackage.LoginController;
import ControllerPackage.ProfileController;
import ModelPackage.User;

import java.io.IOException;
import java.util.ResourceBundle;

import static ControllerPackage.LoginController.local_user;

public class ProfileController {

    FXMLLoader loader = new FXMLLoader();

    @FXML
    private Label name_label;

    public void onLogOutButtonClick(ActionEvent event) throws Exception {
        try {

            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Salir");
            alerta.setHeaderText("¿Está seguro?");
            Optional<ButtonType> resultado = alerta.showAndWait();

            if (resultado.get() == ButtonType.OK) {
                System.exit(0);
            } else {
                event.consume();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
