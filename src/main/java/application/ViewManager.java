package application;

import application.view.GameView;
import application.view.LevelSelectorView;
import application.view.MainMenuView;
import javafx.application.Platform;
import javafx.scene.layout.StackPane;
import logic.GameLevel;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewManager { // Switching views instead of switching scenes to allow for custom transitions.
    private static final String[] CSS_FILES= {"base.css", "cards.css", "tiles.css", "ui.css"};
    private static ViewManager instance;
    private final Stage stage;
    private final Scene scene;
    private StackPane currentPane;

    public enum View {
        Game,
        LevelSelector,
        MainMenu
    }

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
        this.scene = new Scene(new StackPane());

        for (String cssFile : CSS_FILES) {
            scene.getStylesheets().add(getClass().getResource("/css/"+cssFile).toExternalForm());
        }

        stage.setScene(scene);
        Platform.runLater(() -> scene.getRoot().requestFocus());
    }

    public void switchView(StackPane newViewPane) {
        // Switches view without transitions or anything
        StackPane sceneRoot = ((StackPane) scene.getRoot());
        if (currentPane == null)
            sceneRoot.getChildren().add(newViewPane);

        sceneRoot.getChildren().remove(currentPane);
        sceneRoot.getChildren().add(newViewPane);
        setCurrentPane(newViewPane);
    }

//    public void showMainMenu() {
//        this.setScene(MainMenuView.create());
//    }
//
//    public void showLevelSelector() {
//        this.setScene(LevelSelectorScene.create());
//    }
//
//    public void showGame(GameLevel level) {
//        this.setScene(GameScene.create(level));
//    }

    public StackPane getCurrentPane() {
        return currentPane;
    }

    public void setCurrentPane(StackPane currentPane) {
        this.currentPane = currentPane;
    }
}
