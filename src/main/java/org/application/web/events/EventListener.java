package org.application.web.events;

import org.application.web.libs.Native;
import org.application.web.widgets.Widget;

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
