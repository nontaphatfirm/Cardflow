package component.card;

public class MetalCard extends Card {

    public MetalCard() {}
    public MetalCard(Suit suit, int value) {
        super(suit, value);
    }

    @Override
    public void setValue(int value) { } // don't do anything. (if this is an issue change it lol)

}
