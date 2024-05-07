package org.application.core.event;

import java.util.List;
import java.util.ArrayList;

/**
 * MANIPULADOR DO EVENTO
 */
class Handler {
    private Object pointer;
    private List<ActionListener> listeners;

    public Handler(Object pointer) {
        this.pointer = pointer;
        this.listeners = new ArrayList<>();
    }

    public Object getPointer() {
        return pointer;
    }

    public void addActionListener(ActionListener observer) {
        listeners.add(observer);
    }

    public void eventDispatch(Event event) {
        for (int i = 0; i < listeners.size(); i++) {
            listeners.get(i).actionPerformed(event);
        }
    }

    @Override
    public void finalize() {
        if (listeners != null) {
            for (int i = 0; i < listeners.size(); i++) {
                listeners.get(i).finalize();
            }
        }
        pointer = null;
        listeners = null;
    }
}
