package ControllerPackage;

import ApplicationPackage.Main;
import ModelPackage.CreateAccount;
import ModelPackage.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import static ApplicationPackage.Main.window2;

public class RegisterController {
    FXMLLoader loader = new FXMLLoader();
    private AnchorPane anchorPane;

    @FXML
    private Button register_button;
    @FXML
    private Button back_button;
    @FXML
    private TextField first_name_box;
    @FXML
    private TextField last_name_box;
    @FXML
    private TextField username_box;
    @FXML
    private PasswordField password_box;
    @FXML
    private Label status_label;

    //Button Clicks:
    @FXML
    public void onBackButtonClick() throws IOException {
        switchToLogin();
    }
    public void onRegisterButtonClick() throws IOException {
        CreateAccount c = new CreateAccount();
        Boolean valid = c.newAccountVerification(username_box.getText(), password_box.getText(), first_name_box.getText(), last_name_box.getText());
        if(valid) switchToLogin();

        else {
            status_label.setStyle("-fx-text-fill:Red");
            status_label.setText(c.errorMessage);
        }

    }


    //View Switchers:
    public void switchToLogin() throws IOException {
        window2.setTitle("Welcome, please login");
        this.loader.setLocation(Main.class.getResource("Login.fxml"));
        this.anchorPane = (AnchorPane)this.loader.load();
        Scene scene2 = new Scene(this.anchorPane);
        window2.setScene(scene2);
        window2.show();

    }












}
