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
        getHtmlElementAttribute(this.pointer, name);
        return "";
    }

    public void setAttribute(String name, String value) {
        setHtmlElementAttribute(this.pointer, name, value);
    }
}
