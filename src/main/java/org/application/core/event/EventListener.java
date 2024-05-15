package org.application.core.event;

import org.application.core.Native;
// import org.application.core.Console;
// import org.application.core.elements.Window;

/**
 * OUVINTE DE EVENTOS
 * 
 * toma acao a partir de qualquer evento recebido pelo js
 */
public abstract class EventListener extends Native {

    public static void eventDispatch(Object data) {
        // try {
        //     if (data == null) {
        //         throw new IllegalArgumentException("event not nullable");
        //     }
        //     String type = getEventType(data);
        //     if (type.equals("click")) {
        //         Window.eventDispatch(data);
        //     }
        // } catch (Throwable error) {
        //     Console.error(error);
        // }
    }
}
