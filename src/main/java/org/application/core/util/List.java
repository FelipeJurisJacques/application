package org.application.core.util;

public class List<V> {
    private Item<V> value;

    public List() {
        this.value = new Item<>();
    }

    public void add(V value) {
        this.value.push(value);
    }

    public V get(int index) {
        return this.value.get(index);
    }

    public int size() {
        return this.value.length();
    }

    public void remove(int index) {
        this.value.delete(index);
    }

    @Override
    public void finalize() {
        if (this.value != null) {
            this.finalize();
            this.value = null;
        }
    }
}
