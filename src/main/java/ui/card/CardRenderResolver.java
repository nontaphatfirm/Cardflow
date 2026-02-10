package ui.card;

import component.card.Card;
import javafx.scene.image.Image;
import ui.render.RenderState;

public final class CardRenderResolver {

    private static final Image BASE_CARD_IMAGE = new Image(
            CardRenderResolver.class.getResourceAsStream(
                    "/asset/card/card-base.png"),
            0, 0,
            true,
            false
    );

    private static final double CARD_WIDTH  = 50;
    private static final double CARD_HEIGHT = 70;

    private CardRenderResolver() {}

    public static RenderState resolve(Card card) {
        RenderState state = new RenderState(BASE_CARD_IMAGE, CARD_WIDTH, CARD_HEIGHT, 0, false, 1.0);
        return state;
    }
}
