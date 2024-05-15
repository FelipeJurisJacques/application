package org.application.core.elements;

import org.application.core.Native;
import org.application.core.event.EventType;
import org.application.core.event.EventListener;
import org.application.core.event.ActionListener;

class Handler extends Native {
    EventListener eventListeners;

    protected Handler() {
        this.eventListeners = new EventListener();
    }

    public void setOnClick(ActionListener observer) {
        eventListeners.put(EventType.CLICK, observer);
    }

    @Override
    public void finalize() {
        if (this.eventListeners != null) {
            this.eventListeners.finalize();
            this.eventListeners = null;
        }
    }
}
