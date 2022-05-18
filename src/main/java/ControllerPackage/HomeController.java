package ControllerPackage;


import ApplicationPackage.Main;
import ModelPackage.Recipe;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ControllerPackage.LoginController;
import ControllerPackage.ProfileController;
import ControllerPackage.ProfileController;
import ModelPackage.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Optional;

import static ApplicationPackage.Main.window2;
import static ControllerPackage.LoginController.local_user;

public class HomeController {

    FXMLLoader loader = new FXMLLoader();

    private AnchorPane anchorPane;

    @FXML
    private TextField recipy_box;
    @FXML
    private Button lens_button;

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    static Recipe local_recipe;

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
    @FXML
    private void onLensRecipyClick(ActionEvent event) throws IOException {
        String input_recipeTitle = recipy_box.getText();
        //System.out.println("Input User: "+ input_user);
        logger.info("Input Recipe: "+ input_recipeTitle);

        // Save & verify recipy data:
        local_recipe = new Recipe(input_recipeTitle);



        // If it does, save the User & let them in:
        if(local_recipe.getValid()) {
            logger.info("Existing recipe in Database!");
            switchToRecipe();
        }

        // Else, display log-in message error:
        else {
            logger.error("No recipy with such title!");
        }
    }
    public void switchToRecipe() throws IOException {
        window2.setTitle("Welcome Recipe, "+local_user.getFirst_name());
        this.loader.setLocation(Main.class.getResource("Recipe.fxml"));
        this.anchorPane = this.loader.load();
        Scene scene2 = new Scene(this.anchorPane);
        window2.setScene(scene2);
        window2.show();
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

