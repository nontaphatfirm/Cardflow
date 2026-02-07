package component.card;

abstract public class Card {

    public enum Suit {
        HEART,
        DIAMOND,
        CLUB,
        SPADE
    }

    public enum Material { // This is just a list. Please use instanceof when checking.
        PLASTIC,
        METAL,
        STONE,
        GLASS,
        RUBBER,
        CORRUPTED
    }

    protected Suit suit;
    protected int value; // Valid value range from [0,12] (Ace -> 0, 2 -> 1, ... K -> 12)

    protected Card() {
        // Default constructor is ace of spades.
        this(Suit.SPADE, 1);
    }

    protected Card(Suit suit, int value) {
        setSuit(suit);
        setValue(value);
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        // Value wraps around if overflow or underflow
        value = Math.floorMod(value, 13);
        this.value = value;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "suit=" + suit +
                ", value=" + value +
                '}';
    }
}
