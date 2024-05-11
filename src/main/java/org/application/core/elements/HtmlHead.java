package org.application.core.elements;

public class HtmlHead extends Element {

    protected HtmlHead(Document document, Object pointer) {
        super(document, pointer, ElementType.HTML_HEAD);
    }

    public HtmlHead addStylesheet(String path) {
        Element element = document.createElement(ElementType.HTML_LINK);
        element.setAttribute("rel", "stylesheet");
        element.setAttribute("href", path);
        append(element);
        return this;
    }
}
