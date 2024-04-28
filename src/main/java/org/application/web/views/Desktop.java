package org.application.web.views;

import org.application.core.Console;
import org.application.core.event.Event;
import org.application.core.event.EventType;
import org.application.core.elements.Body;
import org.application.core.elements.Widget;
import org.application.core.elements.Document;
import org.application.core.event.ActionListener;

public class Desktop {
        public Desktop() {
                Body body = Document.getBody();
                Widget explorer = Widget.create("button");
                explorer.setClass("explorer");
                explorer.setContent("Explorador de arquivos");

                Widget ul = Widget.create("ul");

                Widget menu = Widget.create("div");
                menu.setClass("start_menu");

                Widget start = Widget.create("button");
                start.setClass("start");
                start.setTitle("Start");
                start.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(Event event) {
                                Console.log(event.getType() == EventType.CLICK);
                                // startMenu();
                        }
                });

                Widget footer = Widget.create("footer");
                footer.setClass("task_bar");
                footer.append(start);

                Widget desktop = Widget.create("div");
                desktop.setClass("desktop");
                desktop.append(Widget.create("div").setClass("bar"));
                desktop.append(menu.append(ul.append(Widget.create("li").append(explorer))));

                body.append(desktop);
                body.append(footer);
        }

        public void startMenu() {
                Console.log("clicou no botao");
        }
}
