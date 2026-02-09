package component.modifier.changer;

import component.card.Card;
import logic.GameLevel;

public class MaterialSetter extends Changer<Card.Material> {

    public void modify() {
        Card toModify = GameLevel.getInstance().getTile(getGridPos()).getCard();
        if (toModify != null) toModify.setMaterial(changeValue);
    }

    public MaterialSetter(Card.Material material) {
        super();
        this.changeType = ChangeType.MATERIAL;
        this.changeValue = material;
    }
}
