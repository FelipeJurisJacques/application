package org.application.core.elements;

import org.application.core.Native;

public class Window extends Native {
    protected static Window window = new Window(getWindow());
    protected Object pointer;

    public static Window getInstance() {
        return window;
    }

    private Window(Object pointer) {
        this.pointer = pointer;
    }
}
