package org.application.web.libs;

import de.inetsoftware.jwebassembly.api.annotation.Import;

/**
 *
 * @author felipe
 */
public abstract class Native {

    protected static int[] stringToAscii(String value) {
        int[] result = new int[value.length()];
        for (int i = 0; i < value.length(); i++) {
            result[i] = (int) value.charAt(i);
        }
        return result;
    }

    // WINDOW
    @Import(module = "window", js = "() => { return window }")
    protected static native Object getWindow();

    // CONSOLE LOG
    @Import(module = "console", js = "(v) => { console.log(v == 1); }")
    protected static native void logBoolean(int value);

    @Import(module = "console", js = "(v) => { console.log(v); }")
    protected static native void logInteger(int value);

    @Import(module = "console", js = "(v) => { const l = []; for (let i of v[2]) { l.push(String.fromCharCode(i)); } console.log(l.join('')); }")
    protected static native void logString(int[] value);

    @Import(module = "console", js = "(v) => { console.log(v); }")
    protected static native void logObject(Object value);

    @Import(module = "console", js = "(v) => { const l = []; for (let i of v[2]) { l.push(String.fromCharCode(i)); } console.error(l.join('')); }")
    protected static native void errorString(int[] value);

    // ELEMENTS

    protected static void setHtmlElementInnerText(Object pointer, String value) {
        _setHtmlElementInnerText(pointer, stringToAscii(value));
    }

    protected static Object getDocumentCreateElement(Object pointer, String name) {
        return _getDocumentCreateElement(pointer, stringToAscii(name));
    }

    protected static Object getDocumentCreateElement(Object pointer, char name) {
        return _getDocumentCreateElement(pointer, (int) name);
    }

    @Import(module = "native", name = "getDocument", js = "() => { return document }")
    protected static native Object getDocument();

    @Import(module = "native", name = "getObjectAttribute", js = "(o, p) => { return o[p.asciiToString()] }")
    private static native Object _getObjectAttribute(Object pointer, int[] value);

    @Import(module = "native", name = "getHtmlBodyElement", js = "o => { return o.body }")
    protected static native Object getHtmlBodyElement(Object pointer);

    @Import(module = "native", name = "getDocumentCreateElement", js = "(o, n) => { return o.createElement(n.asciiToString()) }")
    private static native Object _getDocumentCreateElement(Object pointer, int[] name);

    @Import(module = "native", name = "getDocumentCreateElementByChar", js = "(o, n) => { return o.createElement(String.fromCharCode(n)) }")
    private static native Object _getDocumentCreateElement(Object pointer, int name);

    @Import(module = "native", name = "setHtmlElementAppend", js = "(o, c) => { o.append(c) }")
    protected static native void setHtmlElementAppend(Object pointer, Object child);

    @Import(module = "native", name = "setHtmlElementInnerText", js = "(o, v) => { o.innerText = v.asciiToString() }")
    private static native Object _setHtmlElementInnerText(Object pointer, int[] value);
}
