package org.application.web.widgets;

import org.application.core.event.Event;
import org.application.core.elements.Element;
import org.application.core.elements.Document;
import org.application.core.elements.ElementType;
import org.application.core.event.ActionListener;

public class Menu extends Element {

    public Menu(Document document, Element desktop, Element bar) {
        super(document, ElementType.HTML_DIV);
        setClassName("start_menu");
        setOnWithoutFocus(new ActionListener() {
            @Override
            public void actionPerformed(Event event) {
                Element element = event.getTargetElement();
                element.remove();
            }
        });
        Element explorer = document.createElement(ElementType.HTML_BUTTON);
        explorer.setContent("Explorador de arquivos");
        explorer.setClassName("explorer");

        Element curriculum = document.createElement(ElementType.HTML_BUTTON);
        curriculum.setContent("Currículo");
        curriculum.setOnClick(new ActionListener() {
            @Override
            public void actionPerformed(Event event) {
                desktop.append(new Curriculum(document, desktop, bar));
                _getInstance().remove();
            }
        });
        curriculum.setClassName("curriculum");

        Element ul = document.createElement(ElementType.HTML_UNORDERED_LIST);

        append(ul);
        desktop.append(this);

        Element li = document.createElement(ElementType.HTML_LIST_ITEM);
        li.append(explorer);
        ul.append(li);

        li = document.createElement(ElementType.HTML_LIST_ITEM);
        li.append(curriculum);
        ul.append(li);
    }

    private Element _getInstance() {
        return this;
    }
}
