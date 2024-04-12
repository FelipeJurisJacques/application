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

    public String getContent() {
        return getHtmlElementInnerText(pointer);
    }

    public Widget setContent(String value) {
        setHtmlElementInnerText(pointer, value);
        return this;
    }

    public Widget setAppend(Element element) {
        setHtmlElementAppend(this.pointer, element.getPointer());
        return this;
    }
}
