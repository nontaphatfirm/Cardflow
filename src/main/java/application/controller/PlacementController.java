package application.controller;

import application.controller.PlacementPathBuilder.PlacementNode;
import application.path.PlacementPathfinder;
import application.view.GameView;
import component.mover.Mover;
import event.EventBus;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import logic.GameLevel;
import logic.PlayerInventory;
import logic.event.card.TileSelectChangeEvent;
import ui.levelinfo.LevelInfoPane;
import ui.overlay.SelectedTileOverlayRenderer;
import util.Direction;
import util.GridPos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.BiFunction;

public class PlacementController {

    public static final PlacementController INSTANCE = new PlacementController();

    private String selectedTileName;
    private BiFunction<String, Direction, Mover> moverFactory;
    private Direction rotation;

    private GridPos dragStartPos;
    private GridPos currentMousePos;

    private List<PlacementNode> placementList = new ArrayList<>();

    public void handleTileSelectChange(TileSelectChangeEvent event) {
        this.selectedTileName = event.getMovements();
        this.moverFactory = event.getFactory();
        this.rotation = event.getRotation();
        SelectedTileOverlayRenderer.INSTANCE.setMoverDetails(moverFactory, selectedTileName);
    }

    public void handleOnMouseMove(GridPos pos) {
        currentMousePos = pos;
        dragStartPos = pos;
        updatePlacementList();
    }

    public void handleOnMouseExit(GridPos pos) {

        updatePlacementList();
        GameView.getInstance().updateTileAndAdjacent(pos);
    }

    public void handleMousePressed(MouseEvent event, GridPos gridPos) {
        if (event.getButton() != MouseButton.PRIMARY)
            return;

        dragStartPos = gridPos;
        currentMousePos = gridPos;
        updatePlacementList();
    }

    public void handleRightClick() {
        rotation = rotation.next();
        updatePlacementList();
    }

    public void handleMouseDragged(MouseEvent event, GridPos gridPos) {
        if (event.getButton() != MouseButton.PRIMARY)
            return;

        currentMousePos = gridPos;
        updatePlacementList();
    }

    public void handleMouseReleased(MouseEvent event, GridPos gridPos) {
        if (event.getButton() != MouseButton.PRIMARY)
            return;

        for (PlacementNode node : placementList) {
            PlayerInventory.getInstance().setCurrentSelection(selectedTileName);
            PlayerInventory.getInstance().setCurrentRotation(node.getDir());

            if (node.getDel()) {
                PlayerInventory.getInstance().removeFromGrid(node.getPos());
            } else {
                PlayerInventory.getInstance().placeToGrid(node.getPos());
            }

        }

        dragStartPos = currentMousePos;
        updatePlacementList();
        GameView.getInstance().getLevelInfoPane().updateInventoryUI();
    }

    private void updatePlacementList() {
        placementList = PlacementPathBuilder.buildPath(
                dragStartPos,
                currentMousePos,
                rotation);

        SelectedTileOverlayRenderer.INSTANCE.updatePlacementList(placementList);
    }
}
