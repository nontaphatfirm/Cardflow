package testComponent.mover;

import component.mover.FlipFlop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Direction;

import static org.junit.jupiter.api.Assertions.*;

public class TestFlipFlop {
    private FlipFlop flipFlop;

    @BeforeEach
    void setUp() {
        flipFlop = new FlipFlop(Direction.RIGHT);
    }

    @Test
    void testInitialState() {
        assertTrue(flipFlop.isActive());
        assertEquals(Direction.RIGHT, flipFlop.getDirectionStateless());
    }

    @Test
    void testSetActive() {
        flipFlop.setActive(false);
        assertFalse(flipFlop.isActive());
        assertEquals(Direction.LEFT, flipFlop.getDirectionStateless());

        flipFlop.setActive(true);
        assertTrue(flipFlop.isActive());
        assertEquals(Direction.RIGHT, flipFlop.getDirectionStateless());
    }

    @Test
    void testValidOutputDirections() {
        Direction[] validOutputDirections = flipFlop.getValidOutputDirections();

        assertEquals(2, validOutputDirections.length);
        boolean hasBaseDirections = validOutputDirections[0] == Direction.RIGHT || validOutputDirections[1] == Direction.RIGHT;
        boolean hasOppositeDirections = validOutputDirections[0] == Direction.LEFT || validOutputDirections[1] == Direction.LEFT;
        assertTrue(hasBaseDirections);
        assertTrue(hasOppositeDirections);
    }

    @Test
    void testReset() {
        flipFlop.setActive(false);
        assertFalse(flipFlop.isActive());
        assertEquals(Direction.LEFT, flipFlop.getDirectionStateless());

        flipFlop.reset();
        assertTrue(flipFlop.isActive());
        assertEquals(Direction.RIGHT, flipFlop.getDirectionStateless());
    }
}