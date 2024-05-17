package org.application.core.elements;

import org.application.core.util.List;

/**
 * @author felipe
 */
public class Element extends Handler {
    protected Object pointer;
    protected ElementType type;
    protected Document document;
    protected static List<Element> elements = new List<>();

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

    public static List<Element> getElements() {
        return elements;
    }

    protected Element(Document document, ElementType type) {
        super();
        switch (type) {
            case HTML_DIV:
                pointer = getDocumentCreateElement(document.pointer, "DIV");
                break;
            case HTML_HEAD:
                pointer = getElementHead(document.pointer);
                if (pointer == null) {
                    pointer = getDocumentCreateElement(document.pointer, "HEAD");
                }
                break;
            case HTML_BODY:
                pointer = getElementBody(document.pointer);
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
        this.type = type;
        this.document = document;
        elements.add(this);
    }

    public String getAttribute(String name) {
        return getElementAttribute(pointer, name);
    }

    public void setAttribute(String name, String value) {
        setElementAttribute(pointer, name, value);
    }

    public void append(Element element) {
        setElementAppend(pointer, element.pointer);
    }

    public void setId(String value) {
        setAttribute("class", value);
    }

    public String getClassName() {
        return getAttribute("class");
    }

    public void setClassName(String value) {
        setAttribute("class", value);
    }

    public String setTitle() {
        return getAttribute("title");
    }

    public void setTitle(String value) {
        setAttribute("title", value);
    }

    public String getContent() {
        return getElementInnerText(pointer);
    }

    public void setContent(String value) {
        setElementInnerText(pointer, value);
    }

    public Element getParentElement() {
        return getElement(getElementParentElement(pointer));
    }

    public void remove() {
        setElementRemove(pointer);
        finalize();
    }

    @Override
    public void finalize() {
        if (pointer != null) {
            int length = getElementChildrenLength(pointer);
            if (length > 0) {
                Element element;
                for (int i = 0; i < length; i++) {
                    element = getElement(getElementChildrenItem(pointer, i));
                    if (element != null) {
                        element.finalize();
                    }
                }
                element = null;
            }
            for (int i = 0; i < elements.size(); i++) {
                if (equals(elements.get(i))) {
                    elements.remove(i);
                    break;
                }
            }
        }
        type = null;
        pointer = null;
        document = null;
        super.finalize();
    }
}
