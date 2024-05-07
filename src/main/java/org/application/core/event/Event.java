package org.application.core.event;

import org.application.core.Native;
import org.application.core.elements.Widget;

public class Event extends Native {
    protected Object pointer;
    protected EventType type;

    public Event(Object pointer) {
        String type = getEventType(pointer);
        this.pointer = pointer;
        if (type.equals("click")) {
            this.type = EventType.CLICK;
        } else {
            this.type = EventType.NONE;
        }
    }

    public EventType getType() {
        return type;
    }

    public Widget getTarget() {
        return new Widget(getEventTarget(pointer));
    }
}
