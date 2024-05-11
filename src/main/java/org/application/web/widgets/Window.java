package org.application.web.widgets;

import org.application.core.elements.Element;
import org.application.core.elements.ElementType;

public class Window extends Element {
    public Window() {
        super(ElementType.HTML_DIV);
        setClassName("window");
    }
}
