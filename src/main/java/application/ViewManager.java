package application;

import application.view.GameView;
import application.view.LevelSelectorView;
import application.view.MainMenuView;
import application.view.View;
import javafx.application.Platform;
import javafx.scene.layout.StackPane;
import logic.GameLevel;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewManager { // Switching views instead of switching scenes to allow for custom transitions.
    private static final String[] CSS_FILES= {"base.css", "cards.css", "tiles.css", "ui.css"};
    private static ViewManager instance;
    public final Stage stage;
    public final Scene scene;
    public final StackPane sceneRoot;
    private View currentView;


    public static ViewManager getInstance() {
        return instance;
    }

    public Stage getStage() {
        return stage;
    }

    public static void init(Stage stage) {
        instance = new ViewManager(stage);
    }

    private ViewManager(Stage stage) {
        this.stage = stage;
        stage.setTitle("Cardflow");
        this.sceneRoot = new StackPane();
        this.scene = new Scene(sceneRoot);

        for (String cssFile : CSS_FILES) {
            scene.getStylesheets().add(getClass().getResource("/css/"+cssFile).toExternalForm());
        }

        stage.setScene(scene);
        Platform.runLater(() -> scene.getRoot().requestFocus());
    }

    public void switchView(View newViewPane) {
        // Switches view without transitions or anything
        if (getCurrentView() != null)
            sceneRoot.getChildren().remove(currentView.getRoot());

        setCurrentView(newViewPane);
        sceneRoot.getChildren().add(newViewPane.getRoot());
    }

    public View getCurrentView() {
        return currentView;
    }

    public boolean currentViewIs(Class<? extends View> viewClass) {
        return viewClass.isInstance(getCurrentView());
    }

    public void setCurrentView(View currentView) {
        this.currentView = currentView;
    }
}
