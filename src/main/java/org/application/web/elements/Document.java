package org.application.web.elements;

import org.application.web.libs.Native;

public class Document extends Native {

    public static Body getBody() {
        return new Body(getHtmlBodyElement(getDocument()));
    }
}
