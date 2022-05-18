package ControllerPackage;

import ModelPackage.Recipe;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;
import static ControllerPackage.HomeController.local_recipe;
public class RecipeController implements Initializable {

    FXMLLoader loader = new FXMLLoader();

    @FXML
    private Label name_label;
    @FXML
    private Label calories_label;
    @FXML
    private Label carbohydrates_label;
    @FXML
    private Label proteins_label;
    @FXML
    private Label fats_label;
    @FXML
    private Label readyInMinutes_label;
    @FXML
    private Label likes_label;





    public void initialize(URL url, ResourceBundle rb) {
        name_label.setText(local_recipe.getTitle());
        calories_label.setText(String.valueOf(local_recipe.getCalories()));
        carbohydrates_label.setText(String.valueOf(local_recipe.getCarbohydrates()));
        proteins_label.setText(String.valueOf(local_recipe.getProteins()));
        fats_label.setText(String.valueOf(local_recipe.getFats()));
        readyInMinutes_label.setText(String.valueOf(local_recipe.getReadyInMinutes()));
        likes_label.setText(String.valueOf(local_recipe.getlikes_count()));
    }

}
