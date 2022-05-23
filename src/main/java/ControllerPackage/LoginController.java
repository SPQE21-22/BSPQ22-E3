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
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

import static ApplicationPackage.Main.window2;


public class LoginController {
    FXMLLoader loader = new FXMLLoader();
    private AnchorPane anchorPane;
    /**
     * Button, textfield/passwordfield and labels of the register interface
     */
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

    Logger logger = LoggerFactory.getLogger(LoginController.class);


    /**
     * Button Events:
     */


    /**
     * Button for the user login
     */

    @FXML
    private void onLoginButtonClick() throws IOException {

        String input_user = username_box.getText();
        String input_password = password_box.getText();

//        URL url = getClass().getResource("C:\\Users\\herre\\IdeaProjects\\BSPQ22-E3\\src\\main\\resources\\Images\\001.jpg");
//        System.out.println(url);
//        Image i = new Image("src/main/resources/Images/001.jpg");
//
//        System.out.println(i.getHeight());

        logger.info("Input User: "+ input_user);
        StringBuilder p = new StringBuilder();
        p.append("*".repeat(input_password.length()));
        logger.info("Input Password: "+ p);

        /**
         *  Save & verify user credentials
         */

        local_user = new User(input_user,input_password);

        /**
         * If it does, save the User & let them in:
         */

        if(local_user.getValid()) {
            verification_label.setStyle("-fx-text-fill:Green");
            verification_label.setText("Access Granted!");
            switchToHome();
        }

        /**
         * Else, display log-in message error:
         */

        else {
            verification_label.setStyle("-fx-text-fill:Red");
            verification_label.setText("Incorrect username or password");
        }
    }

    /**
     * Button for the user registration
     */
    @FXML
    private void onRegisterButtonClick() throws IOException {
        switchToRegister();
    }

    /**
     * Change Views:
     */
    /**
     * Home view switching
     */
    public void switchToHome() throws IOException {
        window2.setTitle("Welcome Home, "+local_user.getFirst_name());
        this.loader.setLocation(Main.class.getResource("Home.fxml"));
        this.anchorPane = this.loader.load();
        Scene scene2 = new Scene(this.anchorPane);
        window2.setScene(scene2);
        window2.show();
    }

    /**
     * Register view switching
     */
    public void switchToRegister() throws IOException {
        window2.setTitle("Create an Account");
        this.loader.setLocation(Main.class.getResource("Register.fxml"));
        this.anchorPane = this.loader.load();
        Scene scene2 = new Scene(this.anchorPane);
        window2.setScene(scene2);
        window2.show();
    }
}