package component.modifier.pathway;

import component.card.Card;
import component.modifier.Modifier;
import logic.GameLevel;

public class Entrance extends Modifier { // Entrance and exit lives on the same layer as a modifier

    // TODO: ADD RESETTER TO THIS STATE
    int currentIndex;

    public Entrance() {
        currentIndex = 0;
    }

    @Override
    public void modify() {
        if (currentIndex >= GameLevel.getInstance().INPUT_CARDS.size()) return;
        Card toAdd = GameLevel.getInstance().INPUT_CARDS.get(currentIndex);
        if (toAdd.isInfiniteCard() == true) {
            // Create a new card if it is not infinite
            toAdd = new Card(toAdd.getSuit(), toAdd.getValue(), toAdd.getMaterial());
            System.out.println("Adding infinite card: " + toAdd);
            GameLevel.getInstance().addCard(toAdd, getGridPos());
            // note to self:
            // inf cards should append to end of arraylist
            // and i should make it a queue to not disturb memory
        } else if (GameLevel.getInstance().addCard(toAdd, getGridPos())) currentIndex++;
    }

    @Override
    public boolean isBlocking() {
        return false;
    }
}
