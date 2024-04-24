package org.application.core.elements;

import org.application.core.Native;

public class Document extends Native {

    public static Body getBody() {
        return new Body(getHtmlBodyElement(getDocument()));
    }
}
