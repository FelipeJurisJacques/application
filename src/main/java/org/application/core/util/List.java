package org.application.core.util;

public class List<V> {
    private V value;
    private List<V> next;

    public List() {
        this.next = null;
        this.value = null;
    }

    public void add(V value) {
        if (this.next == null) {
            this.next = new List<>();
            this.value = value;
        } else {
            this.next.add(value);
        }
    }

    public V get(int index) {
        if (this.next == null) {
            throw new IllegalArgumentException("index greater than length");
        }
        if (index == 0) {
            return this.value;
        }
        return this.next.get(index - 1);
    }

    public int size() {
        if (this.next == null) {
            return 0;
        }
        return 1 + this.next.size();
    }

    public void remove(int index) {
        if (this.next == null) {
            throw new IllegalArgumentException("index greater than length");
        }
        if (index == 0) {
            this.value = this.next.value;
            this.next = this.next.next;
        } else {
            this.next.remove(index - 1);
        }
    }

    @Override
    public void finalize() {
        if (this.next != null) {
            this.next = null;
        }
        if (this.value != null) {
            this.value = null;
        }
    }
}
