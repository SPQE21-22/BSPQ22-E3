package ControllerPackage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.stage.Stage;
public class HomeController {
    public void onProfileButtonClick(ActionEvent event) throws Exception {
    try {
        FXMLLoader fmxloader = new FXMLLoader(getClass().getResource("/ApplicationPackage/Profile.fxml"));
        Parent root1 = (Parent) fmxloader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
