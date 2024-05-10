package org.application.core.elements;

import org.application.core.Native;

public class Document extends Native {
    protected static Document document = new Document(getDocument());
    protected Object pointer;

    public static Document getInstance() {
        return document;
    }

    public Document(Object pointer) {
        this.pointer = pointer;
    }

    public Element getHead() {
        return Element.getElement(getHtmlHeadElement(pointer));
    }

    public Element getBody() {
        return Element.getElement(getHtmlBodyElement(pointer));
    }
}
