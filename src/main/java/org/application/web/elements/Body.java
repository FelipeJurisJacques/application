package org.application.web.elements;

public class Body extends Element {

    public Body(Object pointer) {
        super(pointer);
    }

    public void setAppend(Element element) {
        setHtmlElementAppend(this.pointer, element.getPointer());
    }
}
