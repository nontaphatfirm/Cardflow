package component.modifier.changer;

import component.card.Card;

public class SuitSetter extends Changer<Card.Suit> {

    Card.Suit changeValue;

    @Override
    public void setChange(Card.Suit changeValue) {
        this.changeValue = changeValue;
    }

    @Override
    public Card.Suit getChange() {
        return changeValue;
    }

    public void modifyCard(Card card) {
        card.setSuit(changeValue);
    }

    public SuitSetter(Card.Suit changeValue) {
        this.changeType = ChangeType.SUIT;
        setChange(changeValue);
    }
}
