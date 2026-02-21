package engine;

import engine.event.ModifyEndedEvent;
import engine.event.MovementEndedEvent;
import event.EventBus;
import event.RenderEvent;
import logic.GameLevel;

import javafx.animation.AnimationTimer;

public class TickEngine {

    private static long lastTick = 0;
    private static final long TICK_INTERVAL_NS = 500_000_000;

    private static final AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            if (now - lastTick >= TICK_INTERVAL_NS) {
                tick();
                lastTick = now;
            }
        }
    };

    public static void start() {
        lastTick = 0;
        timer.start();
    }

    public static void stop() {
        timer.stop();
    }

    private static TickPhase currentPhase = TickPhase.MOVEMENT;

    public static void tick() {
        if (GameLevel.getInstance() == null) return;

        switch (currentPhase) {
            case MOVEMENT:
                GameLevel.getInstance().doMovementTick();
                EventBus.emit(new MovementEndedEvent());
                break;
            case MODIFY:
                GameLevel.getInstance().doModifyTick();
                EventBus.emit(new ModifyEndedEvent());
                break;
        
            default:
                break;
        }

        // Notify renderers about changed points
        EventBus.emit(new RenderEvent(GameLevel.getInstance().changedPoints));

        currentPhase = currentPhase.next();
    }
}
