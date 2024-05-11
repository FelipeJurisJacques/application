package org.application.core.elements;

import org.application.core.Native;

public class Document extends Native {
    protected static Document document = new Document(getDocument());
    protected Object pointer;

    public static Document getInstance() {
        return document;
    }

    public Document(Object pointer) {
        this.pointer = pointer;
    }

    public HtmlHead getHead() {
        Object reference = getHtmlHeadElement(pointer);
        HtmlHead element = (HtmlHead) Element.getElement(reference);
        return element == null ? new HtmlHead(this, reference) : element;
    }

    public HtmlBody getBody() {
        Object reference = getHtmlBodyElement(pointer);
        HtmlBody element = (HtmlBody) Element.getElement(reference);
        return element == null ? new HtmlBody(this, reference) : element;
    }

    public Element createElement(ElementType type) {
        switch (type) {
            case HTML_DIV:
                return new Element(this, getDocumentCreateElement(pointer, "div"), type);
            case HTML_HEAD:
                return new HtmlHead(this, getDocumentCreateElement(pointer, "head"));
            case HTML_BODY:
                return new Element(this, getDocumentCreateElement(pointer, "body"), type);
            case HTML_BOLD:
                return new Element(this, getDocumentCreateElement(pointer, "bold"), type);
            case HTML_LINK:
                return new Element(this, getDocumentCreateElement(pointer, "link"), type);
            case HTML_INPUT:
                return new Element(this, getDocumentCreateElement(pointer, "input"), type);
            case HTML_BUTTON:
                return new Element(this, getDocumentCreateElement(pointer, "button"), type);
            case HTML_FOOTER:
                return new Element(this, getDocumentCreateElement(pointer, "footer"), type);
            case HTML_DOCUMENT:
                return new Element(this, getDocumentCreateElement(pointer, "html"), type);
            case HTML_FORMULARY:
                return new Element(this, getDocumentCreateElement(pointer, "form"), type);
            case HTML_LIST_ITEM:
                return new Element(this, getDocumentCreateElement(pointer, "li"), type);
            case HTML_PARAGRAPH:
                return new Element(this, getDocumentCreateElement(pointer, "p"), type);
            case HTML_LINE_BREAK:
                return new Element(this, getDocumentCreateElement(pointer, "br"), type);
            case HTML_UNORDERED_LIST:
                return new Element(this, getDocumentCreateElement(pointer, "ul"), type);
            default:
                throw new IllegalArgumentException("Tag is unsupported");
        }
    }
}
