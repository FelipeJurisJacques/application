package org.application.core.elements;

import java.util.List;
import java.util.ArrayList;
import org.application.core.Native;
import org.application.core.event.ActionListener;
import org.application.core.event.Event;
import org.application.core.event.EventType;

public class Window extends Native {
    protected static Window window = new Window(getWindow());
    protected Object handler;
    protected Object pointer;
    protected Document document;
    protected List<Element> listeners;

    public static Window getInstance() {
        return window;
    }

    public static void eventDispatch(Object data) {
        boolean clicked = false;
        Element element = Element.getElement(getEventTarget(data));
        while (element != null) {
            if (!clicked && element.eventListeners.execute(EventType.CLICK, data)) {
                clicked = true;
            }
            if (!element.focus && element.eventListeners.execute(EventType.FOCUS, data)) {
                element.focus = true;
            }
            element = element.getParentElement();
        }
    }

    private Window(Object pointer) {
        this.pointer = pointer;
        this.handler = getDefaultEventHandling();
        this.document = new Document(this);
        this.listeners = new ArrayList<>();
        addEventListener(this.pointer, "click", this.handler);
    }

    public Document getDocument() {
        return document;
    }

    @Override
    public void finalize() throws IllegalAccessException {
        if (window.equals(this)) {
            throw new IllegalAccessException("global window not finalize");
        }
        this.document.finalize();
        removeEventListener(this.pointer, "click", this.handler);
        if (this.listeners != null) {
            for (int i = 0; i < this.listeners.size(); i++) {
                this.listeners.get(i).finalize();
            }
        }
        this.handler = null;
        this.pointer = null;
        this.document = null;
        this.listeners = null;
    }
}
