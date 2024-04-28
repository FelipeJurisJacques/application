package org.application.core.event;

import org.application.core.Native;
import org.application.core.elements.Widget;

public class Event extends Native {
    protected Object pointer;

    public Event(Object pointer) {
        this.pointer = pointer;
    }

    public EventType getType() {
        switch (getEventType(pointer)) {
            case "click":
                return EventType.CLICK;
            default:
                return EventType.NONE;
        }
    }

    public String getTypeName() {
        return getEventType(pointer);
    }

    public Widget getTarget() {
        return new Widget(getEventTarget(pointer));
    }
}
