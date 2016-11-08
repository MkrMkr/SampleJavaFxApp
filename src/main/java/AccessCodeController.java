import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Mirek on 2016-10-25.
 */
public class AccessCodeController extends BaseController implements Initializable {

    @FXML
    public Button enterCheersButton;
    @FXML
    public ImageView logoImageView;
    @FXML
    public AnchorPane anchorPane;
    private Scene scene;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StageFactory factory = StageFactory.INSTANCE;
        Stage currentStage = factory.getCurrentStage();

        anchorPane.prefWidthProperty().bind(currentStage.widthProperty());
        anchorPane.prefHeightProperty().bind(currentStage.heightProperty());

        anchorPane.widthProperty().addListener((observable, oldValue, newValue) -> {
            double halfOfAnchorPaneWidth = (Double) newValue / 2;

            double logoWidth = logoImageView.getFitWidth();
            logoImageView.setX(halfOfAnchorPaneWidth - 65);
        });

        anchorPane.heightProperty().addListener((observable, oldValue, newValue) -> {
            double anchorPaneHeight = (double) newValue;
            double logoHeight = logoImageView.getFitHeight();
            logoImageView.setY((anchorPaneHeight / 2) - logoHeight);
        });
    }

    @FXML
    public void enterCheers() {
        try {
            goToProfileStage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToProfileStage() throws IOException {
        switchStageTo(AllScenes.ProfileScreen.getProfileScene().getTitle(),
                AllScenes.ProfileScreen.getProfileScene().getPath());
    }
}
