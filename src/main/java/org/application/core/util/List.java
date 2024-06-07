package org.application.core.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class List<V> implements Iterable<V> {
    private V value;
    private List<V> next;

    public List() {
        this.next = null;
        this.value = null;
    }
    
    public int length() {
        return size();
    }

    public void push(V value) {
        add(value);
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
            throw new IndexOutOfBoundsException("index greater than length");
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
            throw new IndexOutOfBoundsException("index greater than length");
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
            this.next.finalize();
            this.next = null;
        }
        if (this.value != null) {
            this.value = null;
        }
    }

    @Override
    public Iterator<V> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<V> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size();
        }

        @Override
        public V next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return get(index);
        }
    }
}
