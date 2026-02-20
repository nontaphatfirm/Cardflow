package event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventBus {
    private static final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listeners = new HashMap<>();

    public static <T extends Event> void register(Class<T> clazz, EventListener<T> listener) {
        listeners.computeIfAbsent(clazz, k -> new ArrayList<>()).add(listener);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Event> void emit(T event) {
        List<EventListener<? extends Event>> list = listeners.get(event.getClass());
        if (list == null) return;
        for (EventListener<? extends Event> l : list) {
            ((EventListener<T>) l).onEvent(event);
        }
    }
}
