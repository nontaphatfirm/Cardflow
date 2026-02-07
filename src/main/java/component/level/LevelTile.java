package component.level;

import component.card.Card;
import component.modifier.Modifier;
import component.mover.Mover;

public class LevelTile {

    // TODO: Eventually, this could be set to public.
    private Card card;
    private Modifier modifier;
    private Mover mover;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Modifier getModifier() {
        return modifier;
    }

    public void setModifier(Modifier modifier) {
        this.modifier = modifier;
    }

    public Mover getMover() {
        return mover;
    }

    public void setMover(Mover mover) {
        this.mover = mover;
    }

    public LevelTile(Modifier modifier) {
        this.modifier = modifier;
    }

    @Override
    public String toString() {
        return "LevelTile{" +
                "card=" + card +
                ", modifier=" + modifier +
                ", mover=" + mover +
                '}';
    }
}
