package engine.event;

import engine.EngineEvent;
import engine.TickPhase;

public class ModifyEndedEvent extends EngineEvent {
    public ModifyEndedEvent() {
        super(TickPhase.MODIFY);
    }
}
