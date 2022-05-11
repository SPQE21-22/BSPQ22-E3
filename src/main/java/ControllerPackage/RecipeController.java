package ControllerPackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class RecipeController implements Initializable{
    private Button fav_button;
    int countLikes = 0;

    @FXML
    Label Like_label;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Like_label.setText(String.valueOf(countLikes));

    }

    public void onFavButtonClick(ActionEvent event) throws Exception {
    countLikes +=1;
    //Falta método para añadir una receta a un array de recetas
        }
}
