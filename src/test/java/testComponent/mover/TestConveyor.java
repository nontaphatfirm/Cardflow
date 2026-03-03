package testComponent.mover;

import component.card.Card;
import component.card.Material;
import component.card.Suit;
import component.mover.Conveyor;
import component.mover.Mover;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Direction;
import util.GridPos;

import static org.junit.jupiter.api.Assertions.*;

public class TestConveyor {
    private Conveyor conveyor;

    @BeforeEach
    void setUp() {
        conveyor = new Conveyor(Direction.UP);
    }

    @Test
    void testConstructor() {
        Conveyor conveyor1 = new Conveyor(Direction.RIGHT);
        assertEquals(Direction.RIGHT, conveyor1.getRotation());

        Conveyor conveyor2 = new Conveyor(Direction.STAY);
        assertEquals(Direction.UP, conveyor2.getRotation());
    }

    @Test
    void testConveyorDirections() {
        assertEquals(Direction.UP, conveyor.getDirectionStateless());
        assertEquals(Direction.UP, conveyor.getDirection());
        Direction[] validOutputDirections = conveyor.getValidOutputDirections();
        assertEquals(1, validOutputDirections.length);
        assertEquals(Direction.UP, validOutputDirections[0]);
    }

    @Test
    void testRotate() {
        conveyor.rotate();
        assertEquals(Direction.RIGHT, conveyor.getRotation());
        conveyor.rotate();
        assertEquals(Direction.DOWN, conveyor.getRotation());
        conveyor.rotate();
        assertEquals(Direction.LEFT, conveyor.getRotation());
        conveyor.rotate();
        assertEquals(Direction.UP, conveyor.getRotation());
    }

    @Test
    void testGridPos() {
        conveyor.setGridPos(new GridPos(3, 4));
        assertEquals(3, conveyor.getGridPos().getX());
        assertEquals(4, conveyor.getGridPos().getY());

        conveyor.setGridPos(new GridPos(-5, 0));
        assertEquals(0, conveyor.getGridPos().getX());
        assertEquals(0, conveyor.getGridPos().getY());

        conveyor.setGridPos(new GridPos(10, 9));
        assertEquals(9,conveyor.getGridPos().getX());
        assertEquals(9,conveyor.getGridPos().getY());
    }

    @Test
    void testTranslationFromDirection() {
        assertEquals(0, Mover.getTranslationFromDirection(Direction.UP).getX());
        assertEquals(-1, Mover.getTranslationFromDirection(Direction.UP).getY());

        assertEquals(0, Mover.getTranslationFromDirection(Direction.DOWN).getX());
        assertEquals(1, Mover.getTranslationFromDirection(Direction.DOWN).getY());

        assertEquals(-1, Mover.getTranslationFromDirection(Direction.LEFT).getX());
        assertEquals(0, Mover.getTranslationFromDirection(Direction.LEFT).getY());

        assertEquals(1, Mover.getTranslationFromDirection(Direction.RIGHT).getX());
        assertEquals(0, Mover.getTranslationFromDirection(Direction.RIGHT).getY());

        assertEquals(0, Mover.getTranslationFromDirection(Direction.STAY).getX());
        assertEquals(0, Mover.getTranslationFromDirection(Direction.STAY).getY());
    }

    @Test
    void testIsBlocking() {
        assertFalse(conveyor.isBlocking());
    }
}