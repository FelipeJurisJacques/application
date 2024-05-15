package org.application.core.elements.html;

import org.application.core.elements.Element;
import org.application.core.elements.Document;
import org.application.core.elements.ElementType;

public class Link extends Element {
    public Link(Document document) {
        super(document, ElementType.HTML_LINK);
    }

    public void setRel(String value) {
        setAttribute("rel", value);
    }

    public void setHref(String value) {
        setAttribute("href", value);
    }
}
