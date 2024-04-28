package org.application.core.event;

import java.util.List;
import java.util.ArrayList;
import org.application.core.Native;

/**
 * OUVINTE DE EVENTOS
 * 
 * toma acao a partir de qualquer evento recebido pelo js
 */
public class EventListener extends Native {
    private static List<Handler> handlers = new ArrayList<>();
    private static List<Listener> listeners = new ArrayList<>();

    public static void eventDispatch(Object data) {
        if (handlers.size() > 0) {
            Event event = new Event(data);
            Object target = getEventTarget(data);
            Handler handler = null;
            for (int i = 0; i < handlers.size(); i++) {
                handler = handlers.get(i);
                if (equals(target, handler.getPointer())) {
                    handler.eventDispatch(event);
                }
            }
        }
    }

    public static void addEventListener(Object pointer, EventType type, ActionListener observer) {
        Handler handler = null;
        Listener listener = null;
        for (int i = 0; i < handlers.size(); i++) {
            handler = handlers.get(i);
            if (!equals(pointer, handler.getPointer())) {
                handler = null;
                continue;
            }
            handler.addActionListener(observer);
            break;
        }
        for (int i = 0; i < listeners.size(); i++) {
            listener = listeners.get(i);
            if (!equals(pointer, listener.getPointer())) {
                listener = null;
                continue;
            }
            listener.addEventType(type);
            break;
        }
        if (handler == null) {
            handler = new Handler(pointer);
            handler.addActionListener(observer);
            handlers.add(handler);
        }
        if (listener == null) {
            listener = new Listener(pointer);
            listener.addEventType(type);
            listeners.add(listener);
        }
    }
}
