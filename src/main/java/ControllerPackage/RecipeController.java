package ControllerPackage;

import ApplicationPackage.Main;
import ModelPackage.Recipe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static ApplicationPackage.Main.window2;
import static ControllerPackage.HomeController.local_recipe;
import static ControllerPackage.LoginController.local_user;

public class RecipeController implements Initializable {

    FXMLLoader loader = new FXMLLoader();
    private AnchorPane anchorPane;
    private Button fav_button;
    int countLikes = 0;
    Label Like_label;

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
    @FXML
    private ImageView image_id;



    /**
     * Gets the value of the likes counter
     */

    public void initialize(URL url, ResourceBundle rb) {
        name_label.setText(local_recipe.getTitle());
        calories_label.setText(String.valueOf(local_recipe.getCalories()));
        carbohydrates_label.setText(String.valueOf(local_recipe.getCarbohydrates()));
        proteins_label.setText(String.valueOf(local_recipe.getProteins()));
        fats_label.setText(String.valueOf(local_recipe.getFats()));
        readyInMinutes_label.setText(String.valueOf(local_recipe.getReadyInMinutes()));
        likes_label.setText(String.valueOf(local_recipe.getlikes_count()));
        Like_label.setText(String.valueOf(countLikes));
        // File file = new File(local_recipe.getImage());
       /* Image image = new Image(local_recipe.getImage());
        System.out.println(image);
        image_id.setImage(image);*/
    }
    /**
     * Button to go back to home
     */
    public void onBackButtonClick() throws IOException {
        switchToHome();
    }

    public void switchToHome() throws IOException {
        window2.setTitle("Welcome Home, "+local_user.getFirst_name());
        this.loader.setLocation(Main.class.getResource("Home.fxml"));
        this.anchorPane = (AnchorPane)this.loader.load();
        Scene scene2 = new Scene(this.anchorPane);
        window2.setScene(scene2);
        window2.show();

    }

    /**
     method with the like counter
     */
    public void onFavButtonClick(ActionEvent event) throws Exception {
        countLikes +=1;
        Like_label.setText(String.valueOf(countLikes));

    }


}
