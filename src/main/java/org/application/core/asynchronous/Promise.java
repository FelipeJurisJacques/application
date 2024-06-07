package org.application.core.asynchronous;

public class Promise<V> {
    protected V value;
    protected Throwable error;
    protected boolean disposed;
    protected boolean finished;
    protected ActionCatch rejected;
    protected ActionThen<V> resolved;

    public Promise() {
        this.error = null;
        this.value = null;
        this.rejected = null;
        this.resolved = null;
        this.disposed = false;
        this.finished = false;
    }

    public V await() throws Throwable {
        if (this.disposed) {
            throw new IllegalStateException("Promise finished");
        }
        while (!this.finished) {
            //
        }
        if (this.error != null) {
            Throwable error = this.error;
            this.dispose();
            throw error;
        } else {
            V value = this.value;
            this.dispose();
            return value;
        }
    }

    public void setThen(ActionThen<V> resolved) {
        if (this.disposed) {
            throw new IllegalStateException("Promise finished");
        }
        this.resolved = resolved;
        if (this.finished) {
            this.resolve(this.value);
        }
    }

    public void setCatch(ActionCatch rejected) {
        if (this.disposed) {
            throw new IllegalStateException("Promise finished");
        }
        this.rejected = rejected;
        if (this.finished) {
            this.reject(this.error);
        }
    }

    public void dispose() {
        this.value = null;
        this.error = null;
        this.disposed = true;
        this.finished = true;
        this.rejected = null;
        this.resolved = null;
    }

    public void resolve(V value) {
        if (!this.disposed) {
            if (this.resolved == null) {
                this.value = value;
            } else {
                try {
                    this.resolved.actionPerformed(value);
                    this.dispose();
                } catch (Throwable error) {
                    this.reject(error);
                }
            }
        }
    }

    public void reject(Throwable error) {
        if (!this.disposed) {
            if (this.rejected == null) {
                this.error = error;
            } else {
                try {
                    this.rejected.actionPerformed(error);
                } catch (Throwable e) {
                    //
                }
                this.dispose();
            }
        }
    }
}
