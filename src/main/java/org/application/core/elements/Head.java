package org.application.core.elements;

public class Head extends Widget {
    public Head(Object pointer) {
        super(pointer);
    }

    // public Head setTitle(String value) {
    //     return this;
    // }

    public Head addStylesheet(String path) {
        Element element = new Element(getDocumentCreateElement("link"));
        element.setAttribute("rel", "stylesheet");
        element.setAttribute("href", path);
        append(element);
        return this;
    }
}
