package application;

import java.util.Set;

import application.view.MainMenuView;
import component.GameTile;
import javafx.application.Platform;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import placement.PlacementController;
import util.GridPos;

public final class Game {

    private static final PlacementController controller = new PlacementController();

    public static void init(Stage primaryStage) {
        primaryStage.setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });

        ViewManager.init(primaryStage);
        ViewManager.getInstance().switchView(MainMenuView.create());
        primaryStage.show();
    }

    public static Set<GridPos> onTileClick(
            GameTile tile,
            MouseButton button,
            boolean shift,
            boolean ctrl
    ) {
        return controller.handleTileClick(tile, button, shift, ctrl);
    }

	public static void onSceneClick(
            MouseButton button,
            boolean shift,
            boolean ctrl
    ) {
        controller.handleSceneClick(button, shift, ctrl);
    }
}
