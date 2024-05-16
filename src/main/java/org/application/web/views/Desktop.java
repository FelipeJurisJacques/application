package org.application.web.views;

import org.application.core.event.Event;
import org.application.core.elements.Element;
import org.application.core.elements.Document;
import org.application.core.elements.html.Head;
import org.application.core.event.ActionListener;
import org.application.core.elements.ElementType;

public class Desktop {
        public Desktop() {
                Document document = Document.getInstance();
                Head head = document.getHead();
                head.addStylesheet("./source/stylesheet/index.css");
                head.addStylesheet("./source/stylesheet/window.css");
                head.addStylesheet("./source/stylesheet/task_bar.css");
                head.addStylesheet("./source/stylesheet/start_menu.css");

                Element body = document.getBody();

                Element start = document.createElement(ElementType.HTML_BUTTON);
                start.setClassName("start");
                start.setTitle("Start");

                Element footer = document.createElement(ElementType.HTML_FOOTER);
                footer.setClassName("task_bar");
                footer.append(start);

                Element desktop = document.createElement(ElementType.HTML_DIV);
                desktop.setClassName("desktop");

                Element bar = document.createElement(ElementType.HTML_DIV);
                bar.setClassName("bar");
                desktop.append(bar);

                body.append(desktop);
                body.append(footer);

                start.setOnClick(new ActionListener() {
                        @Override
                        public void actionPerformed(Event event) {
                                Element explorer = document.createElement(ElementType.HTML_BUTTON);
                                explorer.setClassName("explorer");
                                explorer.setContent("Explorador de arquivos");

                                Element curriculum = document.createElement(ElementType.HTML_BUTTON);
                                curriculum.setClassName("curriculum");
                                curriculum.setContent("Currículo");
                                // curriculum.addActionListener(new ActionListener() {
                                // @Override
                                // public void actionPerformed(Event event) {
                                // if (event.getType() == EventType.CLICK) {
                                // body.append(new Curriculum());
                                // }
                                // }
                                // });

                                Element ul = document.createElement(ElementType.HTML_UNORDERED_LIST);
                                
                                Element menu = document.createElement(ElementType.HTML_DIV);
                                menu.setClassName("start_menu");
                                menu.append(ul);
                                desktop.append(menu);

                                Element li = document.createElement(ElementType.HTML_LIST_ITEM);
                                li.append(explorer);
                                ul.append(li);

                                li = document.createElement(ElementType.HTML_LIST_ITEM);
                                li.append(curriculum);
                                ul.append(li);
                        }
                });
        }
}
