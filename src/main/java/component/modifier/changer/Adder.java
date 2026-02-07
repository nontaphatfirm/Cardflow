package component.modifier.changer;

import component.card.Card;

public class Adder extends Changer<Integer> { // Generic type argument can't be primitive. This works basically the same way tho.

    private Integer changeValue;

    @Override
    public Integer getChange() {
        return changeValue;
    }

    @Override
    public void setChange(Integer changeValue) { // Can't be negative (Please use Subtractor instead)
        this.changeValue = Math.max(changeValue, 0);
    }

    public Adder(int changeValue) {
        this.changeType = ChangeType.NUMBER;
        this.changeValue = changeValue;
    }

    public void modifyCard(Card card) {
        card.setValue(card.getValue() + this.getChange());
    }
}
