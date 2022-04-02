package ControllerPackage;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class RegisterController {

    @FXML
    private Button registration_button;
    private ViewModel viewModel;







    // Change Views:
    @FXML
    private void onRegisterButtonClick() {
        viewModel.setCurrentView(ViewModel.View.A);
    }
    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel ;
    }


}
