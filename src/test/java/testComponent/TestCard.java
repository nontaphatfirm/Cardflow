package testComponent;

import component.card.Card;
import logic.GameLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.GridPos;

import static org.junit.jupiter.api.Assertions.*;

public class TestCard {
    private Card card1,card2,card3,card4;

    @BeforeEach
    void setUp() {
        card1 = new Card();
        card4 = new Card(Card.Suit.DIAMOND,6,Card.Material.STONE,new GridPos(1, 0));
    }

    @Test
    void testDefaultConstructor() {
        assertEquals(Card.Suit.SPADE, card1.getSuit());
        assertEquals(1, card1.getValue());
        assertEquals(Card.Material.PLASTIC, card1.getMaterial());
        assertEquals(0, card1.getGridPos().getX());
        assertEquals(0, card1.getGridPos().getY());
    }

    @Test
    void testThreeParameterConstructor() {
        card2 = new Card(Card.Suit.DIAMOND,12,Card.Material.GLASS);
        assertEquals(Card.Suit.DIAMOND, card2.getSuit());
        assertEquals(12, card2.getValue());
        assertEquals(Card.Material.GLASS, card2.getMaterial());
        assertEquals(0, card2.getGridPos().getX());
        assertEquals(0, card2.getGridPos().getY());
    }

    @Test
    void testMasterConstructor() {
        card2 = new Card(Card.Suit.CLUB,2,Card.Material.CORRUPTED,new GridPos(3, 4));
        assertEquals(Card.Suit.CLUB, card2.getSuit());
        assertEquals(2, card2.getValue());
        assertEquals(Card.Material.CORRUPTED, card2.getMaterial());
        assertEquals(3, card2.getGridPos().getX());
        assertEquals(4, card2.getGridPos().getY());
    }

    @Test
    void testSetValueNormalRange() {
        card4.setValue(5);
        assertEquals(5, card4.getValue());
        card4.setValue(13);
        assertEquals(13, card4.getValue());
    }

    @Test
    void testSetValueOverflow() {
        card4.setValue(14);
        assertEquals(1, card4.getValue());
        card4.setValue(26);
        assertEquals(13, card4.getValue());
        card4.setValue(15);
        assertEquals(2, card4.getValue());
    }

    @Test
    void testSetValueUnderflow() {
        card4.setValue(0);
        assertEquals(13, card4.getValue());
        card4.setValue(-13);
        assertEquals(13, card4.getValue());
        card4.setValue(-1);
        assertEquals(12, card4.getValue());
    }

    @Test
    void testSetGridPosNormal() {
        card4.setGridPos(new GridPos(2, 3));
        assertEquals(2, card4.getGridPos().getX());
        assertEquals(3, card4.getGridPos().getY());
    }

    @Test
    void testSetGridPosNegativeClamping() {
        card4.setGridPos(new GridPos(-5, -1));
        assertEquals(0, card4.getGridPos().getX());
        assertEquals(0, card4.getGridPos().getY());
    }

    @Test
    void testSetGridPosExceedClamping() {
        int exceedX = GameLevel.MAX_WIDTH + 10;
        int exceedY = GameLevel.MAX_HEIGHT + 1;
        card4.setGridPos(new GridPos(exceedX, exceedY));
        assertEquals(GameLevel.MAX_WIDTH, card4.getGridPos().getX());
        assertEquals(GameLevel.MAX_HEIGHT, card4.getGridPos().getY());
    }

    @Test
    void testSettersForSuitAndMaterial() {
        card4.setSuit(Card.Suit.DIAMOND);
        assertEquals(Card.Suit.DIAMOND, card4.getSuit());
        card4.setMaterial(Card.Material.GLASS);
        assertEquals(Card.Material.GLASS, card4.getMaterial());
    }

    @Test
    void testIsBlocking() {
        assertTrue(card1.isBlocking());
        assertTrue(card4.isBlocking());
    }

    @Test
    void testToString() {
        assertEquals("Card{SPADE,1}", card1.toString());
        assertEquals("Card{DIAMOND,6}", card4.toString());
    }
}
