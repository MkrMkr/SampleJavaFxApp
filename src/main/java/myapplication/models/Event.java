package myapplication.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Mirek on 2016-10-26.
 */

public final class Event {
    private int id = -1;
    private User creator;
    private String imageUrl;
    private String name;
    private String address;
    private String googlePlaceId;
    private Date eventTime;
    private EventStatus eventStatus;
    private List<Attendee> attendees;
    private boolean isNew = false;

    private Event(Builder builder) {
        this.creator = builder.creator;
        this.imageUrl = builder.imageUrl;
        this.name = builder.name;
        this.address = builder.address;
        this.googlePlaceId = builder.googlePlaceId;
        this.eventTime = builder.eventTime;
        this.eventStatus = builder.eventStatus;
        if (builder.attendees != null) {
            this.attendees = builder.attendees;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User user) {
        this.creator = user;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String url) {
        this.imageUrl = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String addressOfPlace) {
        this.address = addressOfPlace;
    }

    public String getGooglePlaceId() {
        return googlePlaceId;
    }

    public void setGooglePlaceId(String googleId) {
        this.googlePlaceId = googleId;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date time) {
        this.eventTime = time;
    }

    public EventStatus getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(EventStatus status) {
        this.eventStatus = status;
    }

    public List<Attendee> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Attendee> participants) {
        this.attendees = participants;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public static class Builder implements Serializable {
        private User creator;
        private String imageUrl;
        private String name;
        private String address;
        private String googlePlaceId;
        private Date eventTime;
        private EventStatus eventStatus;
        private List<User> unknownUsersSelections;
        private List<Attendee> attendees;
        private List<User> selectedFromUnknownList;
        private List<User> selectedFromNormalList;

        public String getAddress() {
            return address;
        }

        public Builder setAddress(String addressOfPlace) {
            this.address = addressOfPlace;
            return this;
        }

        public String getGooglePlaceId() {
            return googlePlaceId;
        }

        public Builder setGooglePlaceId(String googleId) {
            this.googlePlaceId = googleId;
            return this;
        }

        public String getName() {
            return name;
        }

        public Builder setName(String userName) {
            this.name = userName;
            return this;
        }

        public Date getEventTime() {
            return eventTime;
        }

        public Builder setEventTime(Date time) {
            this.eventTime = time;
            return this;
        }

        public Builder setCreator(User user) {
            this.creator = user;
            return this;
        }

        public Builder setImageUrl(String url) {
            this.imageUrl = url;
            return this;
        }

        public Builder setEventStatus(EventStatus status) {
            this.eventStatus = status;
            return this;
        }

        public Builder setAttendees(List<Attendee> knownAndUnknownParticipants) {
            this.attendees = knownAndUnknownParticipants;
            return this;
        }

        public boolean arePreviouslySelectedUsers() {
            return selectedFromUnknownList != null || selectedFromNormalList != null;
        }

        public List<User> getSelectedFromUnknownList() {
            return selectedFromUnknownList;
        }

        public void setSelectedFromUnknownList(List<User> selectedFromUnknownList) {
            this.selectedFromUnknownList = selectedFromUnknownList;
        }

        public List<User> getSelectedFromNormalList() {
            return selectedFromNormalList;
        }

        public void setSelectedFromNormalList(List<User> selectedFromNormalList) {
            this.selectedFromNormalList = selectedFromNormalList;
        }


        public Event build() {
            return new Event(this);
        }

    }
}
