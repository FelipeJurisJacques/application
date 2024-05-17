package org.application.core.elements;

import org.application.core.Native;
import org.application.core.util.List;
import org.application.core.event.Event;
import org.application.core.event.EventType;
import org.application.core.event.ActionListener;

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
        // boolean interacted;
        Element element = Element.getElement(getEventTarget(data));
        List<Element> elements = Element.getElements();
        // org.application.core.util.List<Element> interactions = new org.application.core.util.List<Element>();
        while (element != null) {
            // interactions.add(element);
            if (!clicked && element.eventListeners.execute(EventType.CLICK, data)) {
                clicked = true;
            }
            if (!element.focus && element.eventListeners.execute(EventType.FOCUS, data)) {
                element.focus = true;
            }
            element = element.getParentElement();
        }
        // for (int i = 0; i < elements.size(); i++) {
        //     element = elements.get(i);
        //     interacted = false;
            // for (int j = 0; j < interactions.size(); j++) {
            //     if (element.equals(interactions.get(j))) {
            //         interacted = true;
            //         break;
            //     }
            // }
        //     if (!interacted && element.focus && element.eventListeners.execute(EventType.WITHOUT_FOCUS, data)) {
        //         element.focus = false;
        //     }
        // }
    }

    private Window(Object pointer) {
        this.pointer = pointer;
        this.handler = getDefaultEventHandling();
        this.document = new Document(this);
        this.listeners = new List<>();
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
