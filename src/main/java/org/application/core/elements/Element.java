package org.application.core.elements;

import java.util.List;
import java.util.ArrayList;
import org.application.core.event.EventListener;

/**
 * @author felipe
 */
public class Element extends EventListener {
    protected static List<Element> elements = new ArrayList<>();
    protected Object pointer;
    protected ElementType type;
    protected Document document;

    public static Element getElement(Object pointer) {
        if (elements.size() > 0) {
            Element element;
            for (int i = 0; i < elements.size(); i++) {
                element = elements.get(i);
                if (equals(pointer, element.pointer)) {
                    return element;
                }
            }
        }
        return null;
    }

    protected Element(Document document, ElementType type) {
        switch (type) {
            case HTML_DIV:
                pointer = getDocumentCreateElement(document.pointer, "DIV");
                break;
            case HTML_HEAD:
                pointer = getHtmlHeadElement(document.pointer);
                if (pointer == null) {
                    pointer = getDocumentCreateElement(document.pointer, "HEAD");
                }
                break;
            case HTML_BODY:
                pointer = getHtmlBodyElement(document.pointer);
                if (pointer == null) {
                    pointer = getDocumentCreateElement(document.pointer, "BODY");
                }
                break;
            case HTML_BOLD:
                pointer = getDocumentCreateElement(document.pointer, "BOLD");
                break;
            case HTML_LINK:
                pointer = getDocumentCreateElement(document.pointer, "LINK");
                break;
            case HTML_INPUT:
                pointer = getDocumentCreateElement(document.pointer, "INPUT");
                break;
            case HTML_BUTTON:
                pointer = getDocumentCreateElement(document.pointer, "BUTTON");
                break;
            case HTML_FOOTER:
                pointer = getDocumentCreateElement(document.pointer, "FOOTER");
                break;
            case HTML_DOCUMENT:
                pointer = getDocumentCreateElement(document.pointer, "HTML");
                break;
            case HTML_FORMULARY:
                pointer = getDocumentCreateElement(document.pointer, "FORM");
                break;
            case HTML_LIST_ITEM:
                pointer = getDocumentCreateElement(document.pointer, "LI");
                break;
            case HTML_PARAGRAPH:
                pointer = getDocumentCreateElement(document.pointer, 'P');
                break;
            case HTML_LINE_BREAK:
                pointer = getDocumentCreateElement(document.pointer, "BR");
                break;
            case HTML_UNORDERED_LIST:
                pointer = getDocumentCreateElement(document.pointer, "UL");
                break;
            default:
                throw new IllegalArgumentException("Tag is unsupported");
        }
        this.document = document;
        elements.add(this);
    }

    public Object getPointer() {
        return pointer;
    }

    public String getAttribute(String name) {
        return getHtmlElementAttribute(pointer, name);
    }

    public Element setAttribute(String name, String value) {
        setHtmlElementAttribute(pointer, name, value);
        return this;
    }

    public Element append(Element element) {
        setHtmlElementAppend(pointer, element.pointer);
        return this;
    }

    public Element setId(String value) {
        setAttribute("class", value);
        return this;
    }

    public String getClassName() {
        return getAttribute("class");
    }

    public Element setClassName(String value) {
        setAttribute("class", value);
        return this;
    }

    public String setTitle() {
        return getAttribute("title");
    }

    public Element setTitle(String value) {
        setAttribute("title", value);
        return this;
    }

    public String getContent() {
        return getHtmlElementInnerText(pointer);
    }

    public Element setContent(String value) {
        setHtmlElementInnerText(pointer, value);
        return this;
    }

    public void remove() {
        setHtmlElementRemove(pointer);
        finalize();
    }

    @Override
    public void finalize() {
        if (pointer != null) {
            int length = getHtmlElementChildrenLength(pointer);
            if (length > 0) {
                Object child = null;
                Element element = null;
                for (int i = 0; i < length; i++) {
                    child = getHtmlElementChildrenItem(pointer, i);
                    for (int j = 0; j < elements.size(); j++) {
                        element = elements.get(i);
                        if (equals(child, element.getPointer())) {
                            element.finalize();
                            break;
                        }
                    }
                }
                child = null;
                element = null;
            }
            removeEventListener(pointer);
            for (int i = 0; i < elements.size(); i++) {
                if (equals(pointer, elements.get(i).getPointer())) {
                    elements.remove(i);
                    break;
                }
            }
        }
        super.finalize();
        pointer = null;
    }
}
