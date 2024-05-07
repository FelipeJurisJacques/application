package org.application.core.event;

import org.application.core.Native;
import org.application.core.elements.Widget;

public class Event extends Native {
    protected Object pointer;
    protected EventType type;

    public Event(Object pointer) {
        this.pointer = pointer;
        switch (getEventType(pointer)) {
            case "click":
                type = EventType.CLICK;
                break;
            default:
                type = EventType.NONE;
                break;
        }
    }

    public EventType getType() {
        return type;
    }

    public Widget getTarget() {
        return new Widget(getEventTarget(pointer));
    }
}
