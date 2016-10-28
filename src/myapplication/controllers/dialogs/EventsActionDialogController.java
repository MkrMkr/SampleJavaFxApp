package myapplication.controllers.dialogs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
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
                result = 1;
                stage.close();
            });

            deleteEventButton.setOnAction(event -> {
                result = 2;
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

}
