package org.application.web.views;

import org.application.core.elements.Element;
import org.application.core.elements.Document;
import org.application.core.elements.html.Div;
import org.application.core.elements.html.Head;
import org.application.core.elements.html.Heading;
import org.application.core.elements.html.Paragraph;
import org.application.core.elements.html.HeadingSize;

public class Curriculum {
    public Curriculum(Element parent) {
        Document document = parent.getDocument();
        Head head = document.getHead();
        head.addStylesheet("/source/stylesheet/curriculum.css");

        Div left = new Div(document);
        Heading name = new Heading(document, HeadingSize.VERY_LARGE);
        name.setContent("Felipe Juris Jacques");
        left.append(name);
        Heading info = new Heading(document, HeadingSize.LITTLE_LARGE);
        info.setContent("Desenvolvedor back-end pleno");
        left.append(info);
        Heading experience = new Heading(document, HeadingSize.LITTLE_SMALL);
        experience.setContent("Desenvolvedor back-end pleno F1-Commerce");
        left.append(experience);
        Paragraph description = new Paragraph(document);
        description.setContent("Experiência em integração com marketplaces em destaque Amazon SP-API, desenvolvimento de microsserviços.");
        left.append(description);

        Div right = new Div(document);

        parent.append(left);
        parent.append(right);
    }
}
