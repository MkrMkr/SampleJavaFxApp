package myapplication.models;

/**
 * Created by Mirek on 2016-10-26.
 */
public class User {
    private int id;
    private boolean success = false;
    private boolean newUser = true;
    private int eventsCount = 0;
    private String userName;
    private String userPhotoUrl;
    private String phoneNumber = null;

    public User(int id, String userPhotoUrl, String userName) {
        this.id = id;
        this.userPhotoUrl = userPhotoUrl;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public boolean isSuccess() {
        return success;
    }

    public boolean isNewUser() {
        return newUser;
    }

    public int getEventsCount() {
        return eventsCount;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPhotoUrl() {
        return userPhotoUrl;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
