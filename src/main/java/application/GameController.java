package application;

import java.util.Set;

import component.GameTile;
import component.mover.Conveyor;
import util.Direction;
import util.GridPos;

public class GameController {

    private Direction currentSelectedDirection = Direction.UP;

    public Set<GridPos> handleTileClick(
            GameTile tile,
            javafx.scene.input.MouseButton button,
            boolean shift,
            boolean ctrl
    ) {
        // Handle the tile click event here
        System.out.println("Tile clicked: " + tile + ", Button: " + button +
                ", Shift: " + shift + ", Ctrl: " + ctrl);
        if (button == javafx.scene.input.MouseButton.PRIMARY){
            if(tile.getMover() == null){
                tile.setMover(new Conveyor(currentSelectedDirection));
            } else {
                tile.setMover(null);
            }
        }
            
            
        
        if (button == javafx.scene.input.MouseButton.SECONDARY){
            if(tile.getMover() != null){
                currentSelectedDirection = tile.getMover().getDirection().next();
                tile.setMover(new Conveyor(currentSelectedDirection));
            }
        }

        return Set.of(tile.getGridPos());
    }
}
