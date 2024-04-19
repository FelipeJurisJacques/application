package org.application.web.libs;

public class Node extends Native {
    protected Object pointer;

    public Node(Object pointer) {
        this.pointer = pointer;
    }

    public Object getPointer() {
        return this.pointer;
    }

    public boolean equals(Node node) {
        return pointer.equals(node.getPointer());
    }

    public boolean equals(Object pointer) {
        return this.pointer.equals(pointer);
    }
}
