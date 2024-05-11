package org.application.web.views;

import org.application.core.elements.Element;
import org.application.core.elements.Document;
import org.application.core.elements.HtmlHead;
import org.application.core.elements.ElementType;

public class Desktop {
        public Desktop() {
                Document document = Document.getInstance();
                HtmlHead head = document.getHead();
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
                desktop.append(document.createElement(ElementType.HTML_DIV).setClassName("bar"));

                body.append(desktop);
                body.append(footer);

                // start.addActionListener(new ActionListener() {
                // @Override
                // public void actionPerformed(Event event) {
                // Console.log('a');
                // if (event.getType() == EventType.CLICK) {
                // Element explorer = document.createElement(ElementType.HTML_BUTTON);
                // explorer.setClassName("explorer");
                // explorer.setContent("Explorador de arquivos");
                // Element curriculum = document.createElement(ElementType.HTML_BUTTON);
                // curriculum.setClassName("curriculum");
                // curriculum.setContent("Currículo");
                // // curriculum.addActionListener(new ActionListener() {
                // // @Override
                // // public void actionPerformed(Event event) {
                // // if (event.getType() == EventType.CLICK) {
                // // body.append(new Curriculum());
                // // }
                // // }
                // // });
                // Widget ul = Widget.create("ul");
                // Widget menu = Widget.create("div");
                // menu.setClassName("start_menu");
                // ul.append(Widget.create("li").append(explorer));
                // ul.append(Widget.create("li").append(curriculum));
                // menu.append(ul);
                // desktop.append(menu);
                // }
                // }
                // });
        }
}
