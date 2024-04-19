package org.application.web.views;

import org.application.web.elements.Body;
import org.application.web.widgets.Widget;
import org.application.web.elements.Document;
import org.application.web.events.EventListener;
import org.application.web.events.ActionListener;

public class Desktop {
    public Desktop() {
        Body body = Document.getBody();
        body.append(Widget.create("div")
                .setClass("desktop")
                .append(Widget.create("div")
                        .setClass("bar"))
                .append(Widget.create("div")
                        .setClass("start_menu")
                        .addActionListener("click", new ActionListener() {
                            @Override
                            public void actionPerformed(EventListener event) {
                                startMenu();
                            }
                        })
                        .append(
                                Widget.create("ul")
                                        .append(Widget.create("li")
                                                .append(Widget.create(
                                                        "button")
                                                        .setClass("explorer")
                                                        .setContent("Explorador de arquivos")))))
                .append(Widget.create("footer")
                        .setClass("task_bar")
                        .append(Widget.create("button")
                                .setClass("start")
                                .setTitle("Start"))));
    }

    public void startMenu() {
    }
}
