package ControllerPackage;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class RecipeController {

    private Button favorite_button;
    private ViewModel viewModel;

    @FXML
    private void onFavButtonClick() {
        viewModel.setCurrentView(ViewModel.View.A);
    }
    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel ;
    }


}
