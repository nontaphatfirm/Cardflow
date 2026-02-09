package placement;

import java.util.Set;

import component.GameTile;
import javafx.scene.input.MouseButton;
import placement.mover.ConveyorConstructor;
import util.GridPos;

public class PlacementController {

    private final TileConstructor<?> constructor = new ConveyorConstructor();

    public Set<GridPos> handleTileClick(
            GameTile tile,
            MouseButton button,
            boolean shift,
            boolean ctrl
    ) {
        if (button == MouseButton.PRIMARY) {
            if (tile.getMover() == null) {
                tile.setMover(((ConveyorConstructor) constructor).construct());
            } else {
                tile.setMover(null);
            }
        }

        if (button == MouseButton.SECONDARY) {
            constructor.cycleVariant();
            if (tile.getMover() != null) {
                tile.setMover(((ConveyorConstructor) constructor).construct());
            }
        }

        return Set.of(tile.getGridPos());
    }

    public void handleSceneClick(
            MouseButton button,
            boolean shift,
            boolean ctrl
    ) {
        if (button == MouseButton.SECONDARY) {
            constructor.cycleVariant();
        }
    }
}
