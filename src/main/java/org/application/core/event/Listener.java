package org.application.core.event;

import java.util.List;
import java.util.ArrayList;
import org.application.core.Native;

/**
 * OUVINTE DO EVENTO
 */
class Listener extends Native {
    private Object pointer;
    private List<EventType> types;

    public Listener(Object pointer) {
        this.types = new ArrayList<>();
        this.pointer = pointer;
    }

    public Object getPointer() {
        return pointer;
    }

    public void addEventType(EventType type) {
        boolean contains = false;
        for (int i = 0; i < types.size(); i++) {
            if (types.get(i) == type) {
                contains = true;
            }
        }
        if (!contains) {
            types.add(type);
            switch (type) {
                case CLICK:
                    addEventListener(getWindow(), "click");
                    break;
                default:
                    break;
            }
        }
    }
}
