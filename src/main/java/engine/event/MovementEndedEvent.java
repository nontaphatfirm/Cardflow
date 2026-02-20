package engine.event;

import engine.EngineEvent;
import engine.TickPhase;

public class MovementEndedEvent extends EngineEvent {
    public MovementEndedEvent() {
        super(TickPhase.MOVEMENT);
    }
}
