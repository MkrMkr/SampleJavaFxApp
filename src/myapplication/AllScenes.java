package myapplication;

/**
 * Created by Mirek on 2016-10-26.
 */
//TODO: replace with Enum ?
public class AllScenes {
    public static class PhoneNumberScreen {
        private static final AppScene phoneNumberScene = new AppScene("Phone number", "views/phone_number_screen.fxml");

        public static AppScene getPhoneNumberScene() {
            return phoneNumberScene;
        }
    }

    public static class AccessCodeScreen {
        private static final AppScene accessCodeScene = new AppScene("Access Code", "../views/access_code_screen.fxml");

        public static AppScene getAccessCodeScene() {
            return accessCodeScene;
        }
    }

    public static class ProfileScreen {
        private static final AppScene profileScene = new AppScene("Profile", "../views/profile_screen.fxml");

        public static AppScene getProfileScene() {
            return profileScene;
        }
    }

    public static class EventsScreen {
        private static final AppScene eventsScene = new AppScene("Events", "../views/events_screen.fxml");

        public static AppScene getEventsScene() {
            return eventsScene;
        }
    }

    public static class EventActionsScreen{
        private static final AppScene eventActionsScene = new AppScene("Event Actions","views/");
    }
}
