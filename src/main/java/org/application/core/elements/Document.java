package org.application.core.elements;

public class Document extends Element {

    public static Document getInstance() {
        Object pointer = getDocument();
        Document element = (Document) Element.getElement(pointer);
        return element == null ? new Document(pointer) : element;
    }

    public Document(Object pointer) {
        super(pointer);
    }

    public Head getHead() {
        Object head = getHtmlHeadElement(pointer);
        Head element = (Head) Element.getElement(head);
        return element == null ? new Head(head) : element;
    }

    public Body getBody() {
        Object body = getHtmlBodyElement(pointer);
        Body element = (Body) Element.getElement(body);
        return element == null ? new Body(body) : element;
    }
}
