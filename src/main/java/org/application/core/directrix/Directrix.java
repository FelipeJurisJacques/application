package org.application.core.directrix;

import org.application.core.util.List;
import org.application.core.pool.Reusable;
import org.application.core.event.EventListener;
import org.application.core.asynchronous.Promise;
import org.application.core.asynchronous.Asynchronous;
import de.inetsoftware.jwebassembly.api.annotation.Export;
import de.inetsoftware.jwebassembly.api.annotation.Import;

/**
 * @author felipe
 */
public abstract class Directrix {
    private static List<InnerPromiseNative> _asynchronous;

    private static class InnerPromiseNative extends Promise<Object> {
        private Object pointer;

        public InnerPromiseNative() {
            super();
            pointer = null;
        }
    }

    // PROMISE

    @Export
    public static void promiseResolve(Object pointer, Object data) {
        InnerPromiseNative reference;
        for (int i = 0; i < _asynchronous.length(); i++) {
            reference = _asynchronous.get(i);
            if (equals(reference.pointer, pointer)) {
                try {
                    reference.resolve(data);
                } catch (Throwable error) {
                    reference.reject(error);
                }
                _asynchronous.remove(i);
                break;
            }
        }
    }

    @Export
    public static void promiseReject(Object pointer, Object data) {
        InnerPromiseNative reference;
        for (int i = 0; i < _asynchronous.length(); i++) {
            reference = _asynchronous.get(i);
            if (equals(reference.pointer, pointer)) {
                Property obj = new Property(data);
                String message = obj.get("message").asString();
                reference.reject(new Exception(message));
                _asynchronous.remove(i);
                break;
            }
        }
    }

    private static Promise<Object> _getPromise(Object pointer) {
        InnerPromiseNative promise = new InnerPromiseNative();
        promise.pointer = pointer;
        setConsoleLog(pointer);
        // _setPromiseThen(pointer);
        // _setPromiseCatch(pointer);
        // _asynchronous.push(promise);
        return promise;
    }

    @Import(module = "native", name = "setPromiseThen", js = "p => p.then(v => wasmImports.native.promiseResolve(p, v))")
    private static native void _setPromiseThen(Object promise);

    @Import(module = "native", name = "setPromiseCatch", js = "p => p.catch(e => wasmImports.native.promiseReject(p, e))")
    private static native void _setPromiseCatch(Object promise);

    // EVENTS

    @Export
    public static void message(Object data, Object origin) {
        Asynchronous.message(data, origin);
    }

    @Export
    public static void eventDispatch(Object data) {
        EventListener.eventDispatch(data);
    }

    protected static String getEventType(Object pointer) {
        return getString(_getEventType(pointer));
    }

    protected static void addEventListener(Object pointer, String name, Object event) {
        _addEventListener(pointer, toString(name), event);
    }

    protected static void removeEventListener(Object pointer, String name, Object event) {
        _removeEventListener(pointer, toString(name), event);
    }

    @Import(module = "native", name = "getDefaultEventHandling", js = "() => e => wasmImports.native.eventDispatch(e)")
    protected static native Object getDefaultEventHandling();

    @Import(module = "native", name = "getEventTarget", js = "e => e.target")
    protected static native Object getEventTarget(Object pointer);

    @Import(module = "native", name = "getEventType", js = "e => e.type")
    private static native Object _getEventType(Object pointer);

    @Import(module = "native", name = "addEventListener", js = "(e, n, l) => e.addEventListener(n, l)")
    private static native void _addEventListener(Object pointer, Object name, Object event);

    @Import(module = "native", name = "removeEventListener", js = "(e, n, l) => e.removeEventListener(n, l)")
    private static native void _removeEventListener(Object pointer, Object name, Object event);

    // CONSOLE LOG

    @Import(module = "native", name = "setConsoleLog", js = "v => console.log(v)")
    protected static native void setConsoleLog(Object value);

    @Import(module = "native", name = "setConsoleError", js = "v => console.error(v)")
    protected static native void setConsoleError(Object value);

    // WINDOW

    @Import(module = "native", js = "() => { return window }")
    protected static native Object getWindow();

    @Import(module = "native", js = "w => { return w.document }")
    protected static native Object getWindowDocument(Object pointer);

    // ELEMENTS

    protected static String getElementTagName(Object pointer) {
        return getString(_getElementTagName(pointer));
    }

    protected static String getElementInnerText(Object pointer) {
        return getString(_getElementInnerText(pointer));
    }

    protected static void setElementInnerText(Object pointer, String value) {
        _setElementInnerText(pointer, toString(value));
    }

    protected static Object getDocumentCreateElement(char name) {
        return _getDocumentCreateElement((int) name);
    }

    protected static Object getDocumentCreateElement(String name) {
        return _getDocumentCreateElement(toString(name));
    }

    protected static Object getElementQuerySelector(Object pointer, String query) {
        return _getElementQuerySelector(pointer, toString(query));
    }

    protected static Object getDocumentCreateElement(Object pointer, char name) {
        return _getDocumentCreateElement(pointer, (int) name);
    }

    protected static Object getDocumentCreateElement(Object pointer, String name) {
        return _getDocumentCreateElement(pointer, toString(name));
    }

    protected static String getElementAttribute(Object pointer, String name) {
        return getString(_getElementAttribute(pointer, toString(name)));
    }

    protected static void setElementAttribute(Object pointer, String name, String value) {
        _setElementAttribute(pointer, toString(name), toString(value));
    }

