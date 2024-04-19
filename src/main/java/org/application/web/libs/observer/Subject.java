package org.application.web.libs.observer;

import java.util.List;
import java.util.ArrayList;

public class Subject {
    private List<Observer> handlers;

    public Subject() {
        handlers = new ArrayList<>();
    }

    public void subscribe(Observer observer) {
        handlers.add(observer);
    }

    public void notify(Object data) {
        // for (Observer handler : handlers) {
        //     handler.notify(data);
        // }
    }
}
