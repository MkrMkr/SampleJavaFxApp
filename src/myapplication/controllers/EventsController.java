package myapplication.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
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
    private ListView eventsList;
    private List<Event> events = new ArrayList<Event>();
    ObservableList observableList = FXCollections.observableArrayList();

    public EventsController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/events_screen.fxml"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Event sampleEvent = new Event.Builder()
                .setCreator(new User(14, "https://unsplash.it/300/300?image=50", "EventUserName"))
                .setImageUrl("ImageUe2")
                .setName("ExtraEvent1")
                .setAddress("South Africa")
                .setGooglePlaceId("GooglePlaceId")
                .setEventTime(new Date(498654))
                .setEventStatus(new EventStatus(true, true, null))
                .setAttendees(Arrays.asList(
                        new Attendee(new User(3168214, "https://unsplash.it/300/300?image=65", "Franek F."), true)))
                .build();

        events.add(sampleEvent);
        observableList.setAll(events);
        eventsList.setItems(observableList);
    }
}
