package org.application.core.elements;

import org.application.core.event.ActionListener;

public class Widget extends Element {

    public static Widget create(String tag) {
        return new Widget(getDocumentCreateElement(tag));
    }

    public Widget(Object pointer) {
        super(pointer);
    }

    public Widget append(Element element) {
        setHtmlElementAppend(pointer, element.getPointer());
        return this;
    }

    @Override
    public Widget setAttribute(String name, String value) {
        super.setAttribute(name, value);
        return this;
    }

    public Widget setId(String value) {
        super.setAttribute("class", value);
        return this;
    }

    public String setClass() {
        return super.getAttribute("class");
    }

    public Widget setClass(String value) {
        super.setAttribute("class", value);
        return this;
    }

    public String setTitle() {
        return super.getAttribute("title");
    }

    public Widget setTitle(String value) {
        super.setAttribute("title", value);
        return this;
    }

    public String getContent() {
        return getHtmlElementInnerText(pointer);
    }

    public Widget setContent(String value) {
        setHtmlElementInnerText(pointer, value);
        return this;
    }

    public Widget addActionListener(String name, ActionListener listener) {
        subscribe(listener);
        listener.setType(name);
        addEventListener(pointer, name);
        listener.setOrigin(this);
        return this;
    }

    // public Widget setChildren(Element[] elements) {
    // for (Element element : elements) {
    // this.append(element);
    // }
    // return this;
    // }
}
