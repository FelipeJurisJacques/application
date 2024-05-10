package org.application.web.views;

import org.application.core.event.Event;
import org.application.core.Console;
import org.application.core.elements.Body;
import org.application.core.elements.Head;
import org.application.core.event.EventType;
import org.application.web.widgets.Curriculum;
import org.application.core.elements.Widget;
import org.application.core.elements.Document;
import org.application.core.elements.Element;
import org.application.core.elements.ElementType;
import org.application.core.event.ActionListener;

public class Desktop {
        public Desktop() {
                Document document = Document.getInstance();
                Head head = document.getHead();
                head.addStylesheet("./source/stylesheet/index.css");
                head.addStylesheet("./source/stylesheet/window.css");
                head.addStylesheet("./source/stylesheet/task_bar.css");
                head.addStylesheet("./source/stylesheet/start_menu.css");

                Body body = document.getBody();

                Widget start = Widget.create("button");
                start.setClassName("start");
                start.setTitle("Start");

                Widget footer = Widget.create("footer");
                footer.setClassName("task_bar");
                footer.append(start);

                Widget desktop = Widget.create("div");
                desktop.setClassName("desktop");
                desktop.append(Widget.create("div").setClassName("bar"));

                body.append(desktop);
                body.append(footer);

                start.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(Event event) {
                                Console.log('a');
                                if (event.getType() == EventType.CLICK) {
                                        Element explorer = new Element(ElementType.HTML_BUTTON);
                                        explorer.setClassName("explorer");
                                        explorer.setContent("Explorador de arquivos");
                                        Widget curriculum = Widget.create("button");
                                        curriculum.setClassName("curriculum");
                                        curriculum.setContent("Currículo");
                                        curriculum.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(Event event) {
                                                        if (event.getType() == EventType.CLICK) {
                                                                body.append(new Curriculum());
                                                        }
                                                }
                                        });
                                        Widget ul = Widget.create("ul");
                                        Widget menu = Widget.create("div");
                                        menu.setClassName("start_menu");
                                        ul.append(Widget.create("li").append(explorer));
                                        ul.append(Widget.create("li").append(curriculum));
                                        menu.append(ul);
                                        desktop.append(menu);
                                }
                        }
                });
        }
}
