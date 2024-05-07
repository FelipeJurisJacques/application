package org.application.core.event;

import java.util.List;
import java.util.ArrayList;
import org.application.core.Native;

/**
 * OUVINTE DO EVENTO COM EVENT HANDLING UNICO
 */
class Listener extends Native {
    private Object pointer;
    private List<String> types;
    private static Object event = getDefaultEventHandling();

    public Listener(Object pointer) {
        this.types = new ArrayList<>();
        this.pointer = pointer;
    }

    public Object getPointer() {
        return pointer;
    }

    public void addEventType(String type) {
        boolean contains = false;
        for (int i = 0; i < types.size(); i++) {
            if (types.get(i).equals(type)) {
                contains = true;
            }
        }
        if (!contains) {
            addEventListener(pointer, type, event);
        }
    }

    @Override
    public void finalize() {
        types = null;
        pointer = null;
    }
}
