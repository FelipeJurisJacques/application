package org.application.core.asynchronous;

public interface MessageObserver {
    public void notify(Object data);

    public Object getOrigin();
}
