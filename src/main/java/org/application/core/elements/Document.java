package org.application.core.elements;

import org.application.core.Native;
import org.application.core.elements.html.Body;
import org.application.core.elements.html.Head;

public class Document extends Native {
    protected static Document document = new Document(getDocument());
    protected Object pointer;

    public static Document getInstance() {
        return document;
    }

    public Document(Object pointer) {
        this.pointer = pointer;
    }

    public Head getHead() {
        Head element = (Head) Element.getElement(getHtmlHeadElement(pointer));
        return element == null ? new Head(this) : element;
    }

    public Body getBody() {
        Body element = (Body) Element.getElement(getHtmlBodyElement(pointer));
        return element == null ? new Body(this) : element;
    }

    public Element createElement(ElementType type) {
        switch (type) {
            case HTML_DIV:
                return new Element(this, type);
            case HTML_HEAD:
                return new Head(this);
            case HTML_BODY:
                return new Body(this);
            case HTML_BOLD:
                return new Element(this, type);
            case HTML_LINK:
                return new Element(this, type);
            case HTML_INPUT:
                return new Element(this, type);
            case HTML_BUTTON:
                return new Element(this, type);
            case HTML_FOOTER:
                return new Element(this, type);
            case HTML_DOCUMENT:
                return new Element(this, type);
            case HTML_FORMULARY:
                return new Element(this, type);
            case HTML_LIST_ITEM:
                return new Element(this, type);
            case HTML_PARAGRAPH:
                return new Element(this, type);
            case HTML_LINE_BREAK:
                return new Element(this, type);
            case HTML_UNORDERED_LIST:
                return new Element(this, type);
            default:
                throw new IllegalArgumentException("Tag is unsupported");
        }
    }
}
