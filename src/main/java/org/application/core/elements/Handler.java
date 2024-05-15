package org.application.core.elements;

import java.util.Map;
import java.util.LinkedHashMap;
import org.application.core.Native;
import org.application.core.event.EventType;
import org.application.core.event.ActionListener;

class Handler extends Native {
    Map<EventType, ActionListener> eventListeners;

    protected Handler() {
        // this.eventListeners = new LinkedHashMap<>();
    }

    public void setOnClick(ActionListener observer) {
        // eventListeners.put(EventType.CLICK, observer);
    }

    @Override
    public void finalize() {
        // eventListeners = null;
    }
}
