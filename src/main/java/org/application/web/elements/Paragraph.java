package org.application.web.elements;

public class Paragraph extends Element {

    public Paragraph(Object pointer) {
        super(pointer);
    }

    public Paragraph() {
        super(getDocumentCreateElement('p'));
    }

    public void setContent(String value) {
        setHtmlElementInnerText(this.pointer, value);
    }
}
