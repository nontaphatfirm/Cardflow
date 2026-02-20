package engine;

import event.Event;

public class EngineEvent implements Event {
    private final TickPhase tickPhase;

    public EngineEvent(TickPhase tickPhase) {
        this.tickPhase = tickPhase;
    }

    public TickPhase getTickPhase() {
        return tickPhase;
    }
}
