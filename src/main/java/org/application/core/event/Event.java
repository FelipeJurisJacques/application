package org.application.core.event;

import org.application.core.Native;

public class Event extends Native {
    protected Object pointer;
    protected EventType type;

    public Event(Object pointer, EventType type) {
        this.type = type;
        this.pointer = pointer;
    }

    public EventType getType() {
        return type;
    }
}
