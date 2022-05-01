package ControllerPackage;



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

import java.io.IOException;

import static ApplicationPackage.Main.window2;


public class LoginController {
    FXMLLoader loader = new FXMLLoader();
    private AnchorPane anchorPane;

    @FXML
    private Label verification_label;
    @FXML
    private Button registration_button;
    @FXML
    private Button login_button;
    @FXML
    private TextField username_box;
    @FXML
    private PasswordField password_box;

    static User local_user;






    // Button Events:

    protected void userVerification() {

        // Write Code for Verification using Variable "connector" from Main
            //1 Connect to connetor.<USERNAME/PASSWORD COLLECTION>
            //2 Verify that data input provided by the user matches a stored combination


    }

    @FXML
    private void onLoginButtonClick() throws IOException {

        String input_user = username_box.getText();
        String input_password = password_box.getText();

        System.out.println("Input User: "+ input_user);
        System.out.println("Input Password: "+ input_password);

        // Save & verify user credentials:
        local_user = new User(input_user,input_password);

        // If it does, save the User & let them in:
        if(local_user.getValid()) {
            verification_label.setStyle("-fx-text-fill:Green");
            verification_label.setText("Access Granted!");
            switchToHome();
        }

        // Else, display log-in message error:
        else {
            verification_label.setStyle("-fx-text-fill:Red");
            verification_label.setText("Incorrect username or password");
        }
    }

    @FXML
    private void onRegisterButtonClick() throws IOException {
        switchToRegister();
    }

    // Change Views:
    public void switchToHome() throws IOException {
        window2.setTitle("Welcome Home, "+local_user.getFirst_name());
        this.loader.setLocation(Main.class.getResource("Home.fxml"));
        this.anchorPane = (AnchorPane)this.loader.load();
        Scene scene2 = new Scene(this.anchorPane);
        window2.setScene(scene2);
        window2.show();
    }

    public void switchToRegister() throws IOException {
        window2.setTitle("Create an Account");
        this.loader.setLocation(Main.class.getResource("Register.fxml"));
        this.anchorPane = (AnchorPane)this.loader.load();
        Scene scene2 = new Scene(this.anchorPane);
        window2.setScene(scene2);
        window2.show();
    }








}
