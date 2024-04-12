package org.application.web.elements;

import org.application.web.libs.Node;

/**
 *
 * @author felipe
 */
public class Element extends Node {

    public Element(Object pointer) {
        super(pointer);
    }

    public String getAttribute(String name) {
        return getHtmlElementAttribute(this.pointer, name);
    }

    public void setAttribute(String name, String value) {
        setHtmlElementAttribute(this.pointer, name, value);
    }
}
