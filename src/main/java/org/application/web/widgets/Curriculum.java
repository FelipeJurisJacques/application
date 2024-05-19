package org.application.web.widgets;

import org.application.core.elements.Element;
import org.application.core.elements.Document;

public class Curriculum extends Window {
    public Curriculum(Document document, Element desktop, Element bar) {
        super(document, desktop, bar);
        content.setContent("conteudo");
    }
}
