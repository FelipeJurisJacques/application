package org.application.core.elements;

import java.util.List;
import java.util.ArrayList;
import org.application.core.event.EventListener;

/**
 * @author felipe
 */
public class Element extends EventListener {
    private static List<Element> elements = new ArrayList<>();
    protected Object pointer;

    public static Element getElement(Object pointer) {
        if (elements.size() > 0) {
            Element element;
            for (int i = 0; i < elements.size(); i++) {
                element = elements.get(i);
                if (equals(pointer, element.getPointer())) {
                    return element;
                }
            }
        }
        return null;
    }

    public static Element create(String tag) {
        return new Element(getDocumentCreateElement(tag));
    }

    public Element(Object pointer) {
        this.pointer = pointer;
        elements.add(this);
    }

    public Object getPointer() {
        return pointer;
    }

    public String getAttribute(String name) {
        return getHtmlElementAttribute(pointer, name);
    }

    public Element setAttribute(String name, String value) {
        setHtmlElementAttribute(pointer, name, value);
        return this;
    }

    public void remove() {
        setHtmlElementRemove(pointer);
        finalize();
    }

    @Override
    public void finalize() {
        if (pointer != null) {
            int length = getHtmlElementChildrenLength(pointer);
            if (length > 0) {
                Object child = null;
                Element element = null;
                for (int i = 0; i < length; i++) {
                    child = getHtmlElementChildrenItem(pointer, i);
                    for (int j = 0; j < elements.size(); j++) {
                        element = elements.get(i);
                        if (equals(child, element.getPointer())) {
                            element.finalize();
                            break;
                        }
                    }
                }
                child = null;
                element = null;
            }
            removeEventListener(pointer);
            for (int i = 0; i < elements.size(); i++) {
                if (equals(pointer, elements.get(i).getPointer())) {
                    elements.remove(i);
                    break;
                }
            }
        }
        super.finalize();
        pointer = null;
    }
}
