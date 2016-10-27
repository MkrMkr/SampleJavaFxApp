package myapplication;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("views/listviews/eventsListItem.fxml"));
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
}
