package engine;

import engine.event.ModifyEndedEvent;
import engine.event.MovementEndedEvent;
import event.EventBus;
import event.RenderEvent;
import logic.GameLevel;

import javafx.animation.AnimationTimer;

public class TickEngine {

    private static EngineState state = EngineState.PAUSED;

    private static long lastTick = 0;
    private static final long TICK_INTERVAL_NS = 500_000_000;

    private static final AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            if (state != EngineState.RUNNING) return;

            if (now - lastTick >= TICK_INTERVAL_NS) {
                tick();
                lastTick = now;
            }
        }
    };

    public static void play() {
        state = EngineState.RUNNING;
        start();
        System.out.println("Game started");
    }

    public static void pause() {
        state = EngineState.PAUSED;
        stop();
    }

    public static void step() {
        if (state == EngineState.PAUSED) {
            tick();
        }
    }

    public static void reset() {
        pause();
        //GameLevel.getInstance().reset(); // You must implement this
        EventBus.emit(new RenderEvent(GameLevel.getInstance().changedPoints));
    }

    private static void start() {
        if(lastTick != 0) return; // Prevent restarting the timer if it's already running
        lastTick = System.nanoTime();
        timer.start();
    }

    private static void stop() {
        lastTick = 0;
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
