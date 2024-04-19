package org.application.web.events;

import org.application.web.libs.observer.Observer;

public class ActionListener implements Observer {
    protected String type;
    protected Object origin;

    public void actionPerformed(EventListener event) {
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    @Override
    public void notify(Object data) {
        // EventListener event = new EventListener(data);
        // if (
        //     (type == null || event.getType().equals(type))
        //     && (origin == null || event.getTarget().equals(origin))
        // ) {
        //     actionPerformed(event);
        // }
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setOrigin(Object origin) {
        this.origin = origin;
    }

    public String getType() {
        return type;
    }

    public Object getOrigin() {
        return origin;
    }
}
