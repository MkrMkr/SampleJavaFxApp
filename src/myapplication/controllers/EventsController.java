package myapplication.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import myapplication.ListViewCell;
import myapplication.models.Attendee;
import myapplication.models.Event;
import myapplication.models.EventStatus;
import myapplication.models.User;

import java.net.URL;
import java.util.*;

/**
 * Created by Mirek on 2016-10-26.
 */
public class EventsController implements Initializable {

    @FXML
    private ListView eventsListView;
    private List<Event> events = new ArrayList<Event>();
    ObservableList observableList = FXCollections.observableArrayList();
    private List<String> strings = new ArrayList<String>();

    public EventsController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Event sampleEvent = new Event.Builder()
                .setCreator(new User(14, "https://unsplash.it/300/300?image=50", "FirstUser"))
                .setImageUrl("ImageUe2")
                .setName("ExtraEvent1")
                .setAddress("South Africa")
                .setGooglePlaceId("GooglePlaceId")
                .setEventTime(new Date(498654))
                .setEventStatus(new EventStatus(true, true, null))
                .setAttendees(Arrays.asList(
                        new Attendee(new User(3168214, "https://unsplash.it/300/300?image=65", "Franek F."), true)))
                .build();

        Event sampleEvent2 = new Event.Builder()
                .setCreator(new User(17, "https://unsplash.it/300/300?image=50", "SecondUser"))
                .setImageUrl("ImageUrlReceivedOneToOne")
                .setName("ReceivedOneToOneEventName")
                .setAddress("ReceivedOneToOneEventAddress")
                .setGooglePlaceId("GooglePlaceId")
                .setEventTime(new Date(894655))
                .setEventStatus(new EventStatus(true, true, false))
                .build();

        events.add(sampleEvent);
        events.add(sampleEvent2);
        observableList.setAll(events);
        eventsListView.setItems(observableList);
        eventsListView.setCellFactory(new Callback<ListView, ListCell>() {
            @Override
            public ListCell call(ListView param) {
                return new ListViewCell();
            }
        });

    }

}
