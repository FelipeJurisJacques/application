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
    protected List<Map> map;

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
        this.map = new ArrayList<>();
    }

    public void put(EventType type, ActionListener action) {
        Map item = null;
        for (int i = 0; i < map.size(); i++) {
            item = map.get(i);
            if (type.equals(item.type)) {
                item.listener = action;
                break;
            }
        }
        if (item == null) {
            item = new Map(type, action);
            map.add(item);
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
        if (this.map != null) {
            for (int i = 0; i < this.map.size(); i++) {
                this.map.get(i).finalize();
            }
            this.map = null;
        }
    }

    protected ActionListener get(EventType type) {
        if (map.size() > 0) {
            Map item;
            for (int i = 0; i < map.size(); i++) {
                item = map.get(i);
                if (type.equals(item.type)) {
                    return item.listener;
                }
            }
        }
        return null;
    }
}
