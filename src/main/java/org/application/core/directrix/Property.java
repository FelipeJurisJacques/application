package org.application.core.directrix;

import org.application.core.Console;
import org.application.core.asynchronous.Promise;

/**
 * PROPRIEDADE JAVA SCRIPT
 */
public class Property extends Directrix {
    private Object pointer;

    public static Property global(String value) {
        Object pointer = Directrix.global(value);
        if (isUndefined(pointer)) {
            return null;
        }
        return new Property(pointer);
    }

    public Property() {
        pointer = newObject();
    }

    public Property(Object pointer) {
        this.pointer = pointer;
    }

    public Property(int value) {
        pointer = newObject(value);
    }

    public Property(char value) {
        pointer = newObject(value);
    }

    public Property(boolean value) {
        pointer = newObject(value);
    }

    public Property(double value) {
        pointer = newObject(value);
    }

    public Property(String value) {
        pointer = newObject(value);
    }

    public String asString() {
        String value = getString(pointer);
        dispose();
        return value;
    }

    public Promise<Property> asPromise() {
        Promise<Property> promise = getPromise(pointer);
        dispose();
        return promise;
    }

    public boolean isNull() {
        return pointer == null;
    }

    public Property test() {
        return new Property(getObjectProperty(this, newObject("location")));
    }

    public Property get(char key) {
        return new Property(getObjectProperty(pointer, newObject(key)));
    }

    public Property get(String key) {
        return new Property(getObjectProperty(pointer, newObject(key)));
    }

    public Property put(String key, Property property) {
        return new Property(getObjectProperty(pointer, newObject(key)));
    }

    public void put(char key, Property property) {
        setObjectProperty(pointer, newObject(key), property.pointer);
        property.dispose();
    }

    public Property call() {
        Object result = callObject(pointer);
        if (isUndefined(result)) {
            return null;
        }
        return new Property(result);
    }

    public Property call(Property parameter) {
        Object result = callObject(pointer, parameter.pointer);
        parameter.dispose();
        if (isUndefined(result)) {
            return null;
        }
        return new Property(result);
    }

    public Property call(String parameter) {
        Object result = callObject(pointer, newObject(parameter));
        if (isUndefined(result)) {
            return null;
        }
        return new Property(result);
    }

    public Property call(Property parameter1, Property parameter2) {
        Object result = callObject(pointer, parameter1.pointer, parameter2.pointer);
        parameter1.dispose();
        parameter2.dispose();
        if (isUndefined(result)) {
            return null;
        }
        return new Property(result);
    }

    public Property call(String parameter1, Property parameter2) {
        Object result = callObject(pointer, newObject(parameter1), parameter2.pointer);
        parameter2.dispose();
        if (isUndefined(result)) {
            return null;
        }
        return new Property(result);
    }

    public void dispose() {
        pointer = null;
    }
}
