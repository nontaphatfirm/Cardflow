package component.modifier.pathway.event;

import component.card.Card;
import util.GridPos;

public class CardExitEvent extends PathwayEvent {
    public CardExitEvent(GridPos pos, Card card) {
        super(pos, card);
    }
    
}
