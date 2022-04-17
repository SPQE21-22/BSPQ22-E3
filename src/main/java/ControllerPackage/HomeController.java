package ControllerPackage;

import javafx.scene.control.Alert;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;


public class HomeController {
    public void onRegisterButtonClick(ActionEvent event) throws Exception {
        try {
            FXMLLoader fmxloader = new FXMLLoader(getClass().getResource("/ApplicationPackage/Register.fxml"));
            Parent root1 = (Parent) fmxloader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onLoginButtonClick(ActionEvent event) throws Exception {
        try {
            FXMLLoader fmxloader = new FXMLLoader(getClass().getResource("/ApplicationPackage/Login.fxml"));
            Parent root1 = (Parent) fmxloader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void onSalirButtonClick(ActionEvent event) throws Exception {
        try {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Salir");
            alerta.setHeaderText("¿Está seguro?");
            Optional<ButtonType> resultado = alerta.showAndWait();

            if (resultado.get() == ButtonType.OK){
                System.exit(0);
            } else {
                event.consume();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
