package org.application.core.event;

import org.application.core.Native;
import org.application.core.elements.Element;

public class Event extends Native {
    protected Object pointer;
    protected EventType type;
    protected Element element;

    public Event(Object pointer, EventType type) {
        this.type = type;
        this.pointer = pointer;
        this.element = null;
    }

    public Event(Object pointer, EventType type, Element target) {
        this.type = type;
        this.pointer = pointer;
        this.element = target;
    }

    public EventType getType() {
        return type;
    }

    public Element getTargetElement() {
        if (element == null) {
            throw new IllegalArgumentException("element is null");
        }
        return element;
    }

    @Override
    public void finalize() {
        this.type = null;
        this.pointer = null;
    }
}
