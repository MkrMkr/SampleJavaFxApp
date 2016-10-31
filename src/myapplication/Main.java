package myapplication;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import myapplication.controllers.BaseController;
import myapplication.controllers.PhoneNumberController;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        StageFactory factory = StageFactory.INSTANCE;
        factory.setCurrentStage(primaryStage);

        FXMLLoader loader = new FXMLLoader(getClass().getResource(AllScenes
                .PhoneNumberScreen
                .getPhoneNumberScene()
                .getPath()));
        Parent root = loader.load();

        primaryStage.setTitle(AllScenes.PhoneNumberScreen.getPhoneNumberScene().getTitle());
        Scene phoneNumberScene = new Scene(root);

        primaryStage.setScene(phoneNumberScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
