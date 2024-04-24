package org.application.core.observer;

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
        for (int i = 0; i < handlers.size(); i++) {
            handlers.get(i).notify(data);
        }
    }
}
