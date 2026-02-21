package ui.modifier.pathway;

import component.modifier.pathway.event.CardEnterEvent;
import component.modifier.pathway.event.CardExitEvent;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.ParallelTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import registry.render.FloatingLayerRegistry;
import registry.render.RenderLayer;
import util.GridPos;

public class ExitEffect {

    public static final ExitEffect INSTANCE = new ExitEffect();

    private static final double TILE_SIZE = 85;

    private ExitEffect() {}

    public void applyEffect(CardExitEvent event) {

        Pane target = FloatingLayerRegistry.INSTANCE.getPane(RenderLayer.EFFECTS);

        GridPos pos = event.getPos();

        double centerX = pos.getX() * TILE_SIZE + TILE_SIZE / 2.0;
        double centerY = pos.getY() * TILE_SIZE + TILE_SIZE / 2.0;

        // Create glow circle
        Circle flash = new Circle(10);
        flash.setFill(Color.RED);
        flash.setOpacity(0.8);

        flash.setTranslateX(centerX);
        flash.setTranslateY(centerY);

        target.getChildren().add(flash);

        // Scale animation
        ScaleTransition scale = new ScaleTransition(Duration.millis(250), flash);
        scale.setFromX(4);
        scale.setFromY(4);
        scale.setToX(1);
        scale.setToY(1);

        // Fade animation
        FadeTransition fade = new FadeTransition(Duration.millis(250), flash);
        fade.setFromValue(0.8);
        fade.setToValue(0);

        ParallelTransition pt = new ParallelTransition(scale, fade);

        pt.setOnFinished(e -> target.getChildren().remove(flash));

        pt.play();
    }
}