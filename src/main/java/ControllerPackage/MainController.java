package ControllerPackage;



import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Window;


public class MainController {

    @FXML
    private Label verification_label;
    @FXML
    private Button registration_button;
    @FXML
    private Button login_button;

    private ViewModel viewModel ;





    // Button Events:
    @FXML
    protected void onLogInButtonClick() {

        // Write Code for Verification using Variable "connector" from Main
            //1 Connect to connetor.<USERNAME/PASSWORD COLLECTION>
            //2 Verify that data input provided by the user matches a stored combination

        // If it does, save the Object ID & let them in:
        verification_label.setStyle("-fx-text-fill:Green");
        //Write Code here:


        // Else, display log-in message error:
        verification_label.setStyle("-fx-text-fill:Red");
        verification_label.setText("Incorrect username or password");
    }


    // Change Views:
    @FXML
    private void onRegisterButtonClick() {
        viewModel.setCurrentView(ViewModel.View.B);
    }
    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel ;
    }








}
