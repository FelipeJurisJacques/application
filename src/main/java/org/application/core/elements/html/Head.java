package org.application.core.elements.html;

import org.application.core.elements.Element;
import org.application.core.elements.Document;
import org.application.core.elements.ElementType;

public class Head extends Element {

    public Head(Document document) {
        super(document, ElementType.HTML_HEAD);
    }

    public void addStylesheet(String path) {
        Link element = new Link(document);
        element.setRel("stylesheet");
        element.setHref(path);
        append(element);
    }

    public void addManifest(String path) {
        Link element = new Link(document);
        element.setRel("manifest");
        element.setHref(path);
        append(element);
    }
}
