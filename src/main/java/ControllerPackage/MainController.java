package ControllerPackage;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class MainController {

    @FXML
    private Label instructionsText;

    @FXML
    protected void onLogInButtonClick() {
        instructionsText.setText("Log In is not set-up yet");
    }


    ConnectionString connectionString = new ConnectionString("mongodb+srv://group3:<group3>@cluster0.zr68o.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
    MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .serverApi(ServerApi.builder()
                    .version(ServerApiVersion.V1)
                    .build())
            .build();
    MongoClient mongoClient = MongoClients.create(settings);
    MongoDatabase database = mongoClient.getDatabase("test");




}
