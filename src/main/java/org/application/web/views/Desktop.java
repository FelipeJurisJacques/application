package org.application.web.views;

import org.application.core.elements.Document;
import org.application.core.elements.Element;
import org.application.core.elements.ElementType;
import org.application.core.exceptions.ElementOperationUnsupported;

public class Desktop {
        public Desktop() throws ElementOperationUnsupported {
                Document document = Document.getInstance();
                Element head = document.getHead();
                head.addStylesheet("./source/stylesheet/index.css");
                head.addStylesheet("./source/stylesheet/window.css");
                head.addStylesheet("./source/stylesheet/task_bar.css");
                head.addStylesheet("./source/stylesheet/start_menu.css");

                Element body = document.getBody();

                Element start = new Element(ElementType.HTML_BUTTON);
                start.setClassName("start");
                start.setTitle("Start");

                Element footer = new Element(ElementType.HTML_FOOTER);
                footer.setClassName("task_bar");
                footer.append(start);

                Element desktop = new Element(ElementType.HTML_DIV);
                desktop.setClassName("desktop");
                desktop.append(new Element(ElementType.HTML_DIV).setClassName("bar"));

                body.append(desktop);
                body.append(footer);

                // start.addActionListener(new ActionListener() {
                // @Override
                // public void actionPerformed(Event event) {
                // Console.log('a');
                // if (event.getType() == EventType.CLICK) {
                // Element explorer = new Element(ElementType.HTML_BUTTON);
                // explorer.setClassName("explorer");
                // explorer.setContent("Explorador de arquivos");
                // Element curriculum = new Element(ElementType.HTML_BUTTON);
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
