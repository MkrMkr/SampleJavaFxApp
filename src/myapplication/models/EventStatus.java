package myapplication.models;

/**
 * Created by Mirek on 2016-10-26.
 */
public class EventStatus {
    private boolean deletable;
    private boolean editable;
    private Boolean eventAttendeeStatus;

    public EventStatus(boolean deletable, boolean editable, Boolean attendeeStatus) {
        this.deletable = deletable;
        this.editable = editable;
        this.eventAttendeeStatus = attendeeStatus;
    }

    public boolean isDeletable() {
        return deletable;
    }

    public void setDeletable(boolean deletable) {
        this.deletable = deletable;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public Boolean getEventAttendeeStatus() {
        return eventAttendeeStatus;
    }

    public void setEventAttendeeStatus(Boolean eventAttendeeStatus) {
        this.eventAttendeeStatus = eventAttendeeStatus;
    }
}
