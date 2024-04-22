package org.application.web.libs.observer;

import org.application.web.libs.Console;
import de.inetsoftware.jwebassembly.api.annotation.Export;

public class Notifier {
    static Subject subject = new Subject();

    @Export
    public static void message(Object data) {
        Console.log(data);
        subject.notify(data);
    }
}
