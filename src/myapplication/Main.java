package myapplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        StageFactory factory = StageFactory.INSTANCE;
        factory.registerStage(primaryStage);

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
