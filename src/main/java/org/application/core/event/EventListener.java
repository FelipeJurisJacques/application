package org.application.core.event;

import java.util.List;
import java.util.ArrayList;

import org.application.core.Console;
import org.application.core.Native;

/**
 * OUVINTE DE EVENTOS
 * 
 * toma acao a partir de qualquer evento recebido pelo js
 */
public class EventListener extends Native {
    private static List<EventListener> handlers = new ArrayList<>();

    private Object pointer;
    private List<String> names;
    private List<ActionListener> listeners;

    public static void eventDispatch(Object data) {
        EventListener handler = getEventListener(getEventTarget(data));
        if (handler != null) {
            Event event = new Event(data);
            for (int i = 0; i < handler.listeners.size(); i++) {
                handler.listeners.get(i).actionPerformed(event);
            }
        }
    }

    public static void addEventListener(Object pointer, String name, ActionListener observer) {
        EventListener handler = getEventListener(pointer);
        if (handler == null) {
            handler = new EventListener(pointer);
            handler.addEventType(name);
        } else if (!handler.isContainsEventType(name)) {
            handler.addEventType(name);
        }
        handler.addActionListener(observer);
    }

    protected static EventListener getEventListener(Object pointer) {
        EventListener handler = null;
        for (int i = 0; i < handlers.size(); i++) {
            handler = handlers.get(i);
            if (
                pointer == null
                || handler.pointer == null
                || equals(pointer, handler.pointer)
            ) {
                return handler;
            }
        }
        return null;
    }

    protected EventListener(Object pointer) {
        this.names = new ArrayList<>();
        this.pointer = pointer;
        this.listeners = new ArrayList<>();
        handlers.add(this);
    }

    protected boolean isContainsEventType(String name) {
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equals(name)) {
                return true;
            }
        }
        return false;
    }

    protected void addEventType(String name) {
        names.add(name);
        addEventListener(pointer, name);
    }

    protected void addActionListener(ActionListener observer) {
        listeners.add(observer);
    }
}
