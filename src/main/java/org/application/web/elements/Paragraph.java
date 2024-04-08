package org.application.web.elements;

public class Paragraph extends Element {

    public Paragraph(Object pointer) {
        super(pointer);
    }

    public Paragraph()
    {
        super(getDocumentCreateElement(getDocument(), 'p'));
    }

    public void setContent(String value)
    {
        this.setInnerText(value);
    }

    public void setInnerText(String value)
    {
        setHtmlElementInnerText(this.pointer, value);
    }
}
