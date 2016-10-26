package myapplication.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import myapplication.AllScenes;
import myapplication.StageFactory;

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

        ScrollPane root = null;
        root = FXMLLoader.load(getClass().getResource(scenePath));
        Scene scene = new Scene(root);
        stageFactory.getCurrentStage().setScene(scene);
    }

    protected void switchStageTo(final String newStageTitle, final String newStageScenePath) throws IOException {
        StageFactory stageFactory = StageFactory.INSTANCE;
        Stage profileStage = stageFactory.createStage();
        profileStage.setTitle(newStageTitle);

        FXMLLoader loader = new FXMLLoader(getClass().getResource(newStageScenePath));
        Parent root = loader.load();
        Scene profileScene = new Scene(root);

        profileStage.setScene(profileScene);

        stageFactory.getPreviousStage().close();

        profileStage.show();
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
