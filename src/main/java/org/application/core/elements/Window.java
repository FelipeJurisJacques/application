package org.application.core.elements;

import org.application.core.util.List;
import org.application.core.directrix.Directrix;
import org.application.core.event.Event;
import org.application.core.event.EventType;

public class Window extends Directrix {
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
        boolean interacted;
        Element element = Element.getElement(getEventTarget(data));
        List<Element> elements = Element.getElements();
        List<Element> interactions = new List<Element>();
        while (element != null) {
            interactions.add(element);
            element = element.getParentElement();
        }
        for (int i = 0; i < elements.size(); i++) {
            element = elements.get(i);
            interacted = false;
            for (int j = 0; j < interactions.size(); j++) {
                if (equals(element.pointer, interactions.get(j).pointer)) {
                    interacted = true;
                    break;
                }
            }
            if (!interacted && _eventDispatch(element, EventType.WITHOUT_FOCUS, data)) {
                element.focus = false;
            }
        }
        for (int i = 0; i < interactions.size(); i++) {
            element = interactions.get(i);
            if (!clicked && _eventDispatch(element, EventType.CLICK, data)) {
                clicked = true;
                if (element.pointer == null) {
                    continue;
                }
            }
            if (!element.focus && _eventDispatch(element, EventType.FOCUS, data)) {
                element.focus = true;
                if (element.pointer == null) {
                    continue;
                }
            }
        }
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

    private static boolean _eventDispatch(Element element, EventType type, Object data) {
        if (element.eventListeners.contains(type)) {
            Event event = new Event(data, type, element);
            if (element.eventListeners.execute(event)) {
                return true;
            }
            event.finalize();
            event = null;
        }
        return false;
    }
}
