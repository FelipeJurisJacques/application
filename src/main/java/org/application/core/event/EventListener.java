package org.application.core.event;

import org.application.core.Native;
import org.application.core.elements.Widget;

public class EventListener extends Native {
    protected Object pointer;

    public EventListener(Object pointer) {
        this.pointer = pointer;
    }

    public String getType() {
        return getEventType(pointer);
    }

    public Widget getTarget() {
        return new Widget(getEventTarget(pointer));
    }
}
