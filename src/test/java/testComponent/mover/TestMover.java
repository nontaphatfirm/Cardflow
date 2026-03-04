package testComponent.mover;

import component.mover.Mover;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Direction;
import util.GridPos;

import static org.junit.jupiter.api.Assertions.*;

public class TestMover {
    private static class DummyMover extends Mover {
        public DummyMover(Direction rot) {
            super(rot);
        }

        @Override
        public Direction getDirectionStateless() {
            return getRotation();
        }

        @Override
        public Direction[] getValidOutputDirections() {
            return new Direction[]{getRotation()};
        }
    }

    private DummyMover mover;

    @BeforeEach
    void setUp() {
        mover = new DummyMover(Direction.UP);
    }

    @Test
    void testConstructorFallback() {
        DummyMover mover1 = new DummyMover(Direction.RIGHT);
        assertEquals(Direction.RIGHT, mover1.getRotation());

        DummyMover mover2 = new DummyMover(Direction.STAY);
        assertEquals(Direction.UP, mover2.getRotation());
    }

    @Test
    void testRotate() {
        mover.rotate();
        assertEquals(Direction.RIGHT, mover.getRotation());
        mover.rotate();
        assertEquals(Direction.DOWN, mover.getRotation());
        mover.rotate();
        assertEquals(Direction.LEFT, mover.getRotation());
        mover.rotate();
        assertEquals(Direction.UP, mover.getRotation());
    }

    @Test
    void testGridPosClamping() {
        mover.setGridPos(new GridPos(3, 4));
        assertEquals(3, mover.getGridPos().getX());
        assertEquals(4, mover.getGridPos().getY());

        mover.setGridPos(new GridPos(-5, 0));
        assertEquals(0, mover.getGridPos().getX());
        assertEquals(0, mover.getGridPos().getY());

        mover.setGridPos(new GridPos(10, 9));
        assertEquals(9, mover.getGridPos().getX());
        assertEquals(9, mover.getGridPos().getY());
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
        assertFalse(mover.isBlocking());
    }
}
