package org.application.web.libs;

import de.inetsoftware.jwebassembly.api.annotation.Import;

/**
 *
 * @author felipe
 */
public abstract class Native {

    // CONSOLE LOG

    protected static void setConsoleLogChar(char value) {
        _setConsoleLogChar((int) value);
    }

    protected static void setConsoleLogBoolean(boolean value) {
        _setConsoleLogBoolean(value ? 1 : 0);
    }

    protected static void setConsoleLogString(String value) {
        _setConsoleLogString(_toString(value));
    }

    protected static void setConsoleErrorString(String value) {
        _setConsoleErrorString(_toString(value));
    }

    @Import(module = "native", name = "setConsoleLogInteger", js = "v => console.log(v)")
    protected static native void setConsoleLogInteger(int value);

    @Import(module = "native", name = "setConsoleLogObject", js = "v => console.log(v)")
    protected static native void setConsoleLogObject(Object value);

    @Import(module = "native", name = "setConsoleLogBoolean", js = "v => console.log(v == 1)")
    protected static native void _setConsoleLogBoolean(int value);

    @Import(module = "native", name = "setConsoleLogString", js = "v => console.log(v)")
    private static native void _setConsoleLogString(Object value);

    @Import(module = "native", name = "setConsoleLogChar", js = "v => console.log(String.fromCharCode(v))")
    private static native void _setConsoleLogChar(int value);

    @Import(module = "native", name = "setConsoleErrorString", js = "v => console.error(v)")
    protected static native void _setConsoleErrorString(Object value);

    // WINDOW

    @Import(module = "window", js = "() => { return window }")
    protected static native Object getWindow();

    // ELEMENTS

    protected static String getHtmlElementInnerText(Object pointer) {
        return _getString(_getHtmlElementInnerText(pointer));
    }

    protected static void setHtmlElementInnerText(Object pointer, String value) {
        _setHtmlElementInnerText(pointer, _toString(value));
    }

    protected static Object getDocumentCreateElement(char name) {
        return _getDocumentCreateElement((int) name);
    }

    protected static Object getDocumentCreateElement(String name) {
        return _getDocumentCreateElement(_toString(name));
    }

    protected static Object getDocumentCreateElement(Object pointer, char name) {
        return _getDocumentCreateElement(pointer, (int) name);
    }

    protected static Object getDocumentCreateElement(Object pointer, String name) {
        return _getDocumentCreateElement(pointer, _toString(name));
    }

    protected static String getHtmlElementAttribute(Object pointer, String name) {
        return _getString(_getHtmlElementAttribute(pointer, _toString(name)));
    }

    protected static void setHtmlElementAttribute(Object pointer, String name, String value) {
        _setHtmlElementAttribute(pointer, _toString(name), _toString(value));
    }

    @Import(module = "native", name = "getDocument", js = "() => document")
    protected static native Object getDocument();

    @Import(module = "native", name = "getHtmlBodyElement", js = "o => o.body")
    protected static native Object getHtmlBodyElement(Object pointer);

    @Import(module = "native", name = "setHtmlElementAppend", js = "(o, c) => o.append(c)")
    protected static native void setHtmlElementAppend(Object pointer, Object child);

    @Import(module = "native", name = "getObjectAttribute", js = "(o, p) => o[p.asciiToString()]")
    private static native Object _getObjectAttribute(Object pointer, int[] value);

    @Import(module = "native", name = "getHtmlElementAttribute", js = "(e, n) => e.getAttribute(n)")
    private static native Object _getHtmlElementAttribute(Object pointer, Object name);

    @Import(module = "native", name = "setHtmlElementAttribute", js = "(e, n, v) => e.setAttribute(n, v)")
    private static native void _setHtmlElementAttribute(Object pointer, Object name, Object value);

    @Import(module = "native", name = "getHtmlElementInnerText", js = "e => e.innerText")
    private static native Object _getHtmlElementInnerText(Object pointer);

    @Import(module = "native", name = "setHtmlElementInnerText", js = "(o, v) => o.innerText = v")
    private static native Object _setHtmlElementInnerText(Object pointer, Object value);

    @Import(module = "native", name = "getDocumentCreateElement1", js = "n => document.createElement(String.fromCharCode(n))")
    private static native Object _getDocumentCreateElement(int name);

    @Import(module = "native", name = "getDocumentCreateElement2", js = "n => document.createElement(n)")
    private static native Object _getDocumentCreateElement(Object name);

    @Import(module = "native", name = "getDocumentCreateElement3", js = "(e, n) => e.createElement(String.fromCharCode(n))")
    private static native Object _getDocumentCreateElement(Object pointer, int name);

    @Import(module = "native", name = "getDocumentCreateElement4", js = "(o, n) => o.createElement(n)")
    private static native Object _getDocumentCreateElement(Object pointer, Object name);

    // TRADUCAO

    private static Object _toString(String value) {
        int[] result = new int[value.length()];
        for (int i = 0; i < value.length(); i++) {
            result[i] = (int) value.charAt(i);
        }
        return _setString(result);
    }

    private static String _getString(Object pointer) {
        int length = _getStringLength(pointer);
        if (length > 0) {
            String result = "";
            for (int i = 0; i < length; i++) {
                result += (char) _getChar(pointer, i);
            }
            return result;
        }
        return "";
    }

    @Import(module = "native", name = "getChar", js = "(s, i) => s.charCodeAt(i)")
    private static native int _getChar(Object pointer, int index);

    @Import(module = "native", name = "getStringLength", js = "s => s.length")
    private static native int _getStringLength(Object pointer);

    @Import(module = "native", name = "setString", js = "v => { const l = []; for (let a of v[2]) { l.push(String.fromCharCode(a)); } return l.join(''); }")
    private static native Object _setString(int[] value);
}
