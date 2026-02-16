package application.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class MainMenuView extends View {

    private static MainMenuView instance;

    public MainMenuView() {
        super();
        setInstance(this);
        root.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        root.getChildren().add(new Text("MainMenuScene"));
    }

    public static MainMenuView getInstance() {
        return instance;
    }

    public static void setInstance(MainMenuView view) {
        instance = view;
    }
}
