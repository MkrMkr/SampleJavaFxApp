import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by Mirek on 2016-10-26.
 */
public class ProfileController extends BaseController implements Initializable {

    public static final int BOTTOM_PROFILE_ICON_OFFSET = 175;
    public static final int PROFILE_ICON_CLIP_CIRCLE_RADIUS = 40;
    @FXML
    public Rectangle toolbar;
    @FXML
    public ImageView profileBackground;
    @FXML
    public AnchorPane anchorPane;
    @FXML
    private ImageView profileIcon;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StageFactory stageFactory = StageFactory.INSTANCE;
        Stage currentStage = stageFactory.getCurrentStage();

        toolbar.widthProperty().bind(currentStage.widthProperty());
        profileBackground.fitWidthProperty().bind(currentStage.widthProperty());

        Circle clipCircle = new Circle(PROFILE_ICON_CLIP_CIRCLE_RADIUS);

        anchorPane.widthProperty().addListener((observable, oldValue, newValue) -> {
            double halfOfAnchorPaneWidth = (Double) newValue / 2;
            double profileIconWidth = profileIcon.getFitWidth();
            double profileIconHeight = profileIcon.getFitHeight();

            profileIcon.setX(halfOfAnchorPaneWidth - (profileIconWidth / 2));
            profileIcon.setY(BOTTOM_PROFILE_ICON_OFFSET);

            final double clicpCircleExtraXOffset = 5;
            clipCircle.setCenterX(profileIcon.getX() + (profileIconWidth / 2) - clicpCircleExtraXOffset);
            clipCircle.setCenterY(profileIcon.getY() + (profileIconHeight / 2));
            profileIcon.setClip(clipCircle);
            System.out.println("new Val" + newValue);
        });
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
