package org.application.core.util;

public class List<T> {
    private T value;
    private List<T> next;

    public List() {
        this.next = null;
        this.value = null;
    }

    public void add(T value) {
        if (this.next == null) {
            this.next = new List<>();
            this.value = value;
        } else {
            this.next.add(value);
        }
    }

    public T get(int index) {
        if (index == 0) {
            return this.value;
        }
        if (this.next == null) {
            throw new IllegalArgumentException("index greater than length");
        }
        if (index > 0) {
            return this.next.get(index - 1);
        }
        throw new IllegalArgumentException("invalid index");
    }

    public int size() {
        int length = 0;
        List<T> next = this.next;
        while (next != null) {
            next = next.next;
            length += 1;
        }
        return length;
    }

    public void remove(int index) {
        if (index == 0) {
            this.value = null;
            List<T> next = this.next;
            if (next != null) {
                this.next = next.next;
                next.next = null;
                next.value = null;
                next = null;
            }
        } else if (this.next == null) {
            throw new IllegalArgumentException("index greater than length");
        } else if (index > 0) {
            this.next.remove(index - 1);
        } else {
            throw new IllegalArgumentException("invalid index");
        }
    }

    @Override
    public void finalize() {
        if (this.next != null) {
            this.next.finalize();
            this.next = null;
        }
        if (this.value != null) {
            this.value = null;
        }
    }
}
