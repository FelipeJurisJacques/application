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
        _setConsoleLogString(_stringToAscii(value));
    }

    protected static void setConsoleErrorString(String value) {
        _setConsoleErrorString(_stringToAscii(value));
    }

    @Import(module = "native", name = "setConsoleLogInteger", js = "v => console.log(v)")
    protected static native void setConsoleLogInteger(int value);

    @Import(module = "native", name = "setConsoleLogObject", js = "v => console.log(v)")
    protected static native void setConsoleLogObject(Object value);

    @Import(module = "native", name = "setConsoleLogBoolean", js = "v => console.log(v == 1)")
    protected static native void _setConsoleLogBoolean(int value);

    @Import(module = "native", name = "setConsoleLogString", js = "v => console.log(v.asciiToString())")
    private static native void _setConsoleLogString(int[] value);

    @Import(module = "native", name = "setConsoleLogChar", js = "v => console.log(String.fromCharCode(v))")
    private static native void _setConsoleLogChar(int value);

    @Import(module = "native", name = "setConsoleErrorString", js = "v => console.error(v.asciiToString())")
    protected static native void _setConsoleErrorString(int[] value);

    // WINDOW

    @Import(module = "window", js = "() => { return window }")
    protected static native Object getWindow();

    // ELEMENTS

    protected static void setHtmlElementInnerText(Object pointer, String value) {
        _setHtmlElementInnerText(pointer, _stringToAscii(value));
    }

    protected static Object getDocumentCreateElement(char name) {
        return _getDocumentCreateElement((int) name);
    }

    protected static Object getDocumentCreateElement(String name) {
        return _getDocumentCreateElement(_stringToAscii(name));
    }

    protected static Object getDocumentCreateElement(Object pointer, char name) {
        return _getDocumentCreateElement(pointer, (int) name);
    }

    protected static Object getDocumentCreateElement(Object pointer, String name) {
        return _getDocumentCreateElement(pointer, _stringToAscii(name));
    }

    protected static String getHtmlElementAttribute(Object pointer, String name) {
        return _asciiToString(_getHtmlElementAttribute(pointer, _stringToAscii(name)));
    }

    protected static void setHtmlElementAttribute(Object pointer, String name, String value) {
        _setHtmlElementAttribute(pointer, _stringToAscii(name), _stringToAscii(value));
    }

    @Import(module = "native", name = "getDocument", js = "() => document")
    protected static native Object getDocument();

    @Import(module = "native", name = "getHtmlBodyElement", js = "o => o.body")
    protected static native Object getHtmlBodyElement(Object pointer);

    @Import(module = "native", name = "setHtmlElementAppend", js = "(o, c) => o.append(c)")
    protected static native void setHtmlElementAppend(Object pointer, Object child);

    @Import(module = "native", name = "getObjectAttribute", js = "(o, p) => o[p.asciiToString()]")
    private static native Object _getObjectAttribute(Object pointer, int[] value);

    @Import(module = "native", name = "getHtmlElementAttribute", js = "(e, n) => e.getAttribute(n.asciiToString())")
    private static native Object _getHtmlElementAttribute(Object pointer, int[] name);

    @Import(module = "native", name = "setHtmlElementAttribute", js = "(e, n, v) => e.setAttribute(n.asciiToString(), v.asciiToString())")
    private static native void _setHtmlElementAttribute(Object pointer, int[] name, int[] value);

    @Import(module = "native", name = "getDocumentCreateElement1", js = "n => document.createElement(String.fromCharCode(n))")
    private static native Object _getDocumentCreateElement(int name);

    @Import(module = "native", name = "getDocumentCreateElement2", js = "n => document.createElement(n.asciiToString())")
    private static native Object _getDocumentCreateElement(int[] name);

    @Import(module = "native", name = "getDocumentCreateElement3", js = "(e, n) => e.createElement(String.fromCharCode(n))")
    private static native Object _getDocumentCreateElement(Object pointer, int name);

    @Import(module = "native", name = "getDocumentCreateElement4", js = "(o, n) => o.createElement(n.asciiToString())")
    private static native Object _getDocumentCreateElement(Object pointer, int[] name);

    @Import(module = "native", name = "setHtmlElementInnerText", js = "(o, v) => o.innerText = v.asciiToString()")
    private static native Object _setHtmlElementInnerText(Object pointer, int[] value);

    // TRADUCAO

    private static int[] _stringToAscii(String value) {
        int[] result = new int[value.length()];
        for (int i = 0; i < value.length(); i++) {
            result[i] = (int) value.charAt(i);
        }
        return result;
    }

    private static String _asciiToString(Object pointer) {
        int length = _getStringLength(pointer);
        if (length > 0) {
            String result = "";
            for (int i = 0; i < length; i++) {
                // result += (char) _getStringAscii(pointer, i);
            }
            Console.log(result);
            // return result;
        }
        return "";
    }

    @Import(module = "native", name = "getStringLength", js = "s => s.length")
    private static native int _getStringLength(Object pointer);

    @Import(module = "native", name = "getStringAscii", js = "(s, i) => s.charCodeAt(i)")
    private static native int _getStringAscii(Object pointer, int index);
}
