package myapplication.controllers.lists;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import myapplication.StageFactory;
import myapplication.models.Event;

import java.io.IOException;

/**
 * Created by Mirek on 2016-10-27.
 */
public class EventsListDataBinder {

    private Event event;
    private Node root;

    @FXML
    private Pane eventListItem;

    @FXML
    private Label eventName;

    public EventsListDataBinder() {
        //TODO: move listCellItem.fxml to AllScenes
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../views/listviews/eventsListItem.fxml"));
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setEvent(Event event) {
        eventName.setText(event.getName());
        this.event = event;
    }

    public Node getRoot() {
        return eventListItem;
    }

    public void settingsIconClicked(MouseEvent mouseEvent) {


        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Event actions");
        window.setMinWidth(250);
        Label label = new Label();
        label.setText("jmj");

    }
}
