package ui.card;

import component.card.Card;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import registry.render.RenderLayer;
import ui.render.Renderer;
import ui.render.RenderState;
import util.GridPos;

public class CardRenderer extends Renderer<Card> {

    public static final CardRenderer INSTANCE =
            new CardRenderer();

    private static final double TILE_SIZE = 85;

    private static final Font CARD_FONT =
            Font.font("Mozart NBP", 16);

    private CardRenderer() {}

    @Override
    protected double tileSize() {
        return TILE_SIZE;
    }

    @Override
    public void render(Card card, Pane node, GridPos pos) {
        RenderState state = CardRenderResolver.resolve(card);

        // draw base card via shared renderer
        draw(node, state);

        // 🔹 overlay text manually (for now)
        Canvas canvas = (Canvas) node.getChildren().get(0);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFont(CARD_FONT);
        gc.setFill(Color.BLACK);

        String text =
                card.getSuit() + "\n" +
                card.getValue() + "\n" +
                card.getMaterial();

        gc.fillText(text,0,10);
    }

    @Override
    public RenderLayer layer() {
        return RenderLayer.CARD;
    }
}
