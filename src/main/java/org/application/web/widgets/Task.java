package org.application.web.widgets;

import org.application.core.elements.Element;
import org.application.core.elements.Document;
import org.application.core.elements.ElementType;

public class Task extends Element {
    Window window;

    protected Task(Document document, Window window, Element bar) {
        super(document, ElementType.HTML_BUTTON);
        this.window = window;
        setClassName("task");
        setContent("aba aberta");
        bar.append(this);
    }
}
