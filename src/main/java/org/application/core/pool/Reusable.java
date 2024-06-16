package org.application.core.pool;

public class Reusable {
    private boolean disposed;

    protected Reusable() {
        disposed = false;
    }

    public boolean isDisposed() {
        return disposed;
    }

    public void dispose() {
        disposed = true;
    }

    public void reset() {
        disposed = false;
    }
}
