package org.application.core.event;

import java.util.List;
import java.util.ArrayList;
import org.application.core.Native;
import org.application.core.Console;
import org.application.core.elements.Window;

/**
 * OUVINTE DE EVENTOS
 * 
 * toma acao a partir de qualquer evento recebido pelo js
 */
public class EventListener extends Native {
    protected List<Handler> listeners;

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
        listeners = new ArrayList<>();
    }

    public void put(EventType type, ActionListener action) {
        Handler handler = null;
        for (int i = 0; i < listeners.size(); i++) {
            handler = listeners.get(i);
            if (type.equals(handler.type)) {
                handler.listener = action;
                break;
            }
        }
        if (handler == null) {
            handler = new Handler(type, action);
            listeners.add(handler);
        }
    }

    public boolean execute(EventType type, Object data) {
        ActionListener listener = this.get(type);
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
        if (this.listeners != null) {
            for (int i = 0; i < this.listeners.size(); i++) {
                this.listeners.get(i).finalize();
            }
            this.listeners = null;
        }
    }

    protected ActionListener get(EventType type) {
        if (listeners.size() > 0) {
            Handler handler;
            for (int i = 0; i < listeners.size(); i++) {
                handler = listeners.get(i);
                if (type.equals(handler.type)) {
                    return handler.listener;
                }
            }
        }
        return null;
    }
}
