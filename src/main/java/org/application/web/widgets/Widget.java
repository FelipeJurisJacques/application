package org.application.web.widgets;

import org.application.web.elements.Element;

public class Widget extends Element {

    public static Widget create(char tag) {
        return new Widget(getDocumentCreateElement(tag));
    }

    public static Widget create(String tag) {
        return new Widget(getDocumentCreateElement(tag));
    }

    public Widget(Object pointer) {
        super(pointer);
    }
    
    @Override
    public Widget setAttribute(String name, String value) {
        super.setAttribute(name, value);
        return this;
    }

    // public String getContent() {
    // }

    public Widget setContent(String value) {
        setHtmlElementInnerText(this.pointer, value);
        return this;
    }
}
