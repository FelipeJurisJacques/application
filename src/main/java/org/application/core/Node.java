package org.application.core;

public class Node extends Native {
    protected Object pointer;

    public Node(Object pointer) {
        this.pointer = pointer;
    }

    public Object getPointer() {
        return this.pointer;
    }
}
