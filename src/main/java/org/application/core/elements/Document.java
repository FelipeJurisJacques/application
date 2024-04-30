package org.application.core.elements;

public class Document extends Element {

    public Document() {
        super(getDocument());
    }

    public Document(Object pointer) {
        super(pointer);
    }

    public Head getHead() {
        return new Head(getHtmlHeadElement(pointer));
    }

    public Body getBody() {
        return new Body(getHtmlBodyElement(pointer));
    }
}