    @Import(module = "native", name = "getElementBody", js = "e => e.body")
    protected static native Object getElementBody(Object pointer);

    @Import(module = "native", name = "getElementHead", js = "e => e.head")
    protected static native Object getElementHead(Object pointer);

    @Import(module = "native", name = "getElementParentElement", js = "e => e.parentElement")
    protected static native Object getElementParentElement(Object pointer);

    @Import(module = "native", name = "setElementRemove", js = "e => e.remove()")
    protected static native void setElementRemove(Object pointer);

    @Import(module = "native", name = "setElementAppend", js = "(o, c) => o.append(c)")
    protected static native void setElementAppend(Object pointer, Object child);

    @Import(module = "native", name = "getElementChildrenItem", js = "(e, i) => e.children.item(i)")
    protected static native Object getElementChildrenItem(Object pointer, int index);

    @Import(module = "native", name = "getElementChildrenLength", js = "e => e.children.length")
    protected static native int getElementChildrenLength(Object pointer);

    @Import(module = "native", name = "getElementTagName", js = "e => e.tagName")
    private static native Object _getElementTagName(Object pointer);

    @Import(module = "native", name = "setElementAttribute", js = "(e, n, v) => e.setAttribute(n, v)")
    private static native void _setElementAttribute(Object pointer, Object name, Object value);

    @Import(module = "native", name = "getElementAttribute", js = "(e, n) => e.getAttribute(n)")
    private static native Object _getElementAttribute(Object pointer, Object name);

    @Import(module = "native", name = "getElementInnerText", js = "e => e.innerText")
    private static native Object _getElementInnerText(Object pointer);

    @Import(module = "native", name = "setElementInnerText", js = "(o, v) => o.innerText = v")
    private static native Object _setElementInnerText(Object pointer, Object value);

    @Import(module = "native", name = "getDocumentCreateElement1", js = "n => document.createElement(String.fromCharCode(n))")
    private static native Object _getDocumentCreateElement(int name);

    @Import(module = "native", name = "getDocumentCreateElement2", js = "n => document.createElement(n)")
    private static native Object _getDocumentCreateElement(Object name);

    @Import(module = "native", name = "getDocumentCreateElement3", js = "(e, n) => e.createElement(String.fromCharCode(n))")
    private static native Object _getDocumentCreateElement(Object pointer, int name);

    @Import(module = "native", name = "getDocumentCreateElement4", js = "(o, n) => o.createElement(n)")
    private static native Object _getDocumentCreateElement(Object pointer, Object name);

    @Import(module = "native", name = "getElementQuerySelector", js = "(e, q) => e.querySelector(q)")
    private static native Object _getElementQuerySelector(Object pointer, Object query);

    // TRADUCAO

    protected static Object eval(String value) {
        return _eval(newObject(value));
    }

    protected static Object newObject(String value) {
        return toString(value);
    }

    protected static Object newObject(char value) {
        return toString(value);
    }

    @Import(module = "native", name = "newObject", js = "() => {}")
    static native Object newObject();

    @Import(module = "native", name = "newObject1", js = "i => i")
    protected static native Object newObject(int value);

    @Import(module = "native", name = "newObject2", js = "b => b === 1")
    protected static native Object newObject(boolean value);

    @Import(module = "native", name = "newObject3", js = "d => d")
    protected static native Object newObject(double value);

    @Import(module = "native", name = "isUndefined", js = "p => p === undefined")
    protected static native boolean isUndefined(Object pointer);

    @Import(module = "native", name = "callObject", js = "p => p()")
    static native Object callObject(Object pointer);

    @Import(module = "native", name = "callObject1", js = "(p, v) => p(v)")
    static native Object callObject(Object pointer, Object parameter);

    @Import(module = "native", name = "callObject2", js = "(p, v1, v2) => p(v1, v2)")
    static native Object callObject(Object pointer, Object parameter1, Object parameter2);

    @Import(module = "native", name = "getObjectProperty", js = "(o, k) => o[k]")
    static native Object getObjectProperty(Object pointer, Object key);

    @Import(module = "native", name = "setObjectProperty", js = "(o, k, v) => o[k] = v")
    static native void setObjectProperty(Object pointer, Object key, Object value);

    @Import(module = "native", name = "equals", js = "(o, p) => o === p")
    protected static native boolean equals(Object pointer1, Object pointer2);

    static Object toString(String value) {
        int[] result = new int[value.length()];
        for (int i = 0; i < value.length(); i++) {
            result[i] = (int) value.charAt(i);
        }
        return _getString(result);
    }

    static Object toString(char value) {
        int[] result = new int[1];
        result[0] = value;
        return _getString(result);
    }

    static String getString(Object pointer) {
        if (pointer != null) {
            int length = _getStringLength(pointer);
            if (length > 0) {
                String result = "";
                for (int i = 0; i < length; i++) {
                    result += (char) _getChar(pointer, i);
                }
                return result;
            }
        }
        return "";
    }

    @Import(module = "native", name = "getChar", js = "(s, i) => s.charCodeAt(i)")
    private static native int _getChar(Object pointer, int index);

    @Import(module = "native", name = "_getStringLength", js = "s => s.length")
    private static native int _getStringLength(Object pointer);

    @Import(module = "native", name = "setString", js = "v => { const l = []; for (let a of v[2]) { l.push(String.fromCharCode(a)); } return l.join(''); }")
    private static native Object _getString(int[] value);

    @Import(module = "native", name = "eval", js = "v => eval(v)")
    private static native Object _eval(Object value);
}
