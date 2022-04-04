package ApplicationPackage;

import ControllerPackage.RegisterController;
import ControllerPackage.MainController;
import ControllerPackage.ViewModel;
import MongoConnector.MyConnector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

import javafx.beans.binding.Bindings;
import javafx.scene.Parent;


public class Main extends Application {
    @SuppressWarnings("ClassEscapesDefinedScope")
    public static MyConnector connector;
    @Override
    public void start(Stage stage) throws IOException {
        ViewModel viewModel = new ViewModel();

        // Login View = a
        FXMLLoader aLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent a = aLoader.load();
        MainController aController = aLoader.getController();
        aController.setViewModel(viewModel);

        //Register View = b
        FXMLLoader bLoader = new FXMLLoader(getClass().getResource("Register.fxml"));
        Parent b = bLoader.load();
        RegisterController bController = bLoader.getController();
        bController.setViewModel(viewModel);

        // ...................

        Scene scene = new Scene(a, 500, 400);

        scene.rootProperty().bind(Bindings.createObjectBinding(() -> {
            if (viewModel.getCurrentView() == ViewModel.View.A) {
                stage.setTitle("Welcome to Deusto Foods!");
                return a ;
            } else if (viewModel.getCurrentView() == ViewModel.View.B) {
                stage.setTitle("Create an Account 🔐");
                return b ;
            } else {
                return null ;
            }
        }, viewModel.currentViewProperty()));

        //System.out.println(viewModel.getCurrentView().toString());
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }




    public static void main(String[] args) {
        connector =  new MyConnector();
        launch();
    }
}