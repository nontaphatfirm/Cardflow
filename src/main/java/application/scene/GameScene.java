package application.scene;

import logic.level.GameLevel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


public class GameScene {
    public static Scene create(GameLevel level) {

        GameLevel.setInstance(level); // Most components will rely on this

        Rectangle rect1 = new Rectangle(500, 500);
        rect1.setFill(Color.PURPLE);

        Rectangle rect2 = new Rectangle(500, 500);
        rect2.setFill(Color.YELLOW);

        Region spacer = new Region();

        HBox mainLayout = new HBox();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        mainLayout.getChildren().addAll(rect1, spacer, rect2);

        mainLayout.setPadding(new Insets(30));
        mainLayout.setSpacing(30);
        mainLayout.setAlignment(Pos.BASELINE_CENTER);

        StackPane root = new StackPane();
        root.getChildren().add(mainLayout);
        root.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        root.getChildren().add(new Text("GameScene")); // TODO: DEBUG

        Scene scene = new Scene(root, 1920, 1080);

        return scene;
    }
}
