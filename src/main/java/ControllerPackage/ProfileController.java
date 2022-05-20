package ControllerPackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import ControllerPackage.LoginController;
import ModelPackage.User;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static ControllerPackage.LoginController.local_user;

public class ProfileController implements Initializable {
    /**
     * Labels of the register interface
     */
    @FXML
    Label name_label;
    @FXML
    Label surname_label;
    @FXML
    Label user_label;



    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        user_label.setText(local_user.getUsername());
        name_label.setText(local_user.getFirst_name());
        surname_label.setText(local_user.getLast_name());
    }



    FXMLLoader loader = new FXMLLoader();

    /**
     * Button events:
     */

    /**
     * Button for the user logout
     */
    public void onLogOutButtonClick(ActionEvent event) throws Exception {
        try {

            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Exit");
            alerta.setHeaderText("Are you sure?");
            Optional<ButtonType> resultado = alerta.showAndWait();

            if (resultado.get() == ButtonType.OK) {
                local_user.clear(local_user);
                System.exit(0);
            } else {
                event.consume();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Button to go to the favorites interface
     */
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
