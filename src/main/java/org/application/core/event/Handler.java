package org.application.core.event;

class Handler {
    protected EventType type;
    protected ActionListener listener;

    public Handler(EventType type, ActionListener listener) {
        this.type = type;
        this.listener = listener;
    }

    @Override
    public void finalize() {
        this.type = null;
        this.listener = null;
    }  
}
