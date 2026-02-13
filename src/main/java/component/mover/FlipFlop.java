package component.mover;

import util.Direction;

public class FlipFlop extends Mover {
    private boolean isActive; // Default counterclockwise of current direction otherwise clockwise

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public FlipFlop(Direction rotation) {
        super(rotation);
        isActive = true;
    }

    @Override
    public Direction getDirectionStateless() {
        return isActive ? getRotation().prev(): getRotation().next();
    }

    @Override
    public Direction getDirection() {
        Direction toReturn = getDirectionStateless();
        isActive = !isActive;
        return toReturn;
    }

}
