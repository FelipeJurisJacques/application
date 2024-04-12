package org.application.web.elements;

public class Body extends Element {

    public Body(Object pointer) {
        super(pointer);
    }

    public Body setAppend(Element element) {
        setHtmlElementAppend(this.pointer, element.getPointer());
        return this;
    }
}
