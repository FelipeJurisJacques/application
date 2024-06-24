package org.application.web.views;

import org.application.web.widgets.TaskBar;
import org.application.core.elements.Element;
import org.application.core.elements.Document;
import org.application.core.elements.html.Div;
import org.application.core.elements.html.Head;

public class Desktop {
        protected Div content;
        protected TaskBar bar;
        protected Document document;

        public Desktop(Document document) {
                this.document = document;
                Head head = document.getHead();
                head.addStylesheet("/source/stylesheet/index.css");
                head.addStylesheet("/source/stylesheet/window.css");
                head.addStylesheet("/source/stylesheet/task_bar.css");
                head.addStylesheet("/source/stylesheet/start_menu.css");

                Element body = document.getBody();

                content = new Div(document);
                content.setClassName("desktop");

                body.append(content);
                bar = new TaskBar(document, content);
                body.append(bar);
        }
}
