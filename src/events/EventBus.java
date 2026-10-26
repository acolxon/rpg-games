package events;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventBus {
    private final List<GameListener> listeners = new CopyOnWriteArrayList<>();

    public void subscribe(GameListener gl){
        listeners.add(gl);
    }

    public void publish(GameEvent ge){
        for (GameListener gl : listeners){
            gl.onEvent(ge);
        }
    }
}
