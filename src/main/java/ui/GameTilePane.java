package ui;

import application.scene.GameScene;
import component.GameTile;
import component.mover.Conveyor;
import component.mover.Mover;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.OverrunStyle;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import logic.PlayerInventory;
import util.GridPos;

public class GameTilePane extends Button {
    private GameTile gameTileInfo;

    public GameTilePane(GameTile gameTileInfo) {
        this.gameTileInfo = gameTileInfo;
        getStyleClass().add("game-tile");
        setPrefSize(85, 85);
        setWrapText(true);
        setFocusTraversable(false);

        setOnAction(actionEvent -> {
            PlayerInventory.getInstance().placeToGrid(new GridPos(gameTileInfo.posX, gameTileInfo.posY));
            this.updateUI();
        });

        updateUI();
    }

    public void updateUI() {
        setText(gameTileInfo.toString());
    }

    public GameTile getGameTileInfo() {
        return gameTileInfo;
    }

    public void setGameTileInfo(GameTile gameTileInfo) {
        this.gameTileInfo = gameTileInfo;
    }
}
