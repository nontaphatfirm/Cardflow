package component.modifier.pathway;

import component.card.Card;
import component.modifier.pathway.event.CardEnterEvent;
import event.EventBus;
import logic.GameLevel;

public class Entrance extends Pathway { // Entrance and exit lives on the same layer as a modifier

    // TODO: ADD RESETTER TO THIS STATE

    public Entrance() {
    }

    @Override
    public void modify() {
        Card toAdd = getCurrentCard(GameLevel.getInstance().INPUT_CARDS);
        if (toAdd == null) return;
        GameLevel.getInstance().addCard(toAdd, getGridPos());
        EventBus.emit(new CardEnterEvent(getGridPos(), toAdd));
        currentIndex++;
    }

    @Override
    public boolean isBlocking() {
        return false;
    }
}
