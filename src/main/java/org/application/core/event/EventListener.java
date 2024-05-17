package org.application.core.event;

import org.application.core.Native;
import org.application.core.Console;
import org.application.core.util.Map;
import org.application.core.elements.Window;

/**
 * OUVINTE DE EVENTOS
 * 
 * toma acao a partir de qualquer evento recebido pelo js
 */
public class EventListener extends Native {
    protected Map<EventType, ActionListener> map;

    public static void eventDispatch(Object data) {
        try {
            if (data == null) {
                throw new IllegalArgumentException("event not nullable");
            }
            String type = getEventType(data);
            if (type.equals("click")) {
                Window.eventDispatch(data);
            }
        } catch (Throwable error) {
            Console.error(error);
        }
    }

    public EventListener() {
        this.map = new Map<>();
    }

    public void put(EventType type, ActionListener action) {
        map.put(type, action);
    }

    public boolean execute(EventType type, Object data) {
        ActionListener listener = this.map.get(type);
        if (listener != null) {
            Event event = new Event(data, type);
            listener.actionPerformed(event);
            event.finalize();
            return true;
        }
        return false;
    }

    @Override
    public void finalize() {
        if (this.map != null) {
            this.map.finalize();
            this.map = null;
        }
    }
}
