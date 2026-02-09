package ui.mover;

import component.mover.Conveyor;
import ui.mover.helper.ConveyorTopology;
import ui.mover.helper.ConveyorTopology.ConveyorShape;
import ui.render.RenderState;
import util.GridPos;

import javafx.scene.image.Image;

public final class ConveyorRenderResolver {

    private static final Image CONVEYOR_BASE_IMAGE = new Image(
            ConveyorRenderResolver.class.getResourceAsStream(
                    "/asset/tiles/mover/conveyor/conveyor-base.png"),
            0, 0, true, false);

    private static final Image CONVEYOR_TURN_RIGHT_IMAGE = new Image(
            ConveyorRenderResolver.class.getResourceAsStream(
                    "/asset/tiles/mover/conveyor/conveyor-turn-right.png"),
            0, 0, true, false);

    private ConveyorRenderResolver() {}

    public static RenderState resolve(
            Conveyor conveyor,
            GridPos pos,
            double alpha
    ) {
        ConveyorShape topology =
                ConveyorTopology.resolve(conveyor, pos);

        SpriteData sprite = selectSprite(topology);

        double rotation =
                rotationFor(conveyor) + sprite.rotationOffset;

        return new RenderState(
                sprite.image,
                85,
                85,
                rotation,
                sprite.mirrorX,
                alpha
        );
    }

    private static SpriteData selectSprite(
            ConveyorShape topology
    ) {
        return switch (topology) {
            case TURN_RIGHT ->
                new SpriteData(CONVEYOR_TURN_RIGHT_IMAGE, -90, false);

            case TURN_LEFT ->
                new SpriteData(CONVEYOR_TURN_RIGHT_IMAGE, +90, true);

            default ->
                new SpriteData(CONVEYOR_BASE_IMAGE, 0, false);
        };
    }

    private static double rotationFor(Conveyor conveyor) {
        return switch (conveyor.getDirection()) {
            case UP -> 0;
            case RIGHT -> 90;
            case DOWN -> 180;
            case LEFT -> 270;
            default -> 0;
        };
    }

    private record SpriteData(
            Image image,
            double rotationOffset,
            boolean mirrorX
    ) {}
}
