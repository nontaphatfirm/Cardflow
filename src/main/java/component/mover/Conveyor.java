package component.mover;

public class Conveyor extends Mover {

    private Direction direction;

    @Override
    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

}
