package org.application.core.elements;

import org.application.core.Native;
import org.application.core.elements.html.Div;
import org.application.core.elements.html.Body;
import org.application.core.elements.html.Head;
import org.application.core.elements.html.Link;
import org.application.core.elements.html.Button;
import org.application.core.elements.html.Footer;
import org.application.core.elements.html.Heading;
import org.application.core.elements.html.Paragraph;
import org.application.core.elements.html.HeadingSize;

public class Document extends Native {
    protected Window window;
    protected Object pointer;

    public static Document getInstance() {
        Window window = Window.getInstance();
        return window.getDocument();
    }

    protected Document(Window window) {
        this.window = window;
        this.pointer = getWindowDocument(window.pointer);
    }

    public Head getHead() {
        Head element = (Head) Element.getElement(getElementHead(pointer));
        return element == null ? new Head(this) : element;
    }

    public Body getBody() {
        Body element = (Body) Element.getElement(getElementBody(pointer));
        return element == null ? new Body(this) : element;
    }

    public Element createElement(ElementType type) {
        switch (type) {
            case HTML_DIV:
                return new Div(this);
            case HTML_HEAD:
                return new Head(this);
            case HTML_BODY:
                return new Body(this);
            case HTML_BOLD:
                return new Element(this, type);
            case HTML_LINK:
                return new Link(this);
            case HTML_INPUT:
                return new Element(this, type);
            case HTML_BUTTON:
                return new Button(this);
            case HTML_FOOTER:
                return new Footer(this);
            case HTML_DOCUMENT:
                return new Element(this, type);
            case HTML_FORMULARY:
                return new Element(this, type);
            case HTML_HEADING_1:
                return new Heading(getInstance(), HeadingSize.VERY_LARGE);
            case HTML_HEADING_2:
                return new Heading(getInstance(), HeadingSize.LARGE);
            case HTML_HEADING_3:
                return new Heading(getInstance(), HeadingSize.LITTLE_LARGE);
            case HTML_HEADING_4:
                return new Heading(getInstance(), HeadingSize.LITTLE_SMALL);
            case HTML_HEADING_5:
                return new Heading(getInstance(), HeadingSize.SMALL);
            case HTML_HEADING_6:
                return new Heading(getInstance(), HeadingSize.VERY_SMALL);
            case HTML_LIST_ITEM:
                return new Element(this, type);
            case HTML_PARAGRAPH:
                return new Paragraph(this);
            case HTML_LINE_BREAK:
                return new Element(this, type);
            case HTML_UNORDERED_LIST:
                return new Element(this, type);
            default:
                throw new IllegalArgumentException("Tag is unsupported");
        }
    }

    public Element querySelector(String query) {
        return Element.getElement(getElementQuerySelector(pointer, query));
    }

    @Override
    public void finalize() {
        pointer = null;
    }
}
