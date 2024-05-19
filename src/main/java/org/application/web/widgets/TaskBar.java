package org.application.web.widgets;

import org.application.core.event.Event;
import org.application.core.elements.Element;
import org.application.core.elements.Document;
import org.application.core.elements.ElementType;
import org.application.core.elements.html.Button;
import org.application.core.event.ActionListener;

public class TaskBar extends Element {

    public TaskBar(Document document, Element desktop) {
        super(document, ElementType.HTML_FOOTER);
        setClassName("task_bar");
        Button start = new Button(document);
        start.setTitle("Start");
        start.setClassName("start");
        start.setOnClick(new ActionListener() {
            @Override
            public void actionPerformed(Event event) {
                new Menu(document, desktop, _getInstance());
            }
        });
        append(start);
    }

    private Element _getInstance() {
        return this;
    }
}
