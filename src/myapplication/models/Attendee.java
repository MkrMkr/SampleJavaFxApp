package myapplication.models;

/**
 * Created by Mirek on 2016-10-26.
 */
public class Attendee {
    private User user;
    private Boolean attendeeStatus;

    public Attendee(User user, Boolean attendeeStatus) {
        this.user = user;
        this.attendeeStatus = attendeeStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getAttendeeStatus() {
        return attendeeStatus;
    }

    public void setAttendeeStatus(Boolean attendeeStatus) {
        this.attendeeStatus = attendeeStatus;
    }
}
