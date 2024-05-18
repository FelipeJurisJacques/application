package org.application.core.util;

class Item<V> {
    private V value;
    private Item<V> next;

    protected Item() {
        this.next = null;
        this.value = null;
    }

    protected void push(V value) {
        if (this.next == null) {
            this.next = new Item<>();
            this.value = value;
        } else {
            this.next.push(value);
        }
    }

    public V get(int index) {
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

    public int length() {
        return this.next == null ? 0 : this.next.length() + 1;
    }

    public void delete(int index) {
        if (index == 0) {
            this.value = null;
            Item<V> next = this.next;
            if (next != null) {
                this.next = next.next;
                next.next = null;
                next.value = null;
                next = null;
            }
        } else if (this.next == null) {
            throw new IllegalArgumentException("index greater than length");
        } else if (index > 0) {
            this.next.delete(index - 1);
        } else {
            throw new IllegalArgumentException("invalid index");
        }
    }

    @Override
    protected void finalize() {
        if (this.next != null) {
            this.next.finalize();
            this.next = null;
        }
        if (this.value != null) {
            this.value = null;
        }
    }
}
