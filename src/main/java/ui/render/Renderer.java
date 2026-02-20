package ui.render;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

public abstract class Renderer<T> {

    protected abstract double tileSize();

    public abstract void render(T tile, Pane node, util.GridPos pos);

    protected void draw(Pane node, RenderState state) {
        Canvas canvas = new Canvas(state.width(), state.height());
        drawWithCanvas(node, state, canvas);
        node.getChildren().setAll(canvas);
    }

    protected void drawWithCanvas(Pane node, RenderState state, Canvas canvas) {
        double w = state.width();
        double h = state.height();

        double tile = tileSize();

        // 🔥 CENTER THE CANVAS IN THE TILE
        canvas.setLayoutX((tile - w) / 2.0);
        canvas.setLayoutY((tile - h) / 2.0);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setImageSmoothing(false);
        // gc.clearRect(0, 0, w, h);

        gc.save();
        gc.setGlobalAlpha(state.alpha());

        // rotate around renderable center
        gc.translate(w / 2, h / 2);
        gc.rotate(state.rotationDeg());

        if (state.mirrorX()) {
            gc.scale(-1, 1);
        }
        gc.drawImage(
                state.image(),
                -w / 2,
                -h / 2,
                w,
                h);

        gc.restore();
    }

    public abstract registry.render.RenderLayer layer();
}
