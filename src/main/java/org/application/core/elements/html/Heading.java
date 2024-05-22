package org.application.core.elements.html;

import org.application.core.elements.Element;
import org.application.core.elements.Document;
import org.application.core.elements.ElementType;

public class Heading extends Element {
    public Heading(Document document) {
        super(document, ElementType.HTML_HEADING_1);
    }

    public Heading(Document document, HeadingSize size) {
        super(document, Heading._gElementType(size));
    }

    private static ElementType _gElementType(HeadingSize size) {
        switch (size) {
            case VERY_LARGE:
                return ElementType.HTML_HEADING_1;
            case LARGE:
                return ElementType.HTML_HEADING_2;
            case LITTLE_LARGE:
                return ElementType.HTML_HEADING_3;
            case LITTLE_SMALL:
                return ElementType.HTML_HEADING_4;
            case SMALL:
                return ElementType.HTML_HEADING_5;
            case VERY_SMALL:
                return ElementType.HTML_HEADING_6;
            default:
                throw new IllegalArgumentException("Illegal size to heading");
        }
    }
}
