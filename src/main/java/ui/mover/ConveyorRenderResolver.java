package ui.mover;

import component.mover.Conveyor;
import ui.mover.helper.MoverTopology;
import ui.mover.helper.MoverTopology.MoverShape;
import ui.mover.helper.RenderResolver;
import ui.render.RenderState;
import ui.render.Renderer;
import util.GridPos;

import javafx.scene.image.Image;

public final class ConveyorRenderResolver extends RenderResolver {

    private static final Image BASE_IMAGE = new Image(
            ConveyorRenderResolver.class.getResourceAsStream(
                    "/asset/tiles/mover/conveyor/conveyor-base.png"),
            0, 0, true, false);

    private static final Image TURN_RIGHT_IMAGE = new Image(
            ConveyorRenderResolver.class.getResourceAsStream(
                    "/asset/tiles/mover/conveyor/conveyor-turn.png"),
            0, 0, true, false);

    private ConveyorRenderResolver() {}

    public static RenderState resolve(
            Conveyor conveyor,
            GridPos pos,
            double alpha
    ) {
        MoverShape topology = MoverTopology.resolve(conveyor, pos);

        SpriteData sprite = selectSprite(topology);

        double rotation = rotationFor(conveyor) + sprite.rotationOffset();

        return new RenderState(
                sprite.image(),
                85,
                85,
                rotation,
                sprite.mirrorX(),
                alpha
        );
    }

    private static RenderResolver.SpriteData selectSprite(MoverTopology.MoverShape topology ) {
        return switch (topology) {
            case TURN_RIGHT ->
                    new RenderResolver.SpriteData(TURN_RIGHT_IMAGE, -90, false);

            case TURN_LEFT ->
                    new RenderResolver.SpriteData(TURN_RIGHT_IMAGE, +90, true);

            default ->
                    new RenderResolver.SpriteData(BASE_IMAGE, 0, false);
        };
    }

}
