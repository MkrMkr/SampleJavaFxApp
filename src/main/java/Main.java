import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        StageFactory factory = StageFactory.INSTANCE;
        factory.setCurrentStage(primaryStage);
        primaryStage.setTitle(AllScenes.PhoneNumberScreen.getPhoneNumberScene().getTitle());
        primaryStage.setWidth(400);
        primaryStage.setHeight(700);

        FXMLLoader loader = new FXMLLoader(getClass().getResource(AllScenes
                .PhoneNumberScreen
                .getPhoneNumberScene()
                .getPath()));
        Parent root = loader.load();

        Scene phoneNumberScene = new Scene(root);

        primaryStage.setScene(phoneNumberScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
