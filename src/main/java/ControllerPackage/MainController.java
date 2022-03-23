package ControllerPackage;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class MainController {

    @FXML
    private Label instructionsText;

    @FXML
    protected void onLogInButtonClick() {
        instructionsText.setText("Log In is not set-up yet");
    }






}
