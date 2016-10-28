package myapplication.controllers.dialogs;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import myapplication.controllers.BaseController;

import java.io.IOException;

/**
 * Created by Mirek on 2016-10-27.
 */
public class EventsActionDialogController extends BaseController {

    private int result;

    public EventsActionDialogController() {
    }

    public int create() {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Event Actions");
        Pane pane;
        try {
            pane = FXMLLoader.load(getClass().getResource("../../views/dialogsviews/event_actions_screen.fxml"));
            Button cheersAgainButton = (Button) pane.lookup("#cheersAgain");
            Button deleteEventButton = (Button) pane.lookup("#deleteEvent");
            cheersAgainButton.setOnAction(event -> {
                result = DialogResults.CHEERS_AGAIN;
                stage.close();
            });

            deleteEventButton.setOnAction(event -> {
                result = DialogResults.DELETE_EVENT;
                stage.close();
            });

            Scene scene = new Scene((Pane) pane);
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public class DialogResults {
        public static final int CHEERS_AGAIN = 1;
        public static final int DELETE_EVENT = 2;
    }

}
