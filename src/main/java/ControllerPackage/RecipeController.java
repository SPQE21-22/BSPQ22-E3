package ControllerPackage;

import ApplicationPackage.Main;
import ModelPackage.Recipe;
import ModelPackage.User;
import com.mongodb.BasicDBObject;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import java.awt.Desktop;
import java.net.URI;

import static ApplicationPackage.Main.connector;
import static ApplicationPackage.Main.window2;
import static ControllerPackage.HomeController.local_recipe;
import static ControllerPackage.LoginController.local_user;

public class RecipeController implements Initializable {

    FXMLLoader loader = new FXMLLoader();
    private AnchorPane anchorPane;


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
    private Button URL_Button;
    @FXML
    private Button Back_Button;
    @FXML
    private ToggleButton Likes_Button;
    @FXML
    private ImageView myImageView;
    Logger logger = LoggerFactory.getLogger(RecipeController.class);

    long LikesTracker =  local_recipe.getlikes_count();



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


        String id = local_recipe.getRecipe_id();
        String path = "https://raw.githubusercontent.com/SPQE21-22/BSPQ22-E3/0ec5c83c84f256cd37ff817e3d1718d7c2027eb6/src/main/resources/Images/"+id+".jpg";
        Image i = new Image(path);
        System.out.println(i.getHeight());
        myImageView.setImage(i);
    }
    /**
     * Button to go back to home
     */
    public void onBackButtonClick() throws IOException {
        switchToHome();
    }


    public void onURLButtonClick() throws IOException {
        Runtime rt = Runtime.getRuntime();
        String url = local_recipe.getSourceURL();
        String os = System.getProperty("os.name");

        if(os.contains("Windows")) {

            rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
        }
        else if (os.contains("Mac")){
            rt.exec("open " + url);
        }
        else{

            logger.info("Sorry, your Operating System: " + os +" is not supported at the moment for redirects.\n" +
                    "To read your recipe visit: "+url );
        }

    }

    /**
     * Likes or Dislikes Recipe
     */
    public void onLikesButtonClick() throws IOException {

        Bson filter = Filters.eq("Recipe_Id", local_recipe.getRecipe_id());
        Bson updates;
        String action;

        if (Likes_Button.isSelected()) {
            updates = Updates.set("Likes", LikesTracker++);
            action = "liked";
        }
        else {
            updates = Updates.set("Likes", LikesTracker--);
            action = "disliked";
        }
        likes_label.setText(String.valueOf(LikesTracker));
        connector.db.getCollection("Recipe").findOneAndUpdate(filter, updates);
        logger.info("Successfully "+action+" "+local_recipe.getTitle());
    }


    public void switchToHome() throws IOException {
        window2.setTitle("Welcome Home, "+local_user.getFirst_name());
        this.loader.setLocation(Main.class.getResource("Home.fxml"));
        this.anchorPane = this.loader.load();
        Scene scene2 = new Scene(this.anchorPane);
        window2.setScene(scene2);
        window2.show();

    }

}
