package org.application.web.views;

import org.application.core.Console;
import org.application.core.event.Event;
import org.application.core.elements.Body;
import org.application.core.elements.Widget;
import org.application.core.elements.Document;
import org.application.core.event.ActionListener;

public class Desktop {
    public Desktop() {
        Body body = Document.getBody();
        body.append(Widget.create("div")
                .setClass("desktop")
                .append(Widget.create("div")
                        .setClass("bar"))
                .append(Widget.create("div")
                        .setClass("start_menu")
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
                                .setTitle("Start")
                                .addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(Event event) {
                                        startMenu();
                                    }
                                }))));
    }

    public void startMenu() {
        Console.log("clicou no botao");
    }
}
