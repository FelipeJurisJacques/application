package org.application.core.util;

public class Map<K, V> extends Comparator<K> {
    private V value;
    private Map<K, V> next;

    public Map() {
        super();
        this.next = null;
        this.value = null;
    }

    public void put(K key, V value) {
        if (this.getValue() == null) {
            this.setValue(key);
            this.value = value;
        } else if (this.compare(key)) {
            this.value = value;
        } else if (this.next == null) {
            this.next = new Map<K, V>();
            this.next.put(key, value);
        } else {
            this.next.put(key, value);
        }
    }

    public V get(K key) {
        if (this.getValue() == null) {
            return null;
        }
        if (this.compare(key)) {
            return this.value;
        }
        if (this.next == null) {
            return null;
        }
        return this.next.get(key);
    }

    @Override
    public void finalize() {
        super.finalize();
        if (this.next != null) {
            this.next.finalize();
            this.next = null;
        }
        if (this.value != null) {
            this.value = null;
        }
    }
}
