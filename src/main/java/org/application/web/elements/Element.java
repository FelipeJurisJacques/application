package org.application.web.elements;

import org.application.web.translations.Native;

/**
 *
 * @author felipe
 */
public class Element {

    public static Element document() {
        Native.importDocument();
        Element element = new Element();
        return element;
    }

    public static Element createElement(String name) {
        Element element = new Element();
        return element;
    }
}
