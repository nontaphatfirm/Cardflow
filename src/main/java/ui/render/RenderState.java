package ui.render;

import javafx.scene.image.Image;

public record RenderState(
        Image image,
        double width,
        double height,
        double offsetX,
        double offsetY,
        double rotationDeg,
        boolean mirrorX,
        boolean grayscale,
        double alpha
) {}
