package org.application.web.elements;

public class Div extends Element {

    public Div(Object pointer) {
        super(pointer);
    }

    public Div() {
        super(getDocumentCreateElement("div"));
    }
}
