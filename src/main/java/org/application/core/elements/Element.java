package org.application.core.elements;

import org.application.core.Native;

/**
 *
 * @author felipe
 */
public class Element extends Native {
    protected Object pointer;

    public Element(Object pointer) {
        this.pointer = pointer;
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
}
