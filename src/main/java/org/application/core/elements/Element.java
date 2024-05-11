package org.application.core.elements;

import java.util.List;
import java.util.ArrayList;
import org.application.core.event.EventListener;
import org.application.core.exceptions.ElementOperationUnsupported;

/**
 * @author felipe
 */
public class Element extends EventListener {
    private static List<Element> elements = new ArrayList<>();
    protected Object pointer;
    protected ElementType type;

    public static Element getElement(Object pointer) {
        Element element;
        for (int i = 0; i < elements.size(); i++) {
            element = elements.get(i);
            if (equals(pointer, element.pointer)) {
                return element;
            }
        }
        element = new Element(pointer);
        return element;
    }

    protected Element(Object pointer) {
        if (pointer == null) {
            throw new IllegalArgumentException("Element not nullable");
        }
        String tag = getHtmlElementTagName(pointer);
        if (tag.equals("DIV")) {
            this.type = ElementType.HTML_DIV;
        } else if (tag.equals("HEAD")) {
            this.type = ElementType.HTML_HEAD;
        } else if (tag.equals("BODY")) {
            this.type = ElementType.HTML_BODY;
        } else if (tag.equals("BOLD")) {
            this.type = ElementType.HTML_BOLD;
        } else if (tag.equals("LINK")) {
            this.type = ElementType.HTML_LINK;
        } else if (tag.equals("INPUT")) {
            this.type = ElementType.HTML_INPUT;
        } else if (tag.equals("BUTTON")) {
            this.type = ElementType.HTML_BUTTON;
        } else if (tag.equals("FOOTER")) {
            this.type = ElementType.HTML_FOOTER;
        } else if (tag.equals("HTML")) {
            this.type = ElementType.HTML_DOCUMENT;
        } else if (tag.equals("FORM")) {
            this.type = ElementType.HTML_FORMULARY;
        } else if (tag.equals("LI")) {
            this.type = ElementType.HTML_LIST_ITEM;
        } else if (tag.equals("P")) {
            this.type = ElementType.HTML_PARAGRAPH;
        } else if (tag.equals("BR")) {
            this.type = ElementType.HTML_LINE_BREAK;
        } else if (tag.equals("UL")) {
            this.type = ElementType.HTML_UNORDERED_LIST;
        } else {
            throw new IllegalArgumentException("Tag is unsupported");
        }
        this.pointer = pointer;
        elements.add(this);
    }

    public Element(ElementType tag) {
        switch (tag) {
            case HTML_DIV:
                pointer = getDocumentCreateElement("div");
                break;
            case HTML_HEAD:
                pointer = getDocumentCreateElement("head");
                break;
            case HTML_BODY:
                pointer = getDocumentCreateElement("body");
                break;
            case HTML_BOLD:
                pointer = getDocumentCreateElement("bold");
                break;
            case HTML_LINK:
                pointer = getDocumentCreateElement("link");
                break;
            case HTML_INPUT:
                pointer = getDocumentCreateElement("input");
                break;
            case HTML_BUTTON:
                pointer = getDocumentCreateElement("button");
                break;
            case HTML_FOOTER:
                pointer = getDocumentCreateElement("footer");
                break;
            case HTML_DOCUMENT:
                pointer = getDocumentCreateElement("html");
                break;
            case HTML_FORMULARY:
                pointer = getDocumentCreateElement("form");
                break;
            case HTML_LIST_ITEM:
                pointer = getDocumentCreateElement("li");
                break;
            case HTML_PARAGRAPH:
                pointer = getDocumentCreateElement("p");
                break;
            case HTML_LINE_BREAK:
                pointer = getDocumentCreateElement("br");
                break;
            case HTML_UNORDERED_LIST:
                pointer = getDocumentCreateElement("ul");
                break;
            default:
                throw new IllegalArgumentException("Tag is unsupported");
        }
        type = tag;
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

    public Element addStylesheet(String path) throws ElementOperationUnsupported {
        if (type != ElementType.HTML_HEAD) {
            throw new ElementOperationUnsupported();
        }
        Element element = new Element(ElementType.HTML_LINK);
        element.setAttribute("rel", "stylesheet");
        element.setAttribute("href", path);
        append(element);
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
