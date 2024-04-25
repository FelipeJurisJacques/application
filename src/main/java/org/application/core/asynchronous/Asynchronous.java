package org.application.core.asynchronous;

import java.util.List;
import java.util.ArrayList;

public class Asynchronous {
    // private static List<MessageObserver> handlers = new ArrayList<>();

    public static void subscribe(MessageObserver observer) {
        // handlers.add(observer);
    }

    public static void message(Object data, Object origin) {
        // for (int i = 0; i < handlers.size(); i++) {
        //     MessageObserver observer = handlers.get(i);
        //     if (observer.getOrigin().equals(origin)) {
        //         observer.notify(data);
        //     }
        // }
    }
}
