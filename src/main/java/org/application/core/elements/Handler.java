package org.application.core.elements;

import org.application.core.event.EventType;
import org.application.core.event.EventListener;
import org.application.core.directrix.Directrix;
import org.application.core.event.ActionListener;

class Handler extends Directrix {
    boolean focus;
    EventListener eventListeners;

    protected Handler() {
        this.focus = false;
        this.eventListeners = new EventListener();
    }

    public void setOnClick(ActionListener observer) {
        eventListeners.put(EventType.CLICK, observer);
    }

    public void setOnWithoutFocus(ActionListener observer) {
        eventListeners.put(EventType.WITHOUT_FOCUS, observer);
    }

    @Override
    public void finalize() {
        if (this.eventListeners != null) {
            this.eventListeners.finalize();
            this.eventListeners = null;
        }
    }
}
