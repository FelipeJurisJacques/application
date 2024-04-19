package org.application.web.libs.observer;

import de.inetsoftware.jwebassembly.api.annotation.Export;

public class Notifier {
    static Subject subject = new Subject();

    @Export
    public static void message(Object data) {
        subject.notify(data);
    }
}
