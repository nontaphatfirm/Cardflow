package engine;

import engine.event.ModifyEndedEvent;
import engine.event.MovementEndedEvent;
import event.EventBus;
import event.RenderEvent;
import logic.GameLevel;



public class TickEngine {
    private static TickPhase currentPhase = TickPhase.MOVEMENT;

    public static void tick() {
        if (GameLevel.getInstance() == null) return;

        switch (currentPhase) {
            case MOVEMENT:
                GameLevel.getInstance().doMovementTick();
                currentPhase = TickPhase.MODIFY;
                EventBus.emit(new MovementEndedEvent());
                break;
            case MODIFY:
                GameLevel.getInstance().doModifyTick();
                currentPhase = TickPhase.MOVEMENT;
                EventBus.emit(new ModifyEndedEvent());
                break;
        
            default:
                break;
        }

        // Notify renderers about changed points
        EventBus.emit(new RenderEvent(GameLevel.getInstance().changedPoints));

        currentPhase.next();
    }
}
