package org.application.core.util;

public class Map<K, V> {
    private K key;
    private V value;
    private Map<K, V> next;

    public Map() {
        this.key = null;
        this.next = null;
        this.value = null;
    }

    public void put(K key, V value) {
        if (this.key == null) {
            this.key = key;
            this.value = value;
        } else if (new Comparator<K>(this.key).compare(key)) {
            this.value = value;
        } else if (this.next == null) {
            this.next = new Map<K, V>();
            this.next.put(key, value);
        } else {
            this.next.put(key, value);
        }
    }

    public boolean has(K key) {
        if (this.key == null) {
            return false;
        }
        if (new Comparator<K>(this.key).compare(key)) {
            return true;
        }
        if (this.next == null) {
            return false;
        }
        return this.next.has(key);
    }

    public V get(K key) {
        if (this.key == null) {
            return null;
        }
        if (new Comparator<K>(this.key).compare(key)) {
            return this.value;
        }
        if (this.next == null) {
            return null;
        }
        return this.next.get(key);
    }

    @Override
    public void finalize() {
        if (this.key == null) {
            this.key = null;
        }
        if (this.next != null) {
            this.next.finalize();
            this.next = null;
        }
        if (this.value != null) {
            this.value = null;
        }
    }
}
