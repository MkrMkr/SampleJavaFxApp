package myapplication;

import javafx.scene.control.ListCell;
import myapplication.controllers.lists.EventsListDataBinder;
import myapplication.models.Event;

/**
 * Created by Mirek on 2016-10-27.
 */
public class ListViewCell extends ListCell<Event> {

    @Override
    protected void updateItem(Event event, boolean empty) {
        super.updateItem(event, empty);

        if(event!=null){
            EventsListDataBinder eventsListDataBinder = new EventsListDataBinder();
            eventsListDataBinder.setEvent(event);
            setGraphic(eventsListDataBinder.getRoot());
        }
    }
}
