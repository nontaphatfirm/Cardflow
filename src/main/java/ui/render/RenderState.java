package ui.render;

import javafx.scene.image.Image;

public record RenderState(
        Image image,
        double width,
        double height,
        double rotationDeg,
        boolean mirrorX,
        double alpha
) {}
