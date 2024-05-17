package org.application.core.util;

/**
 * @see primitive values
 */
public class Comparator<T> {
    private T value;

    public Comparator(T value) {
        this.value = value;
    }

    public boolean compare(T value) {
        if (value == null && this.value == null) {
            return true;
        }
        if (value == null || this.value == null) {
            return false;
        }
        if (value instanceof String && this.value instanceof String) {
            String k1 = (String) value;
            String k2 = (String) this.value;
            return k1.equals(k2);
        }
        return value == this.value;
    }

    @Override
    public void finalize() {
        if (this.value != null) {
            this.value = null;
        }
    }

    protected Comparator() {
        this.value = null;
    }

    protected T getValue() {
        return this.value;
    }

    protected void setValue(T value) {
        this.value = value;
    }
}
