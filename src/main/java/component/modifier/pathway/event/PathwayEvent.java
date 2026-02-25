package component.modifier.pathway.event;

import component.card.Card;
import event.Event;
import util.GridPos;

public class PathwayEvent implements Event{
    private GridPos pos;
    private Card card;
    public PathwayEvent(GridPos pos, Card card) {
        this.pos = pos;
        this.card = card;
    }

    public GridPos getPos() {
        return pos;
    }
    public Card getCard() {
        return card;
    }
}
