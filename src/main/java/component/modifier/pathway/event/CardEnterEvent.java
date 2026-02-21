package component.modifier.pathway.event;

import component.card.Card;
import util.GridPos;

public class CardEnterEvent extends PathwayEvent {
    public CardEnterEvent(GridPos pos, Card card) {
        super(pos, card);
    }
    
}
