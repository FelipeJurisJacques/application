package org.application.core.elements.html;

import org.application.core.elements.Element;
import org.application.core.elements.Document;
import org.application.core.elements.ElementType;

public class Button extends Element {

    public Button(Document document) {
        super(document, ElementType.HTML_BUTTON);
        this.setType(ButtonType.BUTTON);
    }

    public Button(Document document, ButtonType type) {
        super(document, ElementType.HTML_BUTTON);
        this.setType(type);
    }

    public void setType(ButtonType type) {
        switch (type) {
            case BUTTON:
                this.setAttribute("type", "button");
                break;
            case SUBMIT:
                this.setAttribute("type", "submit");
                break;
            default:
                throw new IllegalArgumentException("invalid button type");
        }
    }
}
