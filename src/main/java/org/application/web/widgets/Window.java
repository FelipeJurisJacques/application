package org.application.web.widgets;

import org.application.core.elements.Element;
import org.application.core.elements.Document;
import org.application.core.elements.html.Div;
import org.application.core.elements.ElementType;

public class Window extends Element {
    protected Task task;
    protected Div content;

    public Window(Document document, Element desktop, Element bar) {
        super(document, ElementType.HTML_DIV);
        setClassName("window");
        task = new Task(document, this, bar);
        Div tool = new Div(document);
        tool.setClassName("tool_bar");
        append(tool);
        content = new Div(document);
        append(content);
    }
}
