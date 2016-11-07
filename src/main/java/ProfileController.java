import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by Mirek on 2016-10-26.
 */
public class ProfileController extends BaseController implements Initializable {
    @FXML
    private ImageView profileIcon;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Circle clipCircle = new Circle(40);
        clipCircle.setTranslateX(profileIcon.getFitWidth() / 2 - 4);
        clipCircle.setTranslateY(profileIcon.getFitHeight() / 2);
        profileIcon.setClip(clipCircle);
    }

    public void useMyFacebookDetails(ActionEvent actionEvent) {

    }

    public void continueButtonClick(ActionEvent actionEvent) {
        try {
            switchSceneTo(AllScenes.EventsScreen.getEventsScene().getTitle(),
                    AllScenes.EventsScreen.getEventsScene().getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
