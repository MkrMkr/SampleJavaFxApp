import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by Mirek on 2016-10-26.
 */
public class ProfileController extends BaseController implements Initializable {

    public static final int PROFILE_ICON_CLIP_CIRCLE_RADIUS = 40;
    @FXML
    public Rectangle toolbar;
    @FXML
    public ImageView profileBackground;
    @FXML
    public AnchorPane anchorPane;
    @FXML
    public Text addPhotoTitle;
    @FXML
    public TextField enterYourNameField;
    @FXML
    public CheckBox receiveNotificationsCheckbox;
    @FXML
    public Button continueButton;
    @FXML
    public Button facebookButton;
    @FXML
    private ImageView profileIcon;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StageFactory stageFactory = StageFactory.INSTANCE;
        Stage currentStage = stageFactory.getCurrentStage();

        toolbar.widthProperty().bind(currentStage.widthProperty());
        profileBackground.fitWidthProperty().bind(currentStage.widthProperty());

        Circle circle = new Circle(45);
        circle.setCenterX(46);
        circle.setCenterY(45);
        profileIcon.setClip(circle);

        double addPhotoTitleOffset = 10;
        double halfOfProfileIconWidth = profileIcon.getFitWidth() / 2;
        double halfOfProfileIconHeight = profileIcon.getFitHeight() / 2;

        profileIcon.layoutXProperty().bind(anchorPane.widthProperty()
                .divide(2)
                .subtract(halfOfProfileIconWidth));
        profileIcon.layoutYProperty().bind(anchorPane.heightProperty()
                .divide(12)
                .multiply(3)
                .subtract(halfOfProfileIconHeight));

        addPhotoTitle.layoutXProperty().bind(anchorPane.widthProperty()
                .divide(2)
                .subtract(halfOfProfileIconWidth)
                .add(addPhotoTitleOffset));
        final double marginToAddPhoto = 15;
        addPhotoTitle.layoutYProperty().bind(anchorPane.heightProperty()
                .divide(12)
                .multiply(3)
                .add(halfOfProfileIconHeight + marginToAddPhoto));

        toolbar.heightProperty().bind(anchorPane.heightProperty().divide(12));

        profileBackground.fitHeightProperty().bind(anchorPane.heightProperty().divide(6));
        profileBackground.layoutYProperty().bind(anchorPane.heightProperty().divide(12));

        //TODO: resize circle and photo

        enterYourNameField.translateYProperty().bind(anchorPane.heightProperty().divide(18).multiply(8));

        receiveNotificationsCheckbox.translateYProperty().bind(anchorPane.heightProperty().divide(18).multiply(13));

        facebookButton.prefHeightProperty().bind(anchorPane.heightProperty().divide(18));
        facebookButton.translateYProperty().bind(anchorPane.heightProperty().divide(18).multiply(15));

        continueButton.prefHeightProperty().bind(anchorPane.heightProperty().divide(18));
        continueButton.translateYProperty().bind(anchorPane.heightProperty().divide(18).multiply(16.5));

        System.out.println("java version: " + System.getProperty("java.version"));
        System.out.println("javafx.version: " + System.getProperty("javafx.version"));
        Pane pane = new Pane();
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
