package testComponent.mover;

import component.mover.Conveyor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Direction;

import static org.junit.jupiter.api.Assertions.*;

public class TestConveyor {
    private Conveyor conveyor;

    @BeforeEach
    void setUp() {
        conveyor = new Conveyor(Direction.UP);
    }

    @Test
    void testConveyorDirections() {
        assertEquals(Direction.UP, conveyor.getDirectionStateless());
        assertEquals(Direction.UP, conveyor.getDirection());
        Direction[] validOutputDirections = conveyor.getValidOutputDirections();
        assertEquals(1, validOutputDirections.length);
        assertEquals(Direction.UP, validOutputDirections[0]);
    }
}