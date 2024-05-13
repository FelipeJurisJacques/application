package org.application.core.elements.html;

import org.application.core.elements.Element;
import org.application.core.elements.Document;
import org.application.core.elements.ElementType;

public class Head extends Element {

    public Head(Document document) {
        super(document, ElementType.HTML_HEAD);
    }

    public Head addStylesheet(String path) {
        Element element = document.createElement(ElementType.HTML_LINK);
        element.setAttribute("rel", "stylesheet");
        element.setAttribute("href", path);
        append(element);
        return this;
    }
}
