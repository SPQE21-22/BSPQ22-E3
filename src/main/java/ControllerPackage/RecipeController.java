package ControllerPackage;

import ApplicationPackage.Main;
import ModelPackage.Recipe;
import ModelPackage.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

import static ControllerPackage.LoginController.local_user;

public class RecipeController {

    FXMLLoader loader = new FXMLLoader();

    @FXML
    Label name_label;
    @FXML
    Label calories_label;
    @FXML
    Label carbohydrates_label;
    @FXML
    Label proteins_label;
    @FXML
    Label fats_label;
    @FXML
    Label readyInMinutes_label;
    @FXML
    Label likes_label;

    static Recipe local_recipe;
    //loader.setLocation(Main.class.getResource("Recipe.fxml"));


    public void initialize(URL url, ResourceBundle rb) {
        name_label.setText(local_recipe.getTitle());
        calories_label.setText(String.valueOf(local_recipe.getCalories()));
        carbohydrates_label.setText(String.valueOf(local_recipe.getCarbohydrates()));
        proteins_label.setText(String.valueOf(local_recipe.getProteins()));
        fats_label.setText(String.valueOf(local_recipe.getFats()));
        readyInMinutes_label.setText(String.valueOf(local_recipe.getReadyInMinutes()));
        likes_label.setText(String.valueOf(local_recipe.getLikes()));
    }

}
