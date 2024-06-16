package org.application.core.directrix;

import org.application.core.pool.Pool;

public class Property extends Directrix {
    private static Pool<Property> pool = new Pool<>();
    private Object pointer;

    public static Property acquire() {
        Property property = pool.acquire();
        if (property == null) {
            property = new Property();
        }
        property.pointer = newObject();
        return property;
    }

    public static Property acquire(Object pointer) {
        setConsoleLog(pointer);
        Property property = pool.acquire();
        if (property == null) {
            property = new Property();
        }
        property.pointer = pointer;
        return property;
    }

    public static Property acquire(int value) {
        return acquire(newObject(value));
    }

    public static Property acquire(char value) {
        return acquire(newObject(value));
    }

    public static Property acquire(boolean value) {
        return acquire(newObject(value));
    }

    public static Property acquire(double value) {
        return acquire(newObject(value));
    }

    public static Property acquire(String value) {
        return acquire(newObject(value));
    }

    public String asString() {
        _verify();
        String value = getString(pointer);
        dispose();
        return value;
    }

    public boolean isNull() {
        return pointer == null;
    }

    public Property get(char key) {
        _verify();
        return acquire(getObjectProperty(pointer, newObject(key)));
    }

    public Property get(String key) {
        _verify();
        return acquire(getObjectProperty(pointer, newObject(key)));
    }

    public Property put(String key, Property property) {
        _verify();
        return acquire(getObjectProperty(pointer, newObject(key)));
    }

    public void put(char key, Property property) {
        _verify();
        setObjectProperty(pointer, newObject(key), property.pointer);
        property.dispose();
    }

    public Property call() {
        _verify();
        Object result = callObject(pointer);
        if (isUndefined(result)) {
            return null;
        }
        return acquire(result);
    }

    public Property call(Property parameter) {
        _verify();
        Object result = callObject(pointer, parameter.pointer);
        parameter.dispose();
        if (isUndefined(result)) {
            return null;
        }
        return acquire(result);
    }

    public Property call(Property parameter1, Property parameter2) {
        _verify();
        Object result = callObject(pointer, parameter1.pointer, parameter2.pointer);
        parameter1.dispose();
        parameter2.dispose();
        if (isUndefined(result)) {
            return null;
        }
        return acquire(result);
    }

    public void dispose() {
        if (!isDisposed()) {
            super.dispose();
            pointer = null;
            pool.release(this);
        }
    }

    private void _verify() {
        if (isDisposed()) {
            throw new IllegalStateException("property finalized");
        }
    }
}
