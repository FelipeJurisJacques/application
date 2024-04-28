package org.application.core.elements;

import org.application.core.Native;

public class Window extends Native {
    protected Object pointer;

    private Window(Object pointer) {
        this.pointer = pointer;
    }

    public Object getPointer() {
        return this.pointer;
    }
}
