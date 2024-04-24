package org.application.core.event;

import org.application.core.Node;

public class ActionListener {
    protected String type;
    protected Node origin;

    public void actionPerformed(EventListener event) {
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setOrigin(Node origin) {
        this.origin = origin;
    }

    public String getType() {
        return type;
    }

    public Object getOrigin() {
        return origin;
    }
}
