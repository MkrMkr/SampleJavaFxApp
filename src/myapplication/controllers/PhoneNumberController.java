package myapplication.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.stage.Stage;
import myapplication.AllScenes;
import myapplication.StageFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PhoneNumberController extends BaseController implements Initializable {

    @FXML
    public Button continueButton;
    @FXML
    public AnchorPane anchorPane;

    @FXML
    public ImageView logoImageView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StageFactory stageFactory = StageFactory.INSTANCE;
        Stage currentStage = stageFactory.getCurrentStage();

        anchorPane.prefWidthProperty().bind(currentStage.widthProperty());
        anchorPane.prefHeightProperty().bind(currentStage.heightProperty());
        anchorPane.prefWidthProperty().bind(currentStage.widthProperty());
        anchorPane.prefHeightProperty().bind(currentStage.heightProperty());

        anchorPane.widthProperty().addListener((observable, oldValue, newValue) -> {
            double halfOfAnchorPaneWidth = (Double) newValue / 2;

            double logoWidth = logoImageView.getFitWidth();
            logoImageView.setX(halfOfAnchorPaneWidth-65);
        });

        anchorPane.heightProperty().addListener((observable, oldValue, newValue) -> {
            double anchorPaneHeight = (double) newValue;
            double logoHeight = logoImageView.getFitHeight();
            logoImageView.setY((anchorPaneHeight / 2) - logoHeight);

        });
    }

    public PhoneNumberController() {
        StageFactory factory = StageFactory.INSTANCE;
        Stage primaryStage = factory.getCurrentStage();
    }

    public void continueButtonClick() {
        try {
            goToAccessCodeScene();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void goToAccessCodeScene() throws IOException {
        switchSceneTo(AllScenes.AccessCodeScreen.getAccessCodeScene().getTitle(),
                AllScenes.AccessCodeScreen.getAccessCodeScene().getPath());
    }
}

