package component.modifier.changer;

import component.card.Card;

public class MaterialSetter extends Changer<Card.Material> {

    @Override
    public Card.Material getChange() {
        return this.changeValue;
    }

    @Override
    public void setChange(Card.Material changeValue) {
        this.changeValue = changeValue;
    }

    public void modifyCard(Card card) {
        card.setMaterial(changeValue);
    }

    public MaterialSetter() {
        this.changeType = ChangeType.MATERIAL;
    }
}
