import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Created by Mirek on 2016-10-26.
 */
public enum StageFactory {
    INSTANCE;

    private final ObservableList<Stage> openStages = FXCollections.observableArrayList();

    private final ObjectProperty<Stage> currentStage = new SimpleObjectProperty<>(null);

    private final ObjectProperty<Stage> previousStage = new SimpleObjectProperty<>(null);

    public final ObjectProperty<Stage> previousStageProperty() {
        return this.previousStage;
    }

    public void setPreviousStage(final javafx.stage.Stage previousStage) {
        this.previousStageProperty().set(previousStage);
    }

    public Stage getPreviousStage() {
        return previousStageProperty().get();
    }

    public final ObjectProperty<Stage> currentStageProperty() {
        return this.currentStage;
    }

    public final void setCurrentStage(final javafx.stage.Stage currentStage) {
        this.currentStageProperty().set(currentStage);
    }

    public final javafx.stage.Stage getCurrentStage() {
        return this.currentStageProperty().get();
    }


    public ObservableList<Stage> getOpenStages() {
        return openStages;
    }

    public void registerStage(Stage stage) {
        stage.addEventHandler(WindowEvent.WINDOW_SHOWN,
                event -> openStages.add(stage));
        stage.addEventHandler(WindowEvent.WINDOW_HIDDEN, event -> openStages.remove(stage));
        stage.focusedProperty().addListener((observable, wasFocused, isNowFocused) -> {
            if (isNowFocused) {
                currentStage.set(stage);
            } else {
                currentStage.set(null);
            }
        });
    }

    public Stage createStage() {
        previousStage.set(currentStage.get());
        Stage stage = new Stage();
        registerStage(stage);
        return stage;
    }

}
