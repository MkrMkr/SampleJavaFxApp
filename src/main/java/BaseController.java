import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Mirek on 2016-10-26.
 */
public class BaseController {

    protected void switchSceneTo(String sceneStageTitle, Scene scene) {
        StageFactory stageFactory = StageFactory.INSTANCE;
        stageFactory.getCurrentStage().setTitle(sceneStageTitle);
        stageFactory.getCurrentStage().setScene(scene);
    }

    protected void switchSceneTo(String sceneStageTitle, String scenePath) throws IOException {
        StageFactory stageFactory = StageFactory.INSTANCE;
        stageFactory.getCurrentStage().setTitle(sceneStageTitle);

        Region root = null;
        root = FXMLLoader.load(getClass().getResource(scenePath));
        Scene scene = new Scene(root);
        stageFactory.getCurrentStage().setScene(scene);
    }

    protected void switchStageToKeepingStageSize(final String newStageTitle, final String newStageScenePath) throws IOException {
        StageFactory stageFactory = StageFactory.INSTANCE;
        Stage newStage = stageFactory.createStage();
        newStage.setTitle(newStageTitle);

        Stage previousStage = stageFactory.getPreviousStage();
        double oldHeight = previousStage.getHeight();
        double oldWidth = previousStage.getWidth();
        double oldMinWidth = previousStage.getMinWidth();
        double oldMinHeight = previousStage.getMinHeight();

        newStage.setWidth(oldWidth);
        newStage.setHeight(oldHeight);
        newStage.setMinWidth(oldMinWidth);
        newStage.setMinHeight(oldMinHeight);

        previousStage.close();
        newStage.show();

        FXMLLoader loader = new FXMLLoader(getClass().getResource(newStageScenePath));
        Parent root = loader.load();
        Scene newStageScene = new Scene(root);
        newStage.setScene(newStageScene);
    }

    protected void openNewStage(final String newStageTitle, final String newStageScenePath) throws IOException {
        StageFactory stageFactory = StageFactory.INSTANCE;
        Stage profileStage = stageFactory.createStage();
        profileStage.setTitle(newStageTitle);

        FXMLLoader loader = new FXMLLoader(getClass().getResource(newStageScenePath));
        Parent root = loader.load();
        Scene profileScene = new Scene(root);

        profileStage.setScene(profileScene);
        profileStage.show();
    }

}
