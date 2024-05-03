package org.application.core.elements;

import java.util.List;
import java.util.ArrayList;
import org.application.core.Native;

/**
 * @author felipe
 */
public class Element extends Native {
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
        if (elements.size() > 0) {
            Element element;
            for (int i = 0; i < elements.size(); i++) {
                element = elements.get(i);
                if (equals(pointer, element.getPointer())) {
                    elements.remove(i);
                    break;
                }
            }
        }
        setHtmlElementRemove(pointer);
        pointer = null;
    }
}
